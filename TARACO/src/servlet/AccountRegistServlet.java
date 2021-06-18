package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProfileDAO;
import model.Profile;
import model.Result;

/**
 * Servlet implementation class AccountRegistServlet
 */
@WebServlet("/AccountRegistServlet")
public class AccountRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 新規登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/account/account_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("USER_NAME");
		String user_position = request.getParameter("USER_POSITION");
		String user_id = request.getParameter("USER_ID");
		String user_pw = request.getParameter("USER_PW");


		// 新規登録処理を行う
		ProfileDAO pDao = new ProfileDAO();
		if (pDao.insert(new Profile(1, user_id, user_pw, user_name, user_position, "", "", "", "", "", 0, "", "", "CURRENT_TIMESTAMP"))) {//登録成功
			request.setAttribute("result",
					new Result("登録成功！", "アカウントを新規登録しました。", "/TARACO/LoginServlet"));
		} else { // 登録失敗
			request.setAttribute("result",
					new Result("登録失敗！", "アカウントを新規登録できませんでした。", "/TARACO/AccountRegistServlet"));
		}

		// 独自処理結果にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/original_result.jsp");
		dispatcher.forward(request, response);
	}

}
