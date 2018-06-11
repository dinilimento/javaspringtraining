package jdbcdemo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cursist {

    private int id;
    private String naam;
    private String organisatie;

}
