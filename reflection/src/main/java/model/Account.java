package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

/*
* DBDP Select 한 데이터를 다기 위한 오브젝트
*/

@ToString
@AllArgsConstructor
@Getter
public class Account {
    private int number;
    private String password;
    private int balance;

    //java.sql의 Timestamp

    private Timestamp createdAt;


}
