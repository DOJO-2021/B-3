package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//ArrayListのスーパークラス↓
import java.util.List;

import model.Profile;

public class ProfileDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Profile> select(Profile param) {
		Connection conn = null;
		List<Profile> cardList = new ArrayList<Profile>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");
			// SQL文を準備する
			String sql = "SELECT user_id, user_pw, user_name, user_position, user_class, user_gender, user_major, user_hobby, user_personarity, user_star, user_remarks, user_photo, user_date FROM profile WHERE user_id LIKE ? AND user_pw LIKE ? AND user_name LIKE ? AND user_position LIKE ? AND user_class LIKE ? AND user_gender LIKE ? AND user_major LIKE ? AND user_hobby LIKE ? AND user_personarity LIKE ? AND user_star LIKE ? AND user_remarks LIKE ? AND user_remarks LIKE ? AND user_photo LIKE ? AND user_date LIKE ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (param.getUser_id() != null) {
				pStmt.setString(1, "%" + param.getUser_id() + "%");
			} else {
				pStmt.setString(1, "%");
			}
			if (param.getUser_pw() != null) {
				pStmt.setString(2, "%" + param.getUser_pw() + "%");
			} else {
				pStmt.setString(2, "%");
			}
			if (param.getUser_name() != null) {
				pStmt.setString(3, "%" + param.getUser_name() + "%");
			} else {
				pStmt.setString(3, "%");
			}
			if (param.getUser_position() != null) {
				pStmt.setString(4, "%" + param.getUser_position() + "%");
			} else {
				pStmt.setString(4, "%");
			}
			if (param.getUser_class() == null) {
				pStmt.setString(5, "%" + param.getUser_class() + "%");
			} else {
				pStmt.setString(5, "%");
			}
			if (param.getUser_gender() == null) {
				pStmt.setString(6, "%" + param.getUser_gender() + "%");
			} else {
				pStmt.setString(6, "%");
			}
			if (param.getUser_major() == null) {
				pStmt.setString(7, "%" + param.getUser_major() + "%");
			} else {
				pStmt.setString(7, "%");
			}
			if (param.getUser_hobby() == null) {
				pStmt.setString(8, "%" + param.getUser_hobby() + "%");
			} else {
				pStmt.setString(8, "%");
			}
			if (param.getUser_personarity() == null) {
				pStmt.setString(9, "%" + param.getUser_personarity() + "%");
			} else {
				pStmt.setString(9, "%");
			}
			if (param.getUser_star() == 0) {
				pStmt.setString(10, "%" + param.getUser_star() + "%");
			} else {
				pStmt.setString(10, "%");
			}
			if (param.getUser_remarks() == null) {
				pStmt.setString(11, "%" + param.getUser_remarks() + "%");
			} else {
				pStmt.setString(11, "%");
			}
			if (param.getUser_photo() == null) {
				pStmt.setString(12, "%" + param.getUser_photo() + "%");
			} else {
				pStmt.setString(12, "%");
			}
			if (param.getUser_date() == null) {
				pStmt.setString(13, "%" + param.getUser_date() + "%");
			} else {
				pStmt.setString(13, "%");
			}
			//pStmt.setInt(9, param.getId());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			//↓ここも自分なりに変える
			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Profile card = new Profile(
						rs.getString("user_id"),
						rs.getString("user_pw"),
						rs.getString("user_name"),
						rs.getString("user_position"),
						rs.getString("user_class"),
						rs.getString("user_gender"),
						rs.getString("user_major"),
						rs.getString("user_hobby"),
						rs.getString("user_personarity"),
						rs.getInt("user_star"),
						rs.getString("user_remarks"),
						rs.getString("user_photo"),
						rs.getString("user_date"));
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
	public boolean insert(Profile card) {
			Connection conn = null;
			boolean result = false;
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

				// SQL文を準備する
				String sql = "INSERT INTO Profile VALUES (?, ?, ?, ?, '', '', '', '', '', 0, '', '', CURRENT_TIMESTAMP)";

						PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getUser_id() != null) {
					pStmt.setString(1,card.getUser_id());
				}
				else {
					pStmt.setString(1, "%");
				}
				if (card.getUser_pw() != null) {
					pStmt.setString(2,card.getUser_pw());
				}
				else {
					pStmt.setString(2, "%");
				}
				if (card.getUser_name() != null) {
					pStmt.setString(3,card.getUser_name());
				}
				else {
					pStmt.setString(3, "%");
				}
				if (card.getUser_position() != null) {
					pStmt.setString(4,card.getUser_position());
				}
				else {
					pStmt.setString(4, "%");
				}
				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
		public boolean update(Profile card) {
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/B-3/B-3", "sa", "sa");

				// SQL文を準備する９個登録する
				String sql = "UPDATE Profile SET (user_id=?, user_pw=?, user_name?, user_position=?, user_class=?, user_gender=?, user_major=?, user_hobby=?, user_personarity=?, user_star=?, user_remarks=?, user_photo, CURRENT_TIMESTAMP WHERE user_id=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (card.getUser_id() != null) {
					pStmt.setString(1,card.getUser_id());
				} else {
					pStmt.setString(1, "%");
				}
				if (card.getUser_pw() != null) {
					pStmt.setString(2, "%" + card.getUser_pw());
				} else {
					pStmt.setString(2, "%");
				}
				if (card.getUser_name() != null) {
					pStmt.setString(3, "%" + card.getUser_name());
				} else {
					pStmt.setString(3, "%");
				}
				if (card.getUser_position() != null) {
					pStmt.setString(4, "%" + card.getUser_position());
				} else {
					pStmt.setString(4, "%");
				}
				if (card.getUser_class() == null) {
					pStmt.setString(5, "%" + card.getUser_class());
				} else {
					pStmt.setString(5, "%");
				}
				if (card.getUser_gender() == null) {
					pStmt.setString(6, "%" + card.getUser_gender());
				} else {
					pStmt.setString(6, "%");
				}
				if (card.getUser_major() == null) {
					pStmt.setString(7, "%" + card.getUser_major());
				} else {
					pStmt.setString(7, "%");
				}
				if (card.getUser_hobby() == null) {
					pStmt.setString(8, "%" + card.getUser_hobby());
				} else {
					pStmt.setString(8, "%");
				}
				if (card.getUser_personarity() == null) {
					pStmt.setString(9, "%" + card.getUser_personarity());
				} else {
					pStmt.setString(9, "%");
				}
				if (card.getUser_star() == 0) {
					pStmt.setString(10, "%" + card.getUser_star());
				} else {
					pStmt.setString(10, "%");
				}
				if (card.getUser_remarks() == null) {
					pStmt.setString(11, "%" + card.getUser_remarks());
				} else {
					pStmt.setString(11, "%");
				}
				if (card.getUser_photo() == null) {
					pStmt.setString(12, "%" + card.getUser_photo());
				} else {
					pStmt.setString(12, "%");
				}
				if (card.getUser_date() == null) {
					pStmt.setString(13, "%" + card.getUser_date());
				} else {
					pStmt.setString(13, "%");
				}
				//pStmt.setString(9, card.getBc_id());

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
		//ここまで完成1

		// 引数idで指定されたレコードを削除し、成功したらtrueを返す
		public boolean delete(int id)
			{
			Connection conn = null;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/simpleBC", "sa", "");

				// SQL文を準備する
				String sql = "DELETE FROM BC WHERE id=?";
				//↑追加するかも？company=?, department=?, name=?, zipcode=?, address=?, phone=?, email=?, remarks=?
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1, id);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}

			// 結果を返す
			return result;
		}
}