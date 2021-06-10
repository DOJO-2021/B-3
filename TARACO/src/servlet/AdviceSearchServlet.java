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

import dao.AdviceDAO;
import model.Advice;

/**
 * Servlet implementation class AdviceSearchServlet
 */
@WebServlet("/AdviceSearchServlet")
public class AdviceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/TARACO/LoginServlet");
				return;
			}
		// アドバイス検索ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/advice.jsp");
			dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/TARACO/LoginServlet");
					return;
				}


						// リクエストパラメータを取得する
						request.setCharacterEncoding("UTF-8");
						String comp_name = request.getParameter("COMP_NAME");
						String name = request.getParameter("NAME");
						String address = request.getParameter("ADDRESS");

				// 検索処理を行う
				AdviceDAO aDao = new AdviceDAO();
				List<Advice> cardList = aDao.select(new Advice(0,comp_name, "",name,"","", address,"","","","",""));

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);

				// アドバイス検索結果ページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_result.jsp");
				dispatcher.forward(request, response);
			}
		}