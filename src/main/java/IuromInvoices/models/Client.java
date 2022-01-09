package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Client {

    private UUID id;
    @NotBlank
    private final String nume;
    @NotBlank
    private final String cui;
    @NotBlank
    private final String adresa;
    @NotBlank
    private final String nrCont;

    public Client(@JsonProperty("nume") String nume,
                  @JsonProperty("cui") String cui,
                  @JsonProperty("adresa") String adresa,
                  @JsonProperty("nrCont") String nrCont) {
        this.nume = nume;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
    }

    public Client(@JsonProperty("id") UUID id,
                  @JsonProperty("nume") String nume,
                  @JsonProperty("cui") String cui,
                  @JsonProperty("adresa") String adresa,
                  @JsonProperty("nrCont") String nrCont) {
        this.id = id;
        this.nume = nume;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
    }

    public void setId(UUID id) {
        this.id = id;
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
