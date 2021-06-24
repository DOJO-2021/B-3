package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnswerDAO;
import dao.QuestionDAO;
import model.Answer;
import model.Billboard;
import model.Question;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}
		//現在投稿されているアンケートと対応する回答数のすべてをリスト形式で受け取る
		QuestionDAO qDAO = new QuestionDAO();
		AnswerDAO aDAO = new AnswerDAO();
		//アンケートリストを受け取る
		List<Question> questionList = qDAO.select(new Question());
		List<Billboard> billList = new ArrayList<Billboard>();
		for (Question q : questionList) {
			//アンケート文の先頭30文字分を表示
			int length = 30;
			String question = q.getQ_content();
			String q_date = q.getQ_date();
			if (question.length() > length) {
				q.setQ_content(question.substring(0, length) + "…");
			}

			q.setQ_date(q_date.substring(0, 19));//投稿日時のコンマ以下の部分を削除
			//回答数リストを受け取る
			List<Integer> count_responses = aDAO.select(new Answer(0, q.getQ_id(), "", ""));
			int count = count_responses.get(0);
			count_responses = aDAO.select(new Answer(0, q.getQ_id(), "", "A"));
			int countA = count_responses.get(0);
			billList.add(new Billboard(q.getQ_id(), q.getQ_date(), q.getQ_user(), q.getQ_content(), q.getQ_choice_a(),
					q.getQ_choice_b(), count, countA, count - countA));
		}
		request.setAttribute("billList", billList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/question.jsp");
		dispatcher.forward(request, response);
	}

}
