//メモ1
package test;
import java.util.List;

import dao.AdviceDAO;
import model.Advice;

public class AdviceDAOTest {
	public static void main(String[] args) {
		AdviceDAO dao = new AdviceDAO();
		//項目の作り替えをする！
		System.out.println("---------- select()のテスト ----------");
		List<Advice> cardList = dao.select(new Advice());
		//System.out.println(cardList.size());
		for (Advice card : cardList) {
			System.out.println(card.getAdv_id());
			System.out.println(card.getAdv_course());
			System.out.println(card.getAdv_year());
			System.out.println(card.getAdv_content());
			System.out.println();
			System.out.println();
			}
		// insert()のテスト登録のテスト
		System.out.println("---------- insert()のテスト ----------");
		Advice insRec = new Advice(-10, "サンプル", 3, "追加用プログラムテスト");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			}
		else {
			System.out.println("登録失敗！");
			}
		//挿入したレコードのIDを取得する
		int insAdv_id = insRec.getAdv_id();

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Advice upRec = new Advice(insAdv_id, "サンプル", 2, "追加用プログラムテスト(変更後)");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(insAdv_id)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}