//メモ1
package model;
import java.io.Serializable;

	public class Answer implements Serializable {
		private int a_id;
		private int q_id;
		private String user_id;
		private String a_answer;

		//引数があるコンストラクタ
		public Answer(int a_id, int q_id, String user_id, String a_answer) {
			super();
			this.a_id = a_id;
			this.q_id = q_id;
			this.user_id = user_id;
			this.a_answer = a_answer;
			}

		//引数がないコンストラクタ(デフォルトコンストラクタ)
		public Answer() {
			super();
			this.a_id = 0;
			this.q_id = 0;
			this.user_id = "";
			this.a_answer = "";
			}

		public int getA_id() {
			return a_id;
		}

		public void setA_id(int a_id) {
			this.a_id = a_id;
		}

		public int getQ_id() {
			return q_id;
		}

		public void setQ_id(int q_id) {
			this.q_id = q_id;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getA_answer() {
			return a_answer;
		}

		public void setA_answer(String a_answer) {
			this.a_answer = a_answer;
		}

} //終わりのカッコ