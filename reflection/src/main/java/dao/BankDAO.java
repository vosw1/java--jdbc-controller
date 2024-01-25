package dao;

import db.DBConnection;
import model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *DAO -Data Access Object
 * SRP- 단일 책임 원칙
 */

public class BankDAO {

    public int deleteByNumber(int number) {

        Connection conn = DBConnection.getInstance();
        try {
            String sql="delete from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql); //SQL 문을 실행하기 위한 미리 준비된(prepared) 문장
            pstmt.setInt(1, number);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int insert(String password, int balance){
        Connection conn = DBConnection.getInstance();
        try {
            //now()는 위치에 따라 달라진다
            String sql="insert into account_tb(password, balance, created_at) values(?, ?, now())";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, password);
            pstmt.setInt(2, balance);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int updateByNumber(int balance, int number){
        Connection conn = DBConnection.getInstance();
        try {
            //now()는 위치에 따라 달라진다
            String sql="update account_tb set balance=? where number=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, balance);
            pstmt.setInt(2, number);
            int num = pstmt.executeUpdate();
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public Account selectByNumber(int number){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb where number = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, number);

            ResultSet rs = pstmt.executeQuery(); // 데이터베이스에서 쿼리를 실행한 결과를 담는 객체//찾은 행을 갯수를 리턴
            //pstmt.executeUpdate() 바뀐행을 갯수를 리턴
            //boolean isRow=rs.next(); //커서 한칸내리기 boolean타입인 이유 내려서 있으면 true없으면 false
            //연속적인 데이터가 모인 걸 벡터라고 함
            if (rs.next()){//초기화는 생성자로 해야함, setter도 가능함
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                return account;
            }
            //System.out.println(isRow);

            //pk이기 때문에 class에 담는다
//            System.out.println(rs.getInt("number"));
//            System.out.println(rs.getString("password"));
//            System.out.println(rs.getInt("balance"));
//            System.out.println(rs.getTimestamp("created_at"));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> selectAll(){
        Connection conn = DBConnection.getInstance();
        try {
            String sql = "select * from account_tb order by number desc"; //desc : 최근계좌를 먼저 보기위해서
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            List<Account> accountList=new ArrayList<>();

            //연속적인 데이터가 모인 걸 벡터라고 함
            /**
             * 데이터베이스에 몇 건의 데이터가 있는지 알 수 가 없음 → while을 false까지 돌려야 함
             * 다 같은 타입이 연속적으로 있기 때문에 벡터, 컬렉션에 담아야함
             * 연속적인 데이터 : 벡터
             * 하나의 데이터 : 스칼라
             * .은 스칼라 선은 벡터
             * 가로와 세로가 있으면 메트릭스
             */
            while (rs.next()){//초기화는 생성자로 해야함, setter도 가능함
                Account account = new Account(
                        rs.getInt("number"),
                        rs.getString("password"),
                        rs.getInt("balance"),
                        rs.getTimestamp("created_at")
                );
                accountList.add(account);
            }
            return accountList;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
