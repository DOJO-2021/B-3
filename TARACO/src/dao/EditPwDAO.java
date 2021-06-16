package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//ArrayListのスーパークラス↓
import java.util.List;

import model.EditPw;

 public class EditPwDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<EditPw> select(EditPw param) {
		Connection conn = null;
		List<EditPw> cardList = new ArrayList<EditPw>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");
			// SQL文を準備する
			String sql = "SELECT * FROM edit_pw WHERE adv_pw=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getAdv_pw() != null) {
				pStmt.setString(1,  param.getAdv_pw());//完全に一致しないといけないから%なし
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				EditPw card = new EditPw(
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


	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(EditPw card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する
			String sql = "UPDATE edit_pw SET adv_pw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getAdv_pw() != null) {
				pStmt.setString(1, card.getAdv_pw());
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		// 結果を返す
		return result;
	}
}
