package db;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTset {

    // 리턴 타입을 적을 수 없다.
    // 매개변수를 적을 수 없다.
    // @Test 붙이면 메서드 별로 실행 가능
    @Test
    public void getInstance_test(){
        //given(파라미터 = 매개변수 -> 생략 가능)

        // when(본 코드 실행)
        Connection conn = DBConnection.getInstance();

        // then(검증) - 눈으로 검증
        if(conn == null){
            System.out.println("실패");
        } else {
            System.out.println("성공");
        }
    }
}
