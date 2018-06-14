package springcontextdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class StarTextDecorator implements TextDecorator {

    @Override
    public String decorate(String inputText){
        return ("***** " + inputText + " *****");
    }

}
