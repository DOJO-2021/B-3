package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProfileDAO;
import model.LoginUser;
import model.Profile;
import model.Result;

/**
 * Servlet implementation class MyPageServlet
 */
@WebServlet("/MyPageServlet")
@MultipartConfig

public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}

		//session.getAttribute("user_id")←セッションスコープから取得したuser_id。これをLoginUser型→String型に
		LoginUser user_id = (LoginUser)session.getAttribute("user_id");
		String myid = user_id.getUser_id();


		//そのidを基に検索し、その人の全プロフィール情報を得る
		ProfileDAO pDAO = new ProfileDAO();
		Profile myList = pDAO.select2(myid);


		//リクエストスコープに格納する
		request.setAttribute("myscope", myList); //mypage.jspでvalue="${myscope.○○}"を使う

		//マイページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mypage/mypage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @param user_date
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}

		request.setCharacterEncoding("UTF-8");

		if (request.getPart("USER_PHOTO") != null) {
			Part part = request.getPart("USER_PHOTO");
		}
		else {

		}
		Part part = request.getPart("USER_PHOTO");

		String photo_name = part.getSubmittedFileName();
		if (photo_name.indexOf(".png") != -1) {
			photo_name = request.getParameter("USER_ID") + ".png";
		}
		else if (photo_name.indexOf(".jpg") != -1) {
			photo_name = request.getParameter("USER_ID") + ".jpg";
		}
		else if (photo_name.indexOf(".jpeg") != -1) {
			photo_name = request.getParameter("USER_ID") + ".jpeg";
		}
		String path = getServletContext().getRealPath("/images/user_photo");
		System.out.println(path);
		part.write(path + File.separator + photo_name);

		//リクエストパラメータを取得する

		int profile_id = Integer.parseInt(request.getParameter("PROFILE_ID"));
		String user_id = request.getParameter("USER_ID");
		String user_pw = request.getParameter("USER_PW");
		String user_name = request.getParameter("USER_NAME");
		String user_position = request.getParameter("USER_POSITION");
		String user_class = request.getParameter("USER_CLASS");
		String user_gender = request.getParameter("USER_GENDER");
		String user_major = request.getParameter("USER_MAJOR");
		String user_hobby = request.getParameter("USER_HOBBY");
		String user_personarity = request.getParameter("USER_PERSONARITY");
		int user_star;
		if (request.getParameter("USER_STAR") == null) {
			user_star = 0;
		}
		else {
			user_star = Integer.parseInt(request.getParameter("USER_STAR"));
		}
		String user_remarks = request.getParameter("USER_REMARKS");
		String user_photo = photo_name;
		//String user_date = request.getParameter("USER_DATE");

		System.out.println(request.getParameter("SUBMIT"));
		System.out.println(request.getParameter("USER_ID"));



		// 更新または削除を行う
		ProfileDAO pDao = new ProfileDAO();
		if (request.getParameter("SUBMIT").equals("更新")) {
			if (pDao.update(new Profile(profile_id,user_id, user_pw, user_name, user_position, user_class, user_gender, user_major,
					user_hobby, user_personarity, user_star, user_remarks, user_photo, ""))) { // 更新成功
				request.setAttribute("result",
						new Result("更新成功！", "レコードを更新しました。", "/TARACO/HomeServlet"));
			} else { // 更新失敗
				request.setAttribute("result",
						new Result("更新失敗！", "レコードを更新できませんでした。", "/TARACO/HomeServlet"));
			}
		} else if(request.getParameter("SUBMIT").equals("アカウント削除")) {
			if (pDao.delete(profile_id)) { // 削除成功
				request.setAttribute("result",
						new Result("削除成功！", "レコードを削除しました。", "/TARACO/HomeServlet"));
			} else { // 削除失敗
				request.setAttribute("result",
						new Result("削除失敗！", "レコードを削除できませんでした。", "/TARACO/HomeServlet"));
			}
		}

		//処理結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/result.jsp");
		dispatcher.forward(request, response);
	}
}
