//掲示板用のjavaBeans
package model;

import java.io.Serializable;

public class Billboard implements Serializable {
	private int q_id; //アンケートid
	private String q_date; //アンケート投稿日時
	private String q_user; //投稿者
	private String q_content; //質問内容
	private String q_choice_a;//Aの回答
	private String q_choice_b;//Bの回答
	private int a_responses; //回答人数
	private int a_responses_a;//Aの回答人数
	private int a_responses_b;//Bの回答人数
	private String q_pw;//削除用PWセットメソッドでのみ初期化可能
	private String a_already;//グレーアウト判定格納用変数セットメソッドでのみ初期化可能

	//引数があるコンストラクタ
	public Billboard(int q_id,
			String q_date, String q_user,
			String q_content, String q_choice_a, String q_choice_b,
			int a_responses, int a_responses_a, int a_responses_b) {
		super();
		this.q_id = q_id;
		this.q_date = q_date;
		this.q_user = q_user;
		this.q_content = q_content;
		this.q_choice_a = q_choice_a;
		this.q_choice_b = q_choice_b;
		this.a_responses = a_responses;
		this.a_responses_a = a_responses_a;
		this.a_responses_b = a_responses_b;
	}

	//引数がないコンストラクタ(デフォルトコンストラクタ)
	public Billboard() {
		super();
		this.q_id = 0;
		this.q_date = "";
		this.q_user = "";
		this.q_content = "";
		this.q_choice_a = "";
		this.q_choice_b = "";
		this.a_responses = 0;
		this.a_responses_a = 0;
		this.a_responses_b = 0;
	}

	//getter/setter
	public int getQ_id() {
		return q_id;
	}

	public void setQ_id(int q_id) {
		this.q_id = q_id;
	}

	public String getQ_date() {
		return q_date;
	}

	public void setQ_date(String q_date) {
		this.q_date = q_date;
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
		this.q_choice_a=q_choice_a;
	}

	public String getQ_choice_b() {
		return q_choice_b;
	}

	public void setQ_choice_b(String q_choice_b) {
		this.q_choice_b=q_choice_b;
	}

	public int getA_responses() {
		return a_responses;
	}

	public void setA_responses(int a_responses) {
		this.a_responses = a_responses;
	}

	public int getA_responses_a() {
		return a_responses_a;
	}

	public void setA_responses_a(int a_responses_a) {
		this.a_responses_a = a_responses_a;
	}

	public int getA_responses_b() {
		return a_responses_b;
	}

	public void setA_responses_b(int a_responses_b) {
		this.a_responses_b = a_responses_b;
	}
	public String getQ_pw() {
		return q_pw;
	}
	public void setQ_pw(String q_pw) {
		this.q_pw = q_pw;
	}
	public String getA_already() {
		return a_already;
	}
	public void setA_already(String a_already) {
		this.a_already = a_already;
	}
}