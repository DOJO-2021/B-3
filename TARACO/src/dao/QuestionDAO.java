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

import model.Question;

public class QuestionDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Question> select(Question param) {
		Connection conn = null;
		List<Question> cardList = new ArrayList<Question>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");
			// SQL文を準備する
			String sql = "SELECT * FROM Question WHERE q_id LIKE ? ORDER BY q_id DESC";
			//ここまで完成

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//WHERE q_id LIKE ? オートインクリメント
			if (param.getQ_id() != 0) {
				pStmt.setString(1, "%" + param.getQ_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//↓ここも自分なりに変える
			// 結果表をコレクションにコピーする #rs.getString("adv_pw"));
			while (rs.next()) {
				Question card = new Question(
						rs.getInt("q_id"),
						rs.getString("user_id"),
						rs.getString("q_user"),
						rs.getString("q_content"),
						rs.getString("q_choice_a"),
						rs.getString("q_choice_b"),
						rs.getString("q_date"),
						//rs.getString("q_enddate"),
						rs.getString("q_pw"));
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
		public boolean insert(Question card) {
			Connection conn = null;
			boolean result = false;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

				// SQL文を準備する
				String sql = "INSERT INTO Question VALUES (?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, ?)";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getQ_id() >= 0) {
					pStmt.setNull(1, java.sql.Types.NULL);
				} else {
					pStmt.setInt(1, card.getQ_id());
				}
				if (card.getUser_id() != null) {
					pStmt.setString(2, card.getUser_id());
				} else {
					pStmt.setString(2, "%");
				}
				if (card.getQ_user() != null) {
					pStmt.setString(3, card.getQ_user());
				} else {
					pStmt.setString(3, "%");
				}
				if (card.getQ_content() != null) {
					pStmt.setString(4, card.getQ_content());
				} else {
					pStmt.setString(4, "%");
				}
				if (card.getQ_choice_a() != null) {
					pStmt.setString(5, card.getQ_choice_a());
				} else {
					pStmt.setString(5, "%");
				}
				if (card.getQ_choice_b() != null) {
					pStmt.setString(6, card.getQ_choice_b());
				} else {
					pStmt.setString(6, "%");
				}
				//if (card.getQ_date() != null) {
					//pStmt.setString(7, card.getQ_date());
				//} else {
					//pStmt.setString(7, "%");
				//}
				if (card.getQ_pw() != null) {
					pStmt.setString(7, card.getQ_pw());
				} else {
					pStmt.setString(7, "%");
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
		public boolean update(Question card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

				// SQL文を準備する
				String sql = "UPDATE Question SET user_id=?, q_user=?, q_content=?, q_choice_a=?, q_choice_b=?, q_date=CURRENT_TIMESTAMP, q_pw=? WHERE q_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getUser_id() != null) {
					pStmt.setString(1, card.getUser_id());
				} else {
					pStmt.setString(1, "%");
				}
				if (card.getQ_user() != null) {
					pStmt.setString(2, card.getQ_user());
				} else {
					pStmt.setString(2, "%");
				}
				if (card.getQ_content() != null) {
					pStmt.setString(3, card.getQ_content());
				} else {
					pStmt.setString(3, "%");
				}
				if (card.getQ_choice_a() != null) {
					pStmt.setString(4, card.getQ_choice_a());
				} else {
					pStmt.setString(4, "%");
				}
				if (card.getQ_choice_b() != null) {
					pStmt.setString(5, card.getQ_choice_b());
				} else {
					pStmt.setString(5, "%");
				}
				//if (card.getQ_date() != null) {
					//pStmt.setString(6, card.getQ_date());
				//} else {
					//pStmt.setString(6, "%");
				//}
				if (card.getQ_pw() != null) {
					pStmt.setString(6, card.getQ_pw());
				} else {
					pStmt.setString(6, "%");
				}
				if (card.getQ_id() != 0) {
					pStmt.setInt(7, card.getQ_id());
				} else {
					pStmt.setString(7, "%");
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
				String sql = "DELETE FROM Question WHERE q_id=?";
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
}//終わりのカッコ