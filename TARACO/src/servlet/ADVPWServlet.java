package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EditPwDAO;
import model.EditPw;
import model.Result;

/**
 * Servlet implementation class ADVPWServlet
 */
@WebServlet("/ADVPWServlet")
public class ADVPWServlet extends HttpServlet {
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

		// 運営PW変更ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/edit_pw.jsp");
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
						String adv_pw = request.getParameter("adv_pw");

						// ｐｗ更新を行う
						EditPwDAO eDao = new EditPwDAO();
						if (request.getParameter("SUBMIT").equals("変更")) {
							if (eDao.update(new EditPw(adv_pw))) {	// 更新成功
								request.setAttribute("result",
								new Result("変更完了", "パスワードを変更しました。", "/TARACO/HomeServlet"));
							}
							else {												// 更新失敗
								request.setAttribute("result",
								new Result("変更エラー", "パスワードを変更できませんでした。", "/TARACO/HomeServlet"));
							}
						}

						// 結果ページにフォワードする
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/result.jsp");
						dispatcher.forward(request, response);
					}
				}