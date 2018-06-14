package springscopedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//@Scope("singleton")
public class Hitter {

    @Autowired
    private HitService hitService;

    private String name;

    public void hit(){
        hitService.hit();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHits(){
        return hitService.getTotalHits();
    }

}
