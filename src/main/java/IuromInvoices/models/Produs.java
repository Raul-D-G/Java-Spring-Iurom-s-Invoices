package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Produs {

    private final UUID id;
    @NotBlank
    private final String nume;
    private final float pret;
    private final int tva;
    private final int cantitate;
    @NotBlank
    private final String unitateMasura;
    private final String descriere;

    public Produs(@JsonProperty("id") UUID id,
                  @JsonProperty("nume") @NotBlank String nume,
                  @JsonProperty("pret") float pret,
                  @JsonProperty("tva") int tva,
                  @JsonProperty("cantitate") int cantitate,
                  @JsonProperty("unitateMasura") @NotBlank String unitateMasura,
                  @JsonProperty("descriere")  String descriere) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.tva = tva;
        this.cantitate = cantitate;
        this.unitateMasura = unitateMasura;
        this.descriere = descriere;
    }

    public UUID getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public float getPret() {
        return pret;
    }

    public int getTva() {
        return tva;
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
