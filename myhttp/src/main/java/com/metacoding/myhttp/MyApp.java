package com.metacoding.myhttp;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyApp {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/todos/1"); // 소켓을 만들기 위한 객체 생성
            HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //서버 소켓에 연결
            //conn이 소켓이 됨 : Http 프로토콜이 적용된 것

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            String download = "";
            while(true) {
                String line = br.readLine();

                if(line == null) {
                    break;
                }
                download = download + line;
            }
            //System.out.println(download);

            ObjectMapper om = new ObjectMapper();
            Todo todo = om.readValue(download, Todo.class);

            System.out.println(todo.getTitle());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}