//メモ
package model;
import java.io.Serializable;

public class Profile implements Serializable {
	private String user_id;
	private String user_pw;
	private String user_name;
	private String user_position;
	private String user_class;
	private String user_gender;
	private String user_major;
	private String user_hobby;
	private String user_personarity;
	private int user_star;
	private String user_remarks;
	private String user_photo;
	private String user_date;

	//引数があるコンストラクタ
		public Profile(String user_id, String user_pw, String user_name,
				String user_position, String user_class, String user_gender,
				String user_major, String user_hobby, String user_personarity,
				int user_star, String user_remarks, String user_photo, String user_date) {
			super();
			this.user_id = user_id;
			this.user_pw = user_pw;
			this.user_name = user_name;
			this.user_position = user_position;
			this.user_class = user_class;
			this.user_gender = user_gender;
			this.user_major = user_major;
			this.user_hobby = user_hobby;
			this.user_personarity = user_personarity;
			this.user_star = user_star;
			this.user_remarks = user_remarks;
			this.user_photo = user_photo;
			this.user_date = user_date;
			}

//引数がないコンストラクタ(デフォルトコンストラクタ)
		public Profile() {
			super();
			this.user_id = "";
			this.user_pw = "";
			this.user_name = "";
			this.user_position = "";
			this.user_class = "";
			this.user_gender = "";
			this.user_major = "";
			this.user_hobby = "";
			this.user_personarity = "";
			this.user_star = 0;
			this.user_remarks = "";
			this.user_photo = "";
			this.user_date = "";
			}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getUser_pw() {
			return user_pw;
		}

		public void setUser_pw(String user_pw) {
			this.user_pw = user_pw;
		}

		public String getUser_name() {
			return user_name;
		}

		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}

		public String getUser_position() {
			return user_position;
		}

		public void setUser_position(String user_position) {
			this.user_position = user_position;
		}

		public String getUser_class() {
			return user_class;
		}

		public void setUser_class(String user_class) {
			this.user_class = user_class;
		}

		public String getUser_gender() {
			return user_gender;
		}

		public void setUser_gender(String user_gender) {
			this.user_gender = user_gender;
		}

		public String getUser_major() {
			return user_major;
		}

		public void setUser_major(String user_major) {
			this.user_major = user_major;
		}

		public String getUser_hobby() {
			return user_hobby;
		}

		public void setUser_hobby(String user_hobby) {
			this.user_hobby = user_hobby;
		}

		public String getUser_personarity() {
			return user_personarity;
		}

		public void setUser_personarity(String user_personarity) {
			this.user_personarity = user_personarity;
		}

		public int getUser_star() {
			return user_star;
		}

		public void setUser_star(int user_star) {
			this.user_star = user_star;
		}

		public String getUser_remarks() {
			return user_remarks;
		}

		public void setUser_remarks(String user_remarks) {
			this.user_remarks = user_remarks;
		}

		public String getUser_photo() {
			return user_photo;
		}

		public void setUser_photo(String user_photo) {
			this.user_photo = user_photo;
		}

		public String getUser_date() {
			return user_date;
		}

		public void setUser_date(String user_date) {
			this.user_date = user_date;
		}
}