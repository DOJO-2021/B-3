package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.EditPw;

public class EditPwDAO {
	//運営Pwを取得するメソッド
	public String select() {
		Connection conn = null;
		String pass;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");
			// SQL文を準備する
			String sql = "SELECT * FROM edit_pw";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			rs.next();
			pass = rs.getString("adv_pw");
		} catch (SQLException e) {
			e.printStackTrace();
			pass = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pass = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					pass = null;
				}
			}
		}
		// 結果を返す
		return pass;
	}
	//ログイン処理用のメソッド ログインできるならtrueを返す
	public boolean pwOK(String adv_pw) {
		Connection conn = null;
		boolean pwResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/B-3/B-3", "sa", "sa");

			// SQL文を準備する
			String sql = "SELECT count(*) FROM edit_pw WHERE adv_pw=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, adv_pw);
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// パスワードが1件ヒットするかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				pwResult = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			pwResult = false;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			pwResult = false;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					pwResult = false;
				}
			}
		}
		// 結果を返す
		return pwResult;
	}

	// 引数pwで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(EditPw pw) {
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
			if (pw.getAdv_pw() != null) {
				pStmt.setString(1, pw.getAdv_pw());
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
