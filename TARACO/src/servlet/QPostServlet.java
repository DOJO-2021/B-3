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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/q_post.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser) session.getAttribute("user_id");
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("Q_USER");
		String question = request.getParameter("QUESTION");
		String aAnswer = request.getParameter("A_ANSWER");
		String bAnswer = request.getParameter("A_ANSWER");
		String pass = request.getParameter("QUESTION_PASS");
		Question postQuestion = new Question();
		postQuestion.setQ_user(name);
		postQuestion.setQ_content(question);
		postQuestion.setQ_choice_a(aAnswer);
		postQuestion.setQ_choice_b(bAnswer);
		postQuestion.setQ_pw(pass);
		postQuestion.setUser_id(user.getUser_id());
		QuestionDAO qDAO = new QuestionDAO();
		qDAO.insert(postQuestion);
		Result result = new Result("アンケート投稿フォーム", "投稿が完了しました。", "");
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/other/result.jsp");
		dispatcher.forward(request, response);
	}

}
