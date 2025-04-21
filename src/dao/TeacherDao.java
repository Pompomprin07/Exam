package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.School;
import bean.Teacher;



public class TeacherDao extends Dao{
	public Teacher get(String id) throws Exception{
		// 学校インスタンスを初期化
		Teacher teacher = new Teacher();
		// データベースへのコネクションを確立
		Connection connection = getConnection();
		// プリペアードステートメント
		PreparedStatement statement = null;

		try{
			// プリペアードステートメントにSQL文をセット
			statement = connection.prepareStatement("select * from teacher where id = ?");
			// プリペアードステートメントに学校コードをバインド
			statement.setString(1, id);
			// プリペアードステートメントを実行
			ResultSet rSet = statement.executeQuery();

			if (rSet.next()){
				// リザルトセットが存在する場合
				// 学校インスタンスに学校コードと学校名をセット
				teacher.setId(rSet.getString("id"));
				teacher.setName(rSet.getString("name"));

			} else {
				// 存在しない場合
				// 学校インスタンスをnullにセット
				teacher = null;
			}

		} catch(Exception e){
			throw e;
		}finally {
			// プリペアードステートメントを閉じる
			if (statement != null){
				try{
					statement.close();
				} catch (SQLException sqle){
					throw sqle;
				}
			}
			// コネクションを閉じる
			if (connection != null){
				try{
					connection.close();
				} catch (SQLException sqle){
					throw sqle;
				}
			}

		}
		return teacher;
	}

	public Teacher login(String id, String password) throws Exception {
	    // 教師インスタンスを初期化
	    Teacher teacher = null;

	    // データベースへの接続を確立
	    Connection connection = getConnection();
	    PreparedStatement statement = null;

	    try {
	        // SQLクエリを準備
	        statement = connection.prepareStatement("SELECT * FROM teacher WHERE id = ? AND password = ?");
	        // SQLクエリにパラメータをバインド
	        statement.setString(1, id);
	        statement.setString(2, password);

	        // クエリを実行
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            // 認証成功時の教師インスタンスを作成
	            teacher = new Teacher();
	            teacher.setId(resultSet.getString("id"));
	            teacher.setPassword(resultSet.getString("password")); // パスワードは保存しない方が良い場合もあります
	            teacher.setName(resultSet.getString("name"));
	            School school = new School();
	            school.setCd(resultSet.getString("school_cd").trim());
	            teacher.setSchool(school);



	        }

	    } catch (Exception e) {
	        throw e;
	    } finally {
	        // リソースを解放
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	    }

	    return teacher;
	}

}
