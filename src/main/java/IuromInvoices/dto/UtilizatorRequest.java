package IuromInvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UtilizatorRequest {

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
    private final long idAbonament;

    public UtilizatorRequest(@JsonProperty("nume") String nume,
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

    public String getMail() {
        return mail;
    }

    public long getIdAbonament() {
        return idAbonament;
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
