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
@WebServlet("/ADVEditResultServlet")
public class ADVEditResultServlet extends HttpServlet {
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
		// アドバイス編集検索結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_edit_result.jsp");
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
							int adv_id =Integer.parseInt(request.getParameter("adv_id"));
							String adv_course = request.getParameter("adv_course");
							int adv_year =Integer.parseInt(request.getParameter("adv_year"));
							String content = request.getParameter("content");

						// 更新または削除を行う
						AdviceDAO aDao = new AdviceDAO();
						if (request.getParameter("SUBMIT").equals("更新")) {
							if (aDao.update(new Advice(adv_id,adv_course,adv_year,content))) {	// 更新成功
								request.setAttribute("result",
								new Result("更新完了", "レコードを更新しました。", "/TARACO/MyPageServlet"));
							}
							else {												// 更新失敗
								request.setAttribute("result",
								new Result("更新エラー", "レコードを更新できませんでした。", "/TARACO/MyPageServlet"));
							}
						}
						else {
							if (aDao.delete(adv_id)) {	// 削除成功
								request.setAttribute("result",
								new Result("削除完了", "レコードを削除しました。", "/TARACO/MyPageServlet"));
							}
							else {						// 削除失敗
								request.setAttribute("result",
								new Result("削除エラー", "レコードを削除できませんでした。", "/TARACO/MyPageServlet"));
							}
						}

						// アドバイス結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/result.jsp");
						dispatcher.forward(request, response);
					}
				}


