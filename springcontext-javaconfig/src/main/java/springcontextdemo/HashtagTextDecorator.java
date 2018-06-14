package springcontextdemo;

import org.springframework.stereotype.Component;

@Component
@Hashtag
public class HashtagTextDecorator implements TextDecorator {

    @Override
    public String decorate(String inputText){
        return ("### " + inputText + " ###");
    }

}
