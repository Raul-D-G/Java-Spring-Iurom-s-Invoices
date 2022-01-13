package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "abonamente")
public class Abonament {

    @Id
    private UUID id;
    @Column(unique = true, nullable = false)
    private String nume;
    @Column(nullable = false)
    private float pret;
    @Column(nullable = false)
    private Date valabilitate;
    @Column(nullable = false)
    private int limitaFacturi;

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

    public Abonament(@JsonProperty("id") UUID id,
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

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
