package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import model.Question;
/**
 * Servlet implementation class QAnswerServlet
 */
@WebServlet("/QAnswerServlet")
public class QAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QuestionDAO qDAO = new QuestionDAO();
		Question question = new Question();
		question.setQ_id(Integer.parseInt(request.getParameter("Q_ID")));
		List<Question> questionList = qDAO.select(question);
		question = questionList.get(0);
		request.setAttribute("question", question);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/q_answer.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("POST_QUESTION").equals("アンケート投稿")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/result_question.jsp");
				dispatcher.forward(request, response);
		}
	}

}
