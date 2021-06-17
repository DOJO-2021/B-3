package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfileDAO;
import model.Profile;

/**
 * Servlet implementation class PSearchResultServlet
 */
@WebServlet("/PSearchResultServlet")
public class PSearchResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//プロフィール検索結果にフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/profile.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}*/

		//リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String user_name = request.getParameter("NAME");
				String user_position = request.getParameter("POSITION");
				String user_class = request.getParameter("CLASS");
				String user_gender = request.getParameter("GENDER");
				String user_major = request.getParameter("MAJOR");
				String user_hobby = request.getParameter("HOBBY");
				String user_personarity = request.getParameter("PERSONARITY");
				int user_star = Integer.parseInt(request.getParameter("STAR"));
				String user_remarks = request.getParameter("REMARKS");


				//検索処理を行う
				ProfileDAO pDao = new ProfileDAO();
				List<Profile> cardList = pDao.select(new Profile("","",user_name,user_position, user_class, user, "", "", "", 6, "", "", ""));


				//検索結果をリクエストスコープに格納する
				request.setAttribute("cardList",cardList);

				//個人プロフィールページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/profile.jsp");
				dispatcher.forward(request, response);
	}
}
