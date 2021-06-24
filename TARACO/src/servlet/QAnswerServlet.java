package servlet;

import java.io.IOException;
import java.sql.Timestamp;
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
import model.LoginUser;
import model.Question;
import model.Result;

/**
 * Servlet implementation class QAnswerServlet
 */
@WebServlet("/QAnswerServlet")
public class QAnswerServlet extends HttpServlet {
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
		LoginUser user = (LoginUser) session.getAttribute("user_id");

		QuestionDAO qDAO = new QuestionDAO();
		Question q = new Question();
		String judge = "false";

		q.setQ_id(Integer.parseInt(request.getParameter("Q_ID")));
		AnswerDAO aDAO = new AnswerDAO();
		Answer a = new Answer();
		a.setQ_id(Integer.parseInt(request.getParameter("Q_ID")));
		List<Question> questionList = qDAO.select(q);
		q = questionList.get(0);

		List<Integer> count_responses = aDAO.select(new Answer(0, q.getQ_id(), "", ""));
		int count = count_responses.get(0);
		count_responses = aDAO.select(new Answer(0, q.getQ_id(), "", "A"));
		int countA = count_responses.get(0);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String time = q.getQ_date();
		int[] deadTime = {
				Integer.parseInt(time.substring(0, 4)),
				Integer.parseInt(time.substring(5, 7)),
				Integer.parseInt(time.substring(8, 10)),
				Integer.parseInt(time.substring(11, 13)),
				Integer.parseInt(time.substring(14, 16)),
				Integer.parseInt(time.substring(17, 19)),
				0
		};
		long timemills =
				deadTime[5] * 1000 +
				deadTime[4] * 1000 * 60+
		Timestamp deadline = new Timestamp(
				deadTime[0],
				deadTime[1],
				deadTime[2],
				deadTime[3],
				deadTime[4],
				deadTime[5],
				deadTime[6]);
		if (aDAO.already(new Answer(0, q.getQ_id(), user.getUser_id(), ""))
				|| q.getUser_id().equals(user.getUser_id())) {
			judge = "true";
		}
		Billboard b = new Billboard(q.getQ_id(), q.getQ_date(), q.getQ_user(), q.getQ_content(), q.getQ_choice_a(),
				q.getQ_choice_b(), count, countA, count - countA);
		b.setQ_pw(q.getQ_pw());
		b.setA_already(judge);
		b.setUser_id(user.getUser_id());
		request.setAttribute("question", b);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/question/q_answer.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//もしもログインしていなかったらログインサーブレットにリダイレクトする
		HttpSession session = request.getSession();
		if (session.getAttribute("user_id") == null) {
			response.sendRedirect("/TARACO/LoginServlet");
			return;
		}
		LoginUser user = (LoginUser) session.getAttribute("user_id");
		Result result = new Result();
		request.setCharacterEncoding("UTF-8");
		AnswerDAO aDAO = new AnswerDAO();
		QuestionDAO qDAO = new QuestionDAO();
		String answer = request.getParameter("ANSWER");
		int q_id = Integer.parseInt(request.getParameter("Q_ID"));
		if (request.getParameter("ANSWER_QUESTION").equals("回答")) {
			if (aDAO.insert(new Answer(0, q_id, user.getUser_id(), answer))) {
				result.setTitle("アンケート回答");
				result.setMessage("正常に回答できました。");
				result.setBackTo("/TARACO/QAnswerServlet?Q_ID=" + request.getParameter("Q_ID"));
				request.setAttribute("result", result);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/other/original_result.jsp");
				dispatcher.forward(request, response);
			} else {
				result.setTitle("アンケート回答");
				result.setMessage("回答できませんでした。");
				result.setBackTo("/TARACO/QAnswerServlet?Q_ID=" + request.getParameter("Q_ID"));
				request.setAttribute("result", result);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/other/original_result.jsp");
				dispatcher.forward(request, response);
			}
		} else if (request.getParameter("ANSWER_QUESTION").equals("削除")) {
			if (qDAO.delete(q_id)) {
				aDAO.delete(q_id);
				result.setTitle("アンケート削除");
				result.setMessage("削除しました。");
				result.setBackTo("/TARACO/QuestionServlet?Q_ID");
				request.setAttribute("result", result);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/other/original_result.jsp");
				dispatcher.forward(request, response);
			} else {
				result.setTitle("アンケート削除");
				result.setMessage("削除できませんでした。");
				result.setBackTo("/TARACO/QAnswerServlet?Q_ID=" + request.getParameter("Q_ID"));
				request.setAttribute("result", result);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("/WEB-INF/jsp/other/original_result.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

}
