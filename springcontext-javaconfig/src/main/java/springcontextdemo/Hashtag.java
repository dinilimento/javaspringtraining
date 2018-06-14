package springcontextdemo;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.CONSTRUCTOR, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Hashtag {
}
