package IuromInvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CursRequest {

    @NotBlank
    private final String nume;
    @NotNull
    private final float paritate;

    public CursRequest(@JsonProperty("nume") String nume,
                       @JsonProperty("paritate") float paritate) {
        this.nume = nume;
        this.paritate = paritate;
    }

    public String getNume() {
        return nume;
    }

    public float getParitate() {
        return paritate;
    }

}
