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
		List<Integer> cardList = dao.select(new Answer(0, 0, "", "")); //0, 0, "", ""
		//System.out.println(cardList.size());
		for (Integer card : cardList) {
			System.out.println(card);
			System.out.println();
			System.out.println();
			}
		System.out.println("---------- select()のテスト2 ----------");
		List<Integer> cardList2 = dao.select(new Answer(0, 0, "", "A")); //0, 0, "", ""
		//System.out.println(cardList.size());
		for (Integer card : cardList2) {
			System.out.println(card);
			System.out.println();
			System.out.println();
			}
		// insert()のテスト登録のテスト
		System.out.println("---------- insert()のテスト ----------");
		Answer insRec = new Answer(-10, -1, "", "A");
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