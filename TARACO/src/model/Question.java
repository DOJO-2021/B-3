//メモ1
package model;
import java.io.Serializable;

	public class Question implements Serializable {
		private int q_id;
		private String user_id;
		private String q_user;
		private String q_content;
		private String q_choice_a;
		private String q_choice_b;
		private String q_date;
		//private String q_enddate;
		private String q_pw;


		//引数があるコンストラクタ #String q_enddate,
		public Question(int q_id, String user_id, String q_user, String q_content, String q_choice_a, String q_choice_b,
				String q_date, String q_pw) {
			super();
			this.q_id = q_id;
			this.user_id = user_id;
			this.q_user = q_user;
			this.q_content = q_content;
			this.q_choice_a = q_choice_a;
			this.q_choice_b = q_choice_b;
			this.q_date = q_date;
			//this.q_enddate = q_enddate;
			this.q_pw = q_pw;
			}

		//引数がないコンストラクタ(デフォルトコンストラクタ)
		public Question() {
			super();
			this.q_id = 0;
			this.user_id = "";
			this.q_content = "";
			this.q_choice_a = "";
			this.q_choice_b = "";
			this.q_date = "";
			//this.q_enddate = "";
			this.q_pw = "";
			//this.adv_pw= "";
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

		public String getQ_user() {
			return q_user;
		}

		public void setQ_user(String q_user) {
			this.q_user = q_user;
		}

		public String getQ_content() {
			return q_content;
		}

		public void setQ_content(String q_content) {
			this.q_content = q_content;
		}

		public String getQ_choice_a() {
			return q_choice_a;
		}

		public void setQ_choice_a(String q_choice_a) {
			this.q_choice_a = q_choice_a;
		}

		public String getQ_choice_b() {
			return q_choice_b;
		}

		public void setQ_choice_b(String q_choice_b) {
			this.q_choice_b = q_choice_b;
		}

		public String getQ_date() {
			return q_date;
		}

		public void setQ_date(String q_date) {
			this.q_date = q_date;
		}

		//public String getQ_enddate() {
			//return q_enddate;
		//}

		//public void setQ_enddate(String q_enddate) {
			//this.q_enddate = q_enddate;
		//}

		public String getQ_pw() {
			return q_pw;
		}

		public void setQ_pw(String q_pw) {
			this.q_pw = q_pw;
		}


}