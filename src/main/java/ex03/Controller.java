package ex03;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //런타임 실행시 -> 깃발을 꽂을때 하는 행위 = findUri
@Target(ElementType.TYPE) // 클래스 위에 붙일 때
public @interface Controller { //어노테이션 -> 깃발을 만드는 것

}
