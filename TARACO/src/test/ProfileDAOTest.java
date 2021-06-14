//メモ1
package test;
import java.util.List;

import dao.ProfileDAO;
import model.Profile;

public class ProfileDAOTest {
	public static void main(String[] args) {
		ProfileDAO dao = new ProfileDAO();
		//項目の作り替えをする！
		System.out.println("---------- select()のテスト ----------");
		List<Profile> cardList = dao.select(new Profile("ozeki", "", "", "", "", "", "", "", "", 0, "", "", ""));
		//System.out.println(cardList.size());
		for (Profile card : cardList) {
			System.out.println(card.getUser_id());
			System.out.println(card.getUser_pw());
			System.out.println(card.getUser_name());
			System.out.println(card.getUser_position());
			System.out.println(card.getUser_class());
			System.out.println(card.getUser_gender());
			System.out.println(card.getUser_major());
			System.out.println(card.getUser_hobby());
			System.out.println(card.getUser_personarity());
			System.out.println(card.getUser_star());
			System.out.println(card.getUser_remarks());
			System.out.println(card.getUser_photo());
			System.out.println(card.getUser_date());
			System.out.println();
			System.out.println();
			}
		// insert()のテスト登録のテスト 前から4項目追加される。
		System.out.println("---------- insert()のテスト ----------");
		Profile insRec = new Profile("TEST3", "TEST", "TEST", "TEST", "TEST", "男", "TEST", "TEST", "TEST", '3', "TEST", "TEST",  "CURRENT_TIMESTAMP");
		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			}
		else {
			System.out.println("登録失敗！");
			}
		//挿入したレコードのIDを取得する
		String insUser_id = insRec.getUser_id();

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Profile upRec = new Profile(insUser_id, "TEST", "TEST", "TEST", "TEST", "男", "TEST", "TEST", "TEST", 3, "TEST", "TEST",  "CURRENT_TIMESTAMP");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
		}
		else {
			System.out.println("更新失敗！");
		}

		// delete()のテスト
		System.out.println("---------- delete()のテスト ----------");
		if (dao.delete(insUser_id)) {
			System.out.println("削除成功！");
		}
		else {
			System.out.println("削除失敗！");
		}
	}
}
