package springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springcontextdemo.HashtagTextDecorator;
import springcontextdemo.TextDecorator;
import springcontextdemo.TextProcessor;

@Configuration
@ComponentScan(value = {"springscopedemo", "springcontextdemo"})
public class SpringConfig {

//    @Bean
//    public TextDecorator textDecorator(){
//        return new TextDecorator();
//    }

//    @Bean
//    public TextProcessor textProcessor(){
//        return new TextProcessor(textDecorator());
//    }


//    @Bean
//    @Scope("prototype")
//    public HitService hitService() {
//        return new HitService();
//    }
//
//   @Bean()
//    public Hitter hitter() { return new Hitter(); }
//
//

//
//    @Bean Hitter hitter1(HitService hitService){
//        return new Hitter();
//    }
//
//    @Bean Hitter hitter2(HitService hitService){
//        return new Hitter();
//    }


}
