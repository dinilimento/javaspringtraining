package jpademo;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
@Table(name="diplomas")
public class Diploma {

    @Id
    @GeneratedValue
    private int id;
    private String cursus;
    private double cijfer;

    @Getter(value = AccessLevel.NONE)
    @Setter(value = AccessLevel.NONE)
    @Version
    private long rowversion;

    @ManyToOne(optional = false)
    private Cursist cursist;

    public Diploma(String cursus, double cijfer) {
        this.cursus = cursus;
        this.cijfer = cijfer;
    }
}
