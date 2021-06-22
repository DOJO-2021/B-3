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
 * Servlet implementation class PSearchServlet
 */
@WebServlet("/PSearchServlet")
public class PSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		/*HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}*/

		//プロフィール検索にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/p_search.jsp");
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

		System.out.println(user_name);
		System.out.println(user_position);
		System.out.println(user_class);


		//検索処理を行う
		ProfileDAO pDao = new ProfileDAO();
		List<Profile> cardList = pDao.select(new Profile(0,"","",user_name,user_position, user_class, "", "", "", "", 6, "", "", ""));
		System.out.println(cardList.size());

		//検索結果をリクエストスコープに格納する
		request.setAttribute("cardList",cardList);


		//プロフィール検索結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/p_search_result.jsp");
		dispatcher.forward(request, response);
	}
}