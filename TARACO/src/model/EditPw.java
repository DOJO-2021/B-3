package model;

import java.io.Serializable;

public class EditPw implements Serializable {
	private String adv_pw;

	//引数があるコンストラクタ
	public EditPw(String adv_pw) {
		super();
		this.adv_pw = adv_pw;
	}

	//引数がないコンストラクタ(デフォルトコンストラクタ)
	public EditPw() {
		super();
		this.adv_pw = "";
	}

	//getter/setter
	public String getAdv_pw() {
		return adv_pw;
	}

	public void setAdv_pw(String adv_pw) {
		this.adv_pw = adv_pw;
	}
}