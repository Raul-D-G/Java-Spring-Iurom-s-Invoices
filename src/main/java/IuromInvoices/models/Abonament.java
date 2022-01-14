package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "abonamente")
public class Abonament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String nume;
    @Column(nullable = false)
    private float pret;
    @Column(nullable = false)
    private Date valabilitate;
    @Column(nullable = false, name = "limita_facturi")
    private int limitaFacturi;

    @JsonIgnore
    @OneToMany(mappedBy = "abonament")
    private Set<Utilizator> utilizatori;

    public Abonament() {}

    public Abonament(@JsonProperty("nume") String nume,
                     @JsonProperty("pret") float pret,
                     @JsonProperty("valabilitate") Date valabilitate,
                     @JsonProperty("limitaFacturi") int limitaFacturi) {
        this.nume = nume;
        this.pret = pret;
        this.valabilitate = valabilitate;
        this.limitaFacturi = limitaFacturi;
    }

    public Abonament(@JsonProperty("id") long id,
                     @JsonProperty("nume") String nume,
                     @JsonProperty("pret") float pret,
                     @JsonProperty("valabilitate") Date valabilitate,
                     @JsonProperty("limitaFacturi") int limitaFacturi) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.valabilitate = valabilitate;
        this.limitaFacturi = limitaFacturi;
    }

    public String getNume() {
        return nume;
    }

    public float getPret() {
        return pret;
    }

    public Date getValabilitate() {
        return valabilitate;
    }

    public int getLimitaFacturi() {
        return limitaFacturi;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
