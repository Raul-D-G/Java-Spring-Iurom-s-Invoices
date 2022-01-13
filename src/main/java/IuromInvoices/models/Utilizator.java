package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Utilizator {

    @NotNull
    private UUID id;
    @NotBlank
    private final String nume;
    @NotBlank
    private final String mail;
    @NotBlank
    private final String cui;
    @NotBlank
    private final String adresa;
    @NotBlank
    private final String nrCont;
    @NotNull
    private final UUID idAbonament;

    public Utilizator(@JsonProperty("nume") String nume,
                      @JsonProperty("mail") String mail,
                      @JsonProperty("cui") String cui,
                      @JsonProperty("adresa") String adresa,
                      @JsonProperty("nrCont") String nrCont,
                      @JsonProperty("idAbonament") UUID idAbonament) {
        this.nume = nume;
        this.mail = mail;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
        this.idAbonament = idAbonament;
    }

    public Utilizator(@JsonProperty("id") UUID id,
                      @JsonProperty("nume") String nume,
                      @JsonProperty("mail") String mail,
                      @JsonProperty("cui") String cui,
                      @JsonProperty("adresa") String adresa,
                      @JsonProperty("nrCont") String nrCont,
                      @JsonProperty("idAbonament") UUID idAbonament) {
        this.id = id;
        this.nume = nume;
        this.mail = mail;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
        this.idAbonament = idAbonament;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public UUID getIdAbonament() {
        return idAbonament;
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
