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
			String sql = "SELECT * FROM Advice WHERE adv_course LIKE ? AND adv_content LIKE ? ORDER BY adv_year DESC";

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
			// 結果表をコレクションにコピーする #rs.getString("adv_pw"));
			while (rs.next()) {
				Advice card = new Advice(
						rs.getInt("adv_id"),
						rs.getString("adv_course"),
						rs.getInt("adv_year"),
						rs.getString("adv_content"));
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

	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert(Advice card) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する
			String sql = "INSERT INTO Advice VALUES (?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getAdv_id() > 0) {
				pStmt.setNull(1, java.sql.Types.NULL);
			} else {
				pStmt.setInt(1, card.getAdv_id());
			}

			if (card.getAdv_course() != "") {
				pStmt.setString(2, card.getAdv_course());
			} else {
				pStmt.setString(2, null);
			}
			if (card.getAdv_year() != 0) {
				pStmt.setInt(3, card.getAdv_year());
			} else {
				pStmt.setString(3, "%");
			}
			if (card.getAdv_content() != "") {
				pStmt.setString(4, card.getAdv_content());
			} else {
				pStmt.setString(4, null);
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

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Advice card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する
			String sql = "UPDATE Advice SET adv_course=?, adv_year=?, adv_content=? WHERE adv_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getAdv_course() != "") {
				pStmt.setString(1, card.getAdv_course());
			} else {
				pStmt.setString(1, null);
			}
			if (card.getAdv_year() != 0) {
				pStmt.setInt(2, card.getAdv_year());
			} else {
				pStmt.setString(2, "%");
			}
			if (card.getAdv_content() != "") {
				pStmt.setString(3, card.getAdv_content());
			} else {
				pStmt.setString(3, null);
			}
			//if (card.getAdv_id() != 0) {
			//pStmt.setInt(4, card.getAdv_id());
			//} else {
			//pStmt.setString(4, "%");
			//}
			pStmt.setInt(4, card.getAdv_id());

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

	// 引数user_idで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(int adv_id) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する
			String sql = "DELETE FROM Advice WHERE adv_id=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, adv_id);

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




} //終わりのカッコ