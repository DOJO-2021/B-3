package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdviceDAO;
import model.Advice;
import model.Result;



/**
 * Servlet implementation class AdviceSearchServlet
 */
@WebServlet("/ADVRegistServlet")
public class ADVRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/TARACO/LoginServlet");
				return;
			}
*/
		// アドバイス登録ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_regist.jsp");
			dispatcher.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/*	// もしもログインしていなかったらログインサーブレットにリダイレクトする
				HttpSession session = request.getSession();
				if (session.getAttribute("id") == null) {
					response.sendRedirect("/TARACO/LoginServlet");
					return;
				}
*/

						// リクエストパラメータを取得する
						request.setCharacterEncoding("UTF-8");
						String adv_course = request.getParameter("adv_course");
						int adv_year =Integer.parseInt(request.getParameter("adv_year"));
						String content = request.getParameter("content");



						// 登録処理を行う
						AdviceDAO aDao = new AdviceDAO();
						if (aDao.insert(new Advice(0,adv_course,adv_year, content))) {	// 登録成功
							request.setAttribute("result",
							new Result("登録完了", "アドバイスを登録しました。", "/TARACO/MyPageServlet"));
						}
						else {												// 登録失敗
							request.setAttribute("result",
							new Result("登録エラー", "アドバイスを登録できませんでした。", "/TARACO/MyPageServlet"));
						}


						// 結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/result.jsp");
						dispatcher.forward(request, response);
					}

				}