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
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		QuestionDAO qDAO = new QuestionDAO();
		List<Question> questionList = qDAO.select(new Question());
		for (Question q : questionList) {
			int length = 30;
			String question = q.getQ_content();
			String q_date = q.getQ_date();
			;
			if (question.length() > length) {
				q.setQ_content(question.substring(0, length) + "…");
			}
			q.setQ_date(q_date.substring(0, 19));
		}
		request.setAttribute("questionList", questionList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/question.jsp");
		dispatcher.forward(request, response);
	}

}
