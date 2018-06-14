package springcontextdemo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springconfig.SpringConfig;

public class springDemoTests {

    @Test
    public void maakHashtagTextdecoratorEnPrintText(){
        HashtagTextDecorator hashtagTextDecorator = new HashtagTextDecorator();
        System.out.println(hashtagTextDecorator.decorate("Cas"));
    }

    @Test
    public void maakTextProcessorMetHashtagDecorator(){
        TextProcessor textProcessor = new TextProcessor();
        TextDecorator textDecorator = new HashtagTextDecorator();

//        textProcessor.setTextDecorator(textDecorator);
//        textProcessor.processText("Rod Johnson");
    }

    @Test
    public void maakTextProcessorMetHashtagDecoratorViaSpringContextMetJavaConfig(){

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TextProcessor textProcessor = appContext.getBean(TextProcessor.class);
        textProcessor.processText("Rod Johnson");

    }

    @Test
    public void maakTextProcessorMetGeconfigureerdeStrategie(){
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        TextProcessor textProcessor = appContext.getBean(TextProcessor.class);
        textProcessor.processText("Rod Johnson");
        textProcessor.processText("Cas");


    }



}
