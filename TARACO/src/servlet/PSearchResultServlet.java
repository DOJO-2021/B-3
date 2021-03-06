package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}

		//リクエストパラメータを取得する
				//profile_idに変更 select1
						request.setCharacterEncoding("UTF-8");
						int profile_id = Integer.parseInt(request.getParameter("PROFILE_ID"));

						//検索処理を行う
						ProfileDAO pDao = new ProfileDAO();
						List<Profile> cardList = pDao.select1(new Profile(profile_id,"","","","", "", "", "", "", "", 0, "", "", ""));

						if(cardList.get(0).getUser_photo() == "") {
							cardList.get(0).setUser_photo("profile_default_photo.png");
						}

						//検索結果をリクエストスコープに格納する
						request.setAttribute("cardList",cardList);

						//個人プロフィールページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/profile.jsp");
						dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}

		//リクエストパラメータを取得する
		//profile_idに変更 select1
				request.setCharacterEncoding("UTF-8");
				int profile_id = Integer.parseInt(request.getParameter("ID"));

				//検索処理を行う
				ProfileDAO pDao = new ProfileDAO();
				List<Profile> cardList = pDao.select1(new Profile(profile_id,"","","","", "", "", "", "", "", 0, "", "", ""));


				//検索結果をリクエストスコープに格納する
				request.setAttribute("cardList",cardList);

				//個人プロフィールページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/profile.jsp");
				dispatcher.forward(request, response);
	}
}
