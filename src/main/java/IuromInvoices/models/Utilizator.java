package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "utilizatori")
public class Utilizator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private  String nume;
    @Column(unique = true, nullable = false)
    private  String mail;
    @Column(unique = true, nullable = false)
    private  String cui;
    @Column(nullable = false)
    private  String adresa;
    @Column(unique = true, nullable = false, name = "nr_cont")
    private  String nrCont;
    @NotNull
    private long idAbonament;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abonament_id", referencedColumnName = "id") //FK
    private Abonament abonament;

    @JsonIgnore
    @OneToMany(mappedBy = "utilizator")
    private Set<Factura> facturi;

    public Utilizator() {}

    public Utilizator(@JsonProperty("nume") String nume,
                      @JsonProperty("mail") String mail,
                      @JsonProperty("cui") String cui,
                      @JsonProperty("adresa") String adresa,
                      @JsonProperty("nrCont") String nrCont,
                      @JsonProperty("idAbonament") long idAbonament) {
        this.nume = nume;
        this.mail = mail;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
        this.idAbonament = idAbonament;
    }

    public Utilizator(@JsonProperty("id") long id,
                      @JsonProperty("nume") String nume,
                      @JsonProperty("mail") String mail,
                      @JsonProperty("cui") String cui,
                      @JsonProperty("adresa") String adresa,
                      @JsonProperty("nrCont") String nrCont,
                      @JsonProperty("idAbonament") long idAbonament) {
        this.id = id;
        this.nume = nume;
        this.mail = mail;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
        this.idAbonament = idAbonament;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public long getId() {
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

    public long getIdAbonament() {
        return idAbonament;
    }

    public void adaugaAbonament(Abonament abonament) {
        this.abonament = abonament;
    }

    public Abonament getAbonament() {
        return abonament;
    }
}
