package jpademo;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="cursisten")
public class Cursist {

    @Id
    private int id;
    private String naam;
    private String organisatie;

    public Cursist(int id, String naam, String organisatie) {
        this.id = id;
        this.naam = naam;
        this.organisatie = organisatie;
    }

    public Cursist(int id, String naam, String organisatie, List<Diploma> diplomaList) {
        this.id = id;
        this.naam = naam;
        this.organisatie = organisatie;
        this.diplomaList = diplomaList;
        for ( Diploma diploma: this.diplomaList ) {
            diploma.setCursist(this);
        }
    }

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Version
    private long rowversion;

    @OneToMany(mappedBy= "cursist")
    private List<Diploma> diplomaList;

}
