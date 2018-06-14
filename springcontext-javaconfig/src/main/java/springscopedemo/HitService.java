package springscopedemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
//@Scope("singleton")
public class HitService {

    private int totalHits;

    public void hit(){
        this.totalHits += 1;
    }

    public int getTotalHits(){
        return this.totalHits;
    }

}
