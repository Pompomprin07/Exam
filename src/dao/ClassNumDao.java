// 学級番号に関連する操作を管理

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ClassNum;
import bean.School;

public class ClassNumDao extends Dao {
	public ClassNum get(String class_num, School school) throws Exception {
	    // クラス番号インスタンスを初期化
	    ClassNum classNum = new ClassNum();
	    // データベースのコネクションを取得
	    Connection connection = getConnection();
	    // プリペアードステートメントを初期化
	    PreparedStatement statement = null;
	    try {
	        // プリペアードステートメントにSQL文をセット
	        statement = connection.prepareStatement("select * from class_num where class_num = ? and school_cd = ?");
	        // プリペアードステートメントに値をセット
	        statement.setString(1, class_num);
	        statement.setString(2, school.getCd());
	        // プリペアードステートメントを実行
	        ResultSet rSet = statement.executeQuery();
	        // SchoolDaoを初期化
	        SchoolDao sDao = new SchoolDao();
	        if (rSet.next()) {
	            // リザルトセットが存在する場合
	            // クラス番号インスタンスに検索結果をセット
	            classNum.setClass_num(rSet.getString("class_num"));
	            classNum.setSchool(sDao.get(rSet.getString("school_cd")));
	        } else {
	            // リザルトセットが存在しない場合
	            // クラス番号インスタンスにnullをセット
	            classNum = null;
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        // プリペアードステートメントを閉じる
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	        // コネクションを閉じる
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	    }
	    return classNum;
	}


	public List<String> filter(School school) throws Exception {
	    // リストを初期化
	    List<String> list = new ArrayList<>();
	    // データベースのコネクションを確立
	    Connection connection = getConnection();
	    // プリペアードステートメント
	    PreparedStatement statement = null;

	    try {
	    	System.out.println(school);
	        // プリペアードステートメントにSQL文をセット
	        statement = connection.prepareStatement("select class_num from class_num where school_cd=? order by class_num");
	        // プリペアードステートメントに学校コードをバインド
	        statement.setString(1, school.getCd());
	        // プリペアードステートメントを実行
	        ResultSet rSet = statement.executeQuery();

	        // リザルトセットを全件走査
	        while (rSet.next()) {
	            // リストにクラス番号を追加
	            list.add(rSet.getString("class_num"));
	        }
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        // プリペアードステートメントを閉じる
	        if (statement != null) {
	            try {
	                statement.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	        // コネクションを閉じる
	        if (connection != null) {
	            try {
	                connection.close();
	            } catch (SQLException sqle) {
	                throw sqle;
	            }
	        }
	    }

	    return list;
	}


   public boolean save(ClassNum classNum) throws Exception {

	  return false;

   }


    public boolean save(ClassNum classNum, String newClassNum) throws Exception {

    	return false;
    }
}