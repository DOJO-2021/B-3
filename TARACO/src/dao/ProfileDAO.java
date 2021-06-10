package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//ArrayListのスーパークラス↓
import java.util.List;

import model.Plofile;
public class ProfileDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Plofile> select(Plofile param) {
			Connection conn = null;
			List<Plofile> cardList = new ArrayList<Plofile>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3");
				// SQL文を準備する
				String sql = "SELECT user_id, user_pw, user_name, user_position, user_class, user_gender, user_major, user_hobby, user_personarity, user_star, user_remarks, user_photo, user_date FROM profile WHERE user_id LIKE ? AND user_pw LIKE ? AND user_name LIKE ? AND user_position LIKE ? AND user_class LIKE ? AND user_gender LIKE ? AND user_major LIKE ? AND user_hobby LIKE ? AND user_personarity LIKE ? AND user_star LIKE ? AND user_remarks LIKE ? AND user_remarks LIKE ? AND user_photo LIKE ? AND user_date LIKE ?";

				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				if (param.getUser_id() != null) {
					pStmt.setString(1, "%" + param.getUser_id() + "%");
				}
				else {
					pStmt.setString(1, "%");
				}
				if (param.getUser_pw() != null) {
					pStmt.setString(2, "%" + param.getUser_pw() + "%");
				}
				else {
					pStmt.setString(2, "%");
				}
				if (param.User_name() != null) {
					pStmt.setString(3, "%" + param.getUser_name() + "%");
				}
				else {
					pStmt.setString(3, "%");
				}
				if (param.getUser_position() != null) {
					pStmt.setString(4, "%" + param.getUser_position() + "%");
				}
				else {
					pStmt.setString(4, "%");
				}
				if (param.getUser_class() != null) {
					pStmt.setString(5, "%" + param.getUser_class() + "%");
				}
				else {
					pStmt.setString(5, "%");
				}
				if (param.getUser_gender() != null) {
					pStmt.setString(6, "%" + param.getUser_gender() + "%");
				}
				else {
					pStmt.setString(6, "%");
				}
				if (param.getUser_major() != null) {
					pStmt.setString(7, "%" + param.getUser_major() + "%");
				}
				else {
					pStmt.setString(7, "%");
				}
				if (param.getUser_hobby() != null) {
					pStmt.setString(8, "%" + param.getUser_hobby() + "%");
				}
				else {
					pStmt.setString(8, "%");
				}
				if (param.getUser_personarity() != null) {
					pStmt.setString(9, "%" + param.getUser_personarity() + "%");
				}
				else {
					pStmt.setString(9, "%");
				}if (param.getUser_star() != 0) {
					pStmt.setString(10, "%" + param.getUser_star() + "%");
				}
				else {
					pStmt.setString(10, "%");
				}if (param.getUser_remarks() != null) {
					pStmt.setString(11, "%" + param.getUser_remarks() + "%");
				}
				else {
					pStmt.setString(11, "%");
				}if (param.getUser_photo() != null) {
					pStmt.setString(12, "%" + param.getUser_photo() + "%");
				}
				else {
					pStmt.setString(12, "%");
				}if (param.getUser_date() != null) {
					pStmt.setString(13, "%" + param.getUser_date() + "%");
				}
				else {
					pStmt.setString(13, "%");
				}
					//pStmt.setInt(9, param.getId());



				// SQL文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();
				//↓ここも自分なりに変える
				// 結果表をコレクションにコピーする
				while (rs.next()) {
					Plofile card = new Plofile(
					rs.getInt("id"),
					rs.getString("company"),
					rs.getString("department"),
					rs.getString("name"),
					rs.getString("zipcode"),
					rs.getString("address"),
					rs.getString("phone"),
					rs.getString("email"),
					rs.getString("remarks")
					);
					cardList.add(card);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
				cardList = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				cardList = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						cardList = null;
					}
				}
			}

			// 結果を返す
			return cardList;
		}
			Connection conn = null;
			List<Plofile> cardList = new ArrayList<Plofile>();

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3");

				// SQL文を準備する
				String sql = "INSERT INTO Profile VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させるnullは飛ばすIDの部分
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
				if (card.User_name() != null) {
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
				if (card.getUser_class() != null) {
					pStmt.setString(5,card.getUser_class());
				}
				else {
					pStmt.setString(5, "%");
				}
				if (card.getUser_gender() != null) {
					pStmt.setString(6,card.getUser_gender());
				}
				else {
					pStmt.setString(6, "%");
				}
				if (card.getUser_major() != null) {
					pStmt.setString(7,card.getUser_major());
				}
				else {
					pStmt.setString(7, "%");
				}
				if (card.getUser_hobby() != null) {
					pStmt.setString(8,card.getUser_hobby());
				}
				else {
					pStmt.setString(8, "%");
				}
				if (card.getUser_personarity() != null) {
					pStmt.setString(9,card.getUser_personarity());
				}
				else {
					pStmt.setString(9, "%");
				}if (card.getUser_star() != null) {
					pStmt.setString(10,card.getUser_star());
				}
				else {
					pStmt.setString(10, "%");
				}if (card.getUser_remarks() != null) {
					pStmt.setString(11,card.getUser_remarks());
				}
				else {
					pStmt.setString(11, "%");
				}if (card.getUser_photo() != null) {
					pStmt.setString(12,card.getUser_photo());
				}
				else {
					pStmt.setString(12, "%");
				}if (card.getUser_date() != null) {
					pStmt.setString(13,card.getUser_date());
				}
				else {
					pStmt.setString(13, "%");
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
