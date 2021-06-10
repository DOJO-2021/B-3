package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
			HttpSession session = request.getSession();
			if (session.getAttribute("id") == null) {
				response.sendRedirect("/TARACO/LoginServlet");
				return;
			}

		// アドバイス編集検索結果ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_edit_result.jsp");
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

						// 更新または削除を行う
						AdviceDAO aDao = new AdviceDAO();
						if (request.getParameter("SUBMIT").equals("更新")) {
							if (aDao.update(new Advice(bc_id,comp_name,dept_name, name, furigana, zip_code, address, phone, fax, email, date, remarks))) {	// 更新成功
								request.setAttribute("result",
								new Result("更新完了", "レコードを更新しました。", "/TARACO/MyPageServlet"));
							}
							else {												// 更新失敗
								request.setAttribute("result",
								new Result("更新エラー", "レコードを更新できませんでした。", "/TARACO/MyPageServlet"));
							}
						}
						else {
							if (aDao.delete(bc_id)) {	// 削除成功
								request.setAttribute("result",
								new Result("削除完了", "レコードを削除しました。", "/TARACO/MyPageServlet"));
							}
							else {						// 削除失敗
								request.setAttribute("result",
								new Result("削除エラー", "レコードを削除できませんでした。", "/TARACO/MyPageServlet"));
							}
						}

						// アドバイス結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/result_advice.jsp");
						dispatcher.forward(request, response);
					}
				}


