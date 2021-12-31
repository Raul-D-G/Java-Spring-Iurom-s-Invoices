package IuromInvoices.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Client {

    private final UUID id;
    private final String nume;
    private final String cui;
    private final String adresa;
    private final String nrCont;

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
