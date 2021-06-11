//メモ1
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//ArrayListのスーパークラス↓
import java.util.List;

import model.Advice;


public class AdviceDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Advice> select(Advice param) {
		Connection conn = null;
		List<Advice> cardList = new ArrayList<Advice>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");
			// SQL文を準備する
			String sql = "SELECT * FROM advice WHERE adv_course LIKE=? AND adv_content LIKE=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getAdv_course() != null) {
				pStmt.setString(1, "%" + param.getAdv_course() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getAdv_content() != null) {
				pStmt.setString(2, "%" + param.getAdv_content() + "%");
			} else {
				pStmt.setString(2, "%");
			}
			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//↓ここも自分なりに変える
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Advice card = new Advice(
						rs.getInt("adv_id"),
						rs.getString("adv_course"),
						rs.getInt("adv_year"),
						rs.getString("adv_content"),
						rs.getString("adv_pw"));
				cardList.add(card);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}
		// 結果を返す
		return cardList;
	}

} //終わりのカッコ