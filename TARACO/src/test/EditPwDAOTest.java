package test;

import dao.EditPwDAO;
import model.EditPw;

public class EditPwDAOTest {
	public static void main(String[] args) {
		EditPwDAO dao = new EditPwDAO();
		//adv_pwを取得するテスト
		System.out.println("---------- select()のテスト ----------");
		String pw = dao.select();
		System.out.println(pw);

		// 一致するpwかのテスト
		System.out.println("---------- pwOK()のテスト ----------");
		if (dao.pwOK("Password")) {
			System.out.println("パスワードあってます！");
		} else {
			System.out.println("そのパスワードは間違っています。");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		EditPw upRec = new EditPw("SamplePassword");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		} else {
			System.out.println("更新失敗！");
		}
	}
}
