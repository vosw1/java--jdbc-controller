package ex02;

import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        String path = "/update-Password";

        UserController con = new UserController();

        Method[] methods = con.getClass().getDeclaredMethods();
        //System.out.println(methods.length);

        for (Method method : methods) {
            //System.out.println(method.getName());
            RequestMapping rm = method.getDeclaredAnnotation(RequestMapping.class);

            if (rm == null) continue;
            if (rm.uri().equals(path)) {// = con.login(); 과 같은 것
                try {
                    method.invoke(con);
                    break;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

