//メモ1
package test;
import java.util.List;

import dao.AnswerDAO;
import model.Answer;

public class AnswerDAOTest {
	public static void main(String[] args) {
		AnswerDAO dao = new AnswerDAO();
		//項目の作り替えをする！
		System.out.println("---------- select()のテスト ----------");
		List<Answer> cardList = dao.select(new Answer(-1, 0, "", "A"));
		//System.out.println(cardList.size());
		for (Answer card : cardList) {
			System.out.println(card.getA_id());
			System.out.println(card.getQ_id());
			System.out.println(card.getUser_id());
			System.out.println(card.getA_answer());
			System.out.println();
			System.out.println();
			}
		// insert()のテスト登録のテスト
		System.out.println("---------- insert()のテスト ----------");
		Answer insRec = new Answer(-10, 0, "", "A");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			}
		else {
			System.out.println("登録失敗！");
			}
		//挿入したレコードのIDを取得する
		int insQ_id = insRec.getQ_id();

		// update()のテスト

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