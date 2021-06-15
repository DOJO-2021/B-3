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

import model.Answer;

public class AnswerDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Answer> select(Answer param) {
		Connection conn = null;
		List<Answer> cardList = new ArrayList<Answer>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する このあたりのどこかがおかしい？
			String sql = "SELECT COUNT (*) FROM Answer WHERE a_id OR a_answer=? AND q_id=?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getA_id() != 0) {
				pStmt.setString(1, "%" + param.getA_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getA_answer() != null) {
				pStmt.setString(2, "%" + param.getA_answer() + "%");
			} else {
				pStmt.setString(2, "%");
			}
			if (param.getQ_id() != 0) {
				pStmt.setString(3, "%" + param.getQ_id() + "%");
			} else {
				pStmt.setString(3, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//↓ここも自分なりに変える
			// 結果表をコレクションにコピーする #rs.getString("adv_pw"));
			while (rs.next()) {
				Answer card = new Answer(
						rs.getInt("a_id"),
						rs.getInt("q_id"),
						rs.getString("user_id"),
						rs.getString("a_answer"));
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
	public boolean insert(Answer card) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する
			String sql = "INSERT INTO Answer VALUES (?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (card.getA_id() > 0) {
				pStmt.setNull(1, java.sql.Types.NULL);
			} else {
				pStmt.setInt(1, card.getA_id());
			}
			if (card.getQ_id() != 0) {
				pStmt.setInt(2, card.getQ_id());
			} else {
				pStmt.setString(2, "%");
			}
			if (card.getUser_id() != null) {
				pStmt.setString(3, card.getUser_id());
			} else {
				pStmt.setString(3, "%");
			}
			if (card.getA_answer() != null) {
				pStmt.setString(4, card.getA_answer());
			} else {
				pStmt.setString(4, "%");
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
	// 引数user_idで指定されたレコードを削除し、成功したらtrueを返す
			public boolean delete(int q_id) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

					// SQL文を準備する
					String sql = "DELETE FROM Answer WHERE q_id=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
					pStmt.setInt(1, q_id);

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