package IuromInvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class ClientRequest {


    @NotBlank(message = "Numele clientului trebuie sa fie prezent!")
    private final String nume;
    @NotBlank
    private final String cui;
    @NotBlank
    private final String adresa;
    @NotBlank
    private final String nrCont;

    public ClientRequest(@JsonProperty("nume") String nume,
                  @JsonProperty("cui") String cui,
                  @JsonProperty("adresa") String adresa,
                  @JsonProperty("nrCont") String nrCont) {
        this.nume = nume;
        this.cui = cui;
        this.adresa = adresa;
        this.nrCont = nrCont;
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
