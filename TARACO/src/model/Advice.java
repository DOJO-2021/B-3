//メモ1
package model;
import java.io.Serializable;

	public class Advice implements Serializable {
		private int adv_id;
		private String adv_course;
		private int adv_year;
		private String adv_content;
		//private String adv_pw;

		//引数があるコンストラクタ #String adv_pw
		public Advice(int adv_id, String adv_course, int adv_year,
				String adv_content) {
			super();
			this.adv_id = adv_id;
			this.adv_course = adv_course;
			this.adv_year = adv_year;
			this.adv_content = adv_content;
			//this.adv_pw= adv_pw;
			}

		//引数がないコンストラクタ(デフォルトコンストラクタ)
		public Advice() {
			super();
			this.adv_id = 0;
			this.adv_course = "";
			this.adv_year = 0;
			this.adv_content = "";
			//this.adv_pw= "";
			}

		public int getAdv_id() {
			return adv_id;
		}

		public void setAdv_id(int adv_id) {
			this.adv_id = adv_id;
		}

		public String getAdv_course() {
			return adv_course;
		}

		public void setAdv_course(String adv_course) {
			this.adv_course = adv_course;
		}

		public int getAdv_year() {
			return adv_year;
		}

		public void setAdv_year(int adv_year) {
			this.adv_year = adv_year;
		}

		public String getAdv_content() {
			return adv_content;
		}

		public void setAdv_content(String adv_content) {
			this.adv_content = adv_content;
		}

		//public String getAdv_pw() {
			//return adv_pw;
		//}

		//public void setAdv_pw(String adv_pw) {
			//this.adv_pw = adv_pw;
		//}

}
