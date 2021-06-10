package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}
		// TODO Auto-generated method stub
		//doGet(request, response);
	}*/
	/*
	//リクエストパラメータを取得する
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("NAME");
	String position = request.getParameter("POSITION");

	//検索処理を行う
	ProfileDAO pDao = new ProfileDAO();
	List<Profile> List = pDao.select(new Profile(class,name,position))


	//検索結果をリクエストスコープに格納する
	request.setAttribute("",)

	//結果ページにフォワードする
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/profile/p_search_result.jsp");
	dispatcher.forward(request, response);*/
}