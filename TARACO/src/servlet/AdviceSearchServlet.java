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
import dao.EditPwDAO;
import model.Advice;
import model.EditPw;

/**
 * Servlet implementation class AdviceSearchServlet
 */
@WebServlet("/AdviceSearchServlet")
public class AdviceSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}

		//EditPwからadv_pwを取得
		EditPwDAO eDAO = new EditPwDAO();
		EditPw pw = new EditPw();
		pw.setAdv_pw(eDAO.select()); //DAOのselect()メソッドで取得

		//adv_pwをリクエストスコープpwscopeに格納する
		request.setAttribute("pwscope", pw);

		// アドバイス検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/advice.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String adv_course = request.getParameter("adv_course");
		String adv_content = request.getParameter("adv_content");

		// 検索処理を行う
		AdviceDAO aDao = new AdviceDAO();
		List<Advice> cardList = aDao.select(new Advice(0, adv_course, 0, adv_content));

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardList", cardList);
		request.setAttribute("adv_course", new String(adv_course));
		request.setAttribute("adv_content", new String(adv_content));

		// アドバイス検索結果ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/advice/adv_result.jsp");
		dispatcher.forward(request, response);
	}
}