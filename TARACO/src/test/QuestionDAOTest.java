//メモ1
package test;
import java.util.List;

import dao.QuestionDAO;
import model.Question;

public class QuestionDAOTest {
	public static void main(String[] args) {
		QuestionDAO dao = new QuestionDAO();
		//項目の作り替えをする！
		System.out.println("---------- select()のテスト ----------");
		List<Question> cardList = dao.select(new Question(-2, "", "", "", "", "", "", "0000"));
		//System.out.println(cardList.size());
		for (Question card : cardList) {
			System.out.println(card.getQ_id());
			System.out.println(card.getUser_id());
			System.out.println(card.getQ_user());
			System.out.println(card.getQ_choice_a());
			System.out.println(card.getQ_choice_b());
			System.out.println(card.getQ_date());
			System.out.println(card.getQ_pw());
			System.out.println();
			System.out.println();
			}
		// insert()のテスト登録のテスト
		System.out.println("---------- insert()のテスト ----------");
		Question insRec = new Question(-10, "test2021", "テストプログラム", "追加が出来るのかテストします", "Aに投票", "Bに投票", "CURRENT_TIMESTAMP", "0000");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			}
		else {
			System.out.println("登録失敗！");
			}
		//挿入したレコードのIDを取得する
		int insQ_id = insRec.getQ_id();

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Question upRec = new Question(insQ_id, "test2021", "テストプログラム", "更新が出来るのかテストします", "Aに投票", "Bに投票", "CURRENT_TIMESTAMP", "1234");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(insQ_id)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}