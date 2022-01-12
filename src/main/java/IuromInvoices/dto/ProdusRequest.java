package IuromInvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProdusRequest {

    @NotBlank(message = "Numele produsului trebuie sa fie prezent!")
    private final String nume;
    @Min(0)
    private final float pret;
    @Min(0)
    private final int cantitate;
    @NotBlank
    private final String unitateMasura;
    private final String descriere;

    public ProdusRequest(@JsonProperty("nume") @NotBlank String nume,
                  @JsonProperty("pret") float pret,
                  @JsonProperty("cantitate") int cantitate,
                  @JsonProperty("unitateMasura") @NotBlank String unitateMasura,
                  @JsonProperty("descriere")  String descriere) {
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.unitateMasura = unitateMasura;
        this.descriere = descriere;
    }


    public String getNume() {
        return nume;
    }

    public float getPret() {
        return pret;
    }

    public int getCantitate() {
        return cantitate;
    }

    public String getUnitateMasura() {
        return unitateMasura;
    }

    public String getDescriere() {
        return descriere;
    }
}
