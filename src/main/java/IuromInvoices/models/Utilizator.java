package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "utilizatori")
public class Utilizator {

    @Id
    private UUID id;
    @Column(unique = true, nullable = false)
    private  String nume;
    @Column(unique = true, nullable = false)
    private  String mail;
    @Column(unique = true, nullable = false)
    private  String cui;
    @Column(nullable = false)
    private  String adresa;
    @Column(unique = true, nullable = false, name = "nrcont")
    private  String nrCont;

    @ManyToOne
    @JoinColumn(name = "idAbonament") //FK
    private Abonament abonament;

    public Utilizator() {}

    public Utilizator(@JsonProperty("nume") String nume,
                      @JsonProperty("mail") String mail,
                      @JsonProperty("cui") String cui,
                      @JsonProperty("adresa") String adresa,
                      @JsonProperty("nrCont") String nrCont) {
        this.nume = nume;
        this.mail = mail;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
    }

    public Utilizator(@JsonProperty("id") UUID id,
                      @JsonProperty("nume") String nume,
                      @JsonProperty("mail") String mail,
                      @JsonProperty("cui") String cui,
                      @JsonProperty("adresa") String adresa,
                      @JsonProperty("nrCont") String nrCont) {
        this.id = id;
        this.nume = nume;
        this.mail = mail;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public UUID getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public String getCui() {
        return cui;
    }

    public String getAdresa() {
        return adresa;
    }

    public String getNrCont() {
        return nrCont;
    }

}
