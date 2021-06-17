package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdviceDAO;
import model.Advice;

/**
 * Servlet implementation class AdviceSearchServlet
 */
@WebServlet("/ADVEditSearchServlet")
public class ADVEditSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/TARACO/LoginServlet");
				return;
			}
*/
		// アドバイス編集検索ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_edit_search.jsp");
			dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/TARACO/LoginServlet");
					return;
				}
*/
						// リクエストパラメータを取得する
						request.setCharacterEncoding("UTF-8");
						String adv_course = request.getParameter("ADV_COURSE");
						String content = request.getParameter("CONTENT");


				// 検索処理を行う
				AdviceDAO aDao = new AdviceDAO();
				List<Advice> cardList = aDao.select(new Advice(0,adv_course,0,content));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);


				// AdvEditResultServletにリダイレクト？　アドバイス編集検索結果ページにフォワードする？
//				response.sendRedirect("/TARACO/ADVEditResultServlet");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_edit_result.jsp");
				dispatcher.forward(request, response);
			}
}

