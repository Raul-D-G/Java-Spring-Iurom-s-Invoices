package IuromInvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CursRequest {

    @NotBlank
    private final String nume;
    @NotBlank
    private final int paritate;

    public CursRequest(@JsonProperty("nume") String nume,
                       @JsonProperty("paritate") int paritate) {
        this.nume = nume;
        this.paritate = paritate;
    }

    public String getNume() {
        return nume;
    }

    public int getParitate() {
        return paritate;
    }

}
