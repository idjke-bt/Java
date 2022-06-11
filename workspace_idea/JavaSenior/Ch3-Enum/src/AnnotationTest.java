import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * @author YangFeng
 * @create 2021-01-17 13:19
 */
public class AnnotationTest {

    public static void main(String[] args) {

        @SuppressWarnings("unused")
        int num = 10;


    }
}

@Retention(RetentionPolicy.SOURCE)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, MODULE})
@interface MyAnnotation{
    String value() default "hi";
}
