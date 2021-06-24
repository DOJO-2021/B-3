package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDAO;
import model.LoginUser;
import model.Question;
import model.Result;

/**
 * Servlet implementation class QPostServlet
 */
@WebServlet("/QPostServlet")
public class QPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}
		if(request.getAttribute("postQuestion") != null) {
			Question data = (Question)request.getAttribute("postQuestion");
			request.setAttribute("postQuestion", data);
		}else {
			request.setAttribute("postQuestion", new Question());
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/q_post.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}
		LoginUser user = (LoginUser) session.getAttribute("user_id");//セッションスコープに格納されているデータを受け取る
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("Q_USER");
		String question = request.getParameter("QUESTION");
		String aAnswer = request.getParameter("A_ANSWER");
		String bAnswer = request.getParameter("A_ANSWER");
		String pass = request.getParameter("QUESTION_PASS");

		//フォームとセッションスコープからのデータをBeansに格納
		Question postQuestion = new Question();
		postQuestion.setQ_user(name);
		postQuestion.setQ_content(question);
		postQuestion.setQ_choice_a(aAnswer);
		postQuestion.setQ_choice_b(bAnswer);
		postQuestion.setQ_pw(pass);
		postQuestion.setUser_id(user.getUser_id());

		QuestionDAO qDAO = new QuestionDAO();
		if (qDAO.insert(postQuestion)) {
			Result result = new Result("アンケート投稿フォーム", "投稿が完了しました。", "");
			request.setAttribute("result", result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/result.jsp");
			dispatcher.forward(request, response);
		}else {
			Result result = new Result("アンケート投稿フォーム", "投稿に失敗しました。", "/TARACO/QPostServlet");
			request.setAttribute("result", result);
			request.setAttribute("postQuestion", postQuestion);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/original_result.jsp");
			dispatcher.forward(request, response);
		}

	}

}
