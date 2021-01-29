package Project;

import java.sql.*;

public class ProDAO {

    Connection conn = null;

    PreparedStatement pstmt = null;

    ResultSet rs = null;

    public void connect() {

        conn = DBPro.DBConnect();

    }

    public void conClose() {

        try {
            conn.close();
        } catch (SQLException se) {

            se.printStackTrace();
        }
    }
    // 데이터 베이스 접속 / 해제

    // 회원가입
    // 로그인
    public int userNumber() {

        String sql = "SELECT COUNT(*) FROM GAME ";
        int userNum = 0;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                userNum = rs.getInt(1);
            }
        } catch (SQLException se) {
            
            se.printStackTrace();
        }
        return userNum;

    }

    // 고객정보
    public void userProfile(ProDTO user) {
        String sql = "INSERT INTO GAME VALUES(?,?,?,?,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getUserPw());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getUserAge());
            pstmt.setString(5, user.getUserEmail());
            pstmt.setString(6, user.getUserAccount());
            pstmt.setInt(7, user.getUserBalance());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("가입완료");
            } else {
                System.out.println("가입실패!");
            }
        } catch (SQLException se) {

            se.printStackTrace();
        }

    }

    // 가상계좌 입금
    public void deposit(ProDTO user) {

        String sql = "UPDATE GAME SET USER_BALANCE = USER_BALANCE + ? WHERE USER_ACCOUNT = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, user.getUserBalance());
            pstmt.setString(2, user.getUserAccount());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("가상계좌 충천완료");
            } else {
                System.out.println("충전실패! 계좌를 다시 확인해주세요.");
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return ;
    }

    public String checkProfile(String userId) {
        String sql = "SELECT*FROM PRODTO";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {

                System.out.print("아이디 : " + rs.getString(1));
                System.out.println("이름 : " + rs.getString(2));
                System.out.println("나이 : " + rs.getString(3));
                System.out.println("이메일 : " + rs.getString(4));

            }

        } catch (SQLException se) {

            se.printStackTrace();
        }

        return null;
    }

    // 로그인 확인
    public boolean userProfile(String userId, String userPw) {

        String sql = "SELECT USER_ID FROM GAME WHERE USER_ID=?";

        boolean userProfile = false;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, userId);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                userProfile = true;
                System.out.println(userId + " 님 안녕하세요.");

            } else {
                System.out.println("가입정보가 일치 하지 않습니다.");
                System.out.println("아이디와 비밀번호를 확인해주세요.");
            }
        } catch (SQLException se) {

            se.printStackTrace();
        }

        return userProfile;
    }

// 게임 검색
    public String gameSearch(String searchGam) {

        String sql = "SELECT * FROM SALE WHERE G_GENRE = ?";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, searchGam);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.println("게임코드 :" + rs.getString(1));
                System.out.println("게임장르 :" + rs.getString(2));
                System.out.println("게 임  명 :" + rs.getString(3));
                System.out.println("게임등급 :" + rs.getString(4));
                System.out.println("가       격 :" + rs.getString(5));
            }

        } catch (SQLException se) {

            se.printStackTrace();

        }
        return sql;

    }

// 마이페이지(회원정보 조회)
    public void userImformation(String userId, String userPw) {
        String sql = "SELECT *FROM GAME WHERE USER_ID =? AND USER_PW = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, userPw);

            rs = pstmt.executeQuery();

            while (rs.next()) {

                System.out.println("아 이 디 : " + rs.getString(1));
                System.out.println("이      름 : " + rs.getString(3));
                System.out.println("나      이 : " + rs.getString(4));
                System.out.println("E-MAIL: " + rs.getString(5));
                System.out.println("계좌번호 : " + rs.getString(6));
                System.out.println("현재잔액: " + rs.getString(7));
            }

        } catch (SQLException se) {

            se.printStackTrace();
        }

    }

    // 회원정보수정
    public void userProEX(ProDTO user) {
        String sql = "UPDATE GAME SET USER_NAME = ?, USER_AGE = ? , " + "USER_EMAIL = ? , USER_ACCOUNT = ? "
                + "WHERE USER_ID = ? AND USER_PW = ? ";

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getUserAge());
            pstmt.setString(3, user.getUserEmail());
            pstmt.setString(4, user.getUserAccount());
            pstmt.setString(5, user.getUserId());
            pstmt.setString(6, user.getUserPw());

            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("수정완료");
            } else {
                System.out.println("수정실패");
            }
        } catch (SQLException se) {

            se.printStackTrace();
        }

    }
//구매
//  public void purchase(String purchaseGam) {
//      
//      String sql = "SELECT * FROM SALE WHERE G_NAME = ?";
//
//      try {
//          pstmt = conn.prepareStatement(sql);
//
//          pstmt.setString(1, purchaseGam);
//
//          rs = pstmt.executeQuery();
//          while (rs.next()) {
//              System.out.println("게임코드 :" + rs.getString(1));
//              System.out.println("게임장르 :" + rs.getString(2));
//              System.out.println("게 임  명 :" + rs.getString(3));
//              System.out.println("게임등급 :" + rs.getString(4));
//              System.out.println("가       격 :" + rs.getString(5));
//          }
//
//      } catch (SQLException se) {
//
//          se.printStackTrace();
//
//      }
//      return;
//
//      
//  }

    public void purchase(String gameName, String userAccount) {
        
        String sql = "UPDATE GAME SET USER_BALANCE = USER_BALANCE - ? WHERE USER_ACCOUNT = ?";
        
        try {
            pstmt = conn.prepareStatement(sql);
            
            rs =pstmt.executeQuery();
            
            pstmt.setString(1, gameName);
            pstmt.setString(2, userAccount);
            
            int result = pstmt.executeUpdate();
            
            // 만약 회원나이가 19미만이면 19+ 게임을 못산다.->조건
            if(result > 0) {
                
                System.out.println("거래가 완료되었습니다.");
                
            }else{
                System.out.println("잔액이 부족하거나 계좌번흐를 확인해주십시요.");
            }
            
        } catch (SQLException se) {
            
            se.printStackTrace();
        }
        
    }

}
