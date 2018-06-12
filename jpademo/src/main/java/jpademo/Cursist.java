package jpademo;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

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

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Version
    private long rowversion;

}
