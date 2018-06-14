package springcontextdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TextProcessor {

    private Map<String,TextDecorator> textDecorators;

    public TextProcessor() {
    }

    @Autowired
//    @Hashtag
    public TextProcessor(Map<String, TextDecorator> textDecorators) {
        this.textDecorators = textDecorators;
    }

//    public void setTextDecorator(TextDecorator textDecorator) {
//        this.textDecorator = textDecorator;
//    }

    public void processText(String text){


        System.out.println("Er was eens...");

        if (text == "Cas"){
            System.out.println(textDecorators.get("hashtagTextDecorator").decorate(text));
        } else {
            System.out.println(textDecorators.get("starTextDecorator").decorate(text));
        }




        System.out.println("En ze leefden nog lang en gelukkig");
    }

}
