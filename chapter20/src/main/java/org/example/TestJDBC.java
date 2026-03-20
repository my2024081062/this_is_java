package org.example;

import java.sql.*;

public class TestJDBC {
    public void start(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. DB 연결
            String url = "jdbc:mysql://localhost:3306/myDataDatabase?serverTimezone=UTC";
            String id = "root";
            String pw = "1234";

            Connection conn = DriverManager.getConnection(url, id, pw);
            System.out.println("DB 연결 성공!");

            // 사용 후 연결 종료
            conn.close();

        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("DB 연결 실패: " + e.getMessage());
        }
    }
}
