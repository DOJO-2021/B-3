package test;

import java.util.List;

import dao.EditPwDAO;
import model.EditPw;

public class EditPwDAOTest {
	public static void main(String[] args) {
		EditPwDAO dao = new EditPwDAO();
		System.out.println("---------- select()のテスト ----------");
		List<EditPw> cardList = dao.select(new EditPw(""));
		for (EditPw card : cardList) {
			System.out.println(card.getAdv_pw());
			System.out.println();
			}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		EditPw upRec = new EditPw("SamplePassword");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

	}
}
