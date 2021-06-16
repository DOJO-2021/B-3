//掲示板用のjavaBeans
package model;

import java.io.Serializable;

public class Billboard implements Serializable {
	private int q_id; //アンケートid
	private String q_date; //アンケート投稿日時
	private String q_user; //投稿者
	private String q_content; //質問内容
	private int a_responses; //回答人数

	//引数があるコンストラクタ
	public Billboard(int q_id, String q_date, String q_user, String q_content, int a_responses) {
		super();
		this.q_id = q_id;
		this.q_date = q_date;
		this.q_user = q_user;
		this.q_content = q_content;
		this.a_responses = a_responses;
	}

	//引数がないコンストラクタ(デフォルトコンストラクタ)
	public Billboard() {
		super();
		this.q_id = 0;
		this.q_date = "";
		this.q_user = "";
		this.q_content = "";
		this.a_responses = 0;
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

	public int getA_responses() {
		return a_responses;
	}

	public void setA_responses(int a_responses) {
		this.a_responses = a_responses;
	}

}