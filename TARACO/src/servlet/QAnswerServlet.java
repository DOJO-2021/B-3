package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AnswerDAO;
import dao.QuestionDAO;
import model.Answer;
import model.Billboard;
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
		Question q = new Question();

		q.setQ_id(Integer.parseInt(request.getParameter("Q_ID")));
		AnswerDAO aDAO = new AnswerDAO();
		Answer a = new Answer();
		a.setQ_id(Integer.parseInt(request.getParameter("Q_ID")));
		List<Question> questionList = qDAO.select(q);
		q = questionList.get(0);
		List<Integer> count_responses = aDAO.select(new Answer(0, q.getQ_id(), "",""));
		int count = count_responses.get(0);
		count_responses = aDAO.select(new Answer(0, q.getQ_id(), "","A"));
		int countA = count_responses.get(0);
		Billboard b = new Billboard(q.getQ_id(), q.getQ_date(), q.getQ_user(), q.getQ_content(), q.getQ_choice_a(), q.getQ_choice_b(), count,countA, count - countA );
		b.setQ_pw(q.getQ_pw());
		request.setAttribute("question", b);
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
