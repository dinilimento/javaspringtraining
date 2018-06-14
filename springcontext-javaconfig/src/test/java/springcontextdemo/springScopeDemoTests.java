package springcontextdemo;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springconfig.SpringConfig;
import springscopedemo.Hitter;

public class springScopeDemoTests {

    @Test
    public void maakEenSingletonHitgeneratorMetEenSoortHitterOpContextEnVraagTotalHits(){
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Hitter hitter1 = appContext.getBean(Hitter.class);
        Hitter hitter2 = appContext.getBean(Hitter.class);

        for (int i = 0; i < 3 ; i++) {
            hitter1.hit();
        }

        for (int i = 0; i < 2 ; i++) {
            hitter2.hit();
        }

        System.out.println("Hitter 1: " + hitter1.getHits());
        System.out.println("Hitter 2: " + hitter2.getHits());

    }


    @Test
    public void maakEenSingletonHitgeneratorMetMeerHittersOpContextEnVraagTotalHits(){
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Hitter hitter1 = appContext.getBean("hitter1", Hitter.class);
        Hitter hitter2 = appContext.getBean("hitter2", Hitter.class);

        for (int i = 0; i < 3 ; i++) {
            hitter1.hit();
        }

        for (int i = 0; i < 2 ; i++) {
            hitter2.hit();
        }

        System.out.println("Hitter 1: " + hitter1.getHits());
        System.out.println("Hitter 2: " + hitter2.getHits());

    }



    @Test
    public void regelAllesZonderDeConfigTeGebruiken(){
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("springscopedemo");
        appContext.refresh();
        Hitter hitter1 = appContext.getBean(Hitter.class);
        Hitter hitter2 = appContext.getBean(Hitter.class);

        hitter1.setName("Hitter 1");
        hitter2.setName("Hitter 2");

        for (int i = 0; i < 3 ; i++) {
            hitter1.hit();
            System.out.println("From hitter 1 loop: my name is " + hitter1.getName());
            System.out.println("From injected service: hitter 1: " + hitter1.getHits());
            System.out.println("From injected service: hitter 2: " + hitter2.getHits());
        }

        for (int i = 0; i < 2 ; i++) {
            hitter2.hit();
            System.out.println("From hitter 2 loop: my name is " + hitter2.getName());
            System.out.println("From injected service: hitter 1: " + hitter1.getHits());
            System.out.println("From injected service: hitter 2: " + hitter2.getHits());
        }

        System.out.println("Hitter 1: " + hitter1.getHits());
        System.out.println("Hitter 2: " + hitter2.getHits());

    }

}
