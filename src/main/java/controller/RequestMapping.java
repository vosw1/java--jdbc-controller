package controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RequestMapping { // 어노테이션
    //인터페이스앞에 @interface annotation
    //발동시점을 정해야함 힌트를 컴파일시점에서 보고 작동함
    String uri();
}
