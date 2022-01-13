package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class Abonament {

    @NotNull
    private UUID id;
    @NotBlank
    private final String nume;
    @NotNull
    private final float pret;
    @NotNull
    private final Date valabilitate;
    @NotNull
    private final int limitaFacturi;

    public Abonament(@JsonProperty("nume") String nume,
                     @JsonProperty("pret") float pret,
                     @JsonProperty("valabilitate") Date valabilitate,
                     @JsonProperty("limitaFacturi") int limitaFacturi) {
        this.nume = nume;
        this.pret = pret;
        this.valabilitate = valabilitate;
        this.limitaFacturi = limitaFacturi;
    }

    public Abonament(@JsonProperty("id") UUID id,
                     @JsonProperty("nume") String nume,
                     @JsonProperty("pret") float pret,
                     @JsonProperty("valabilitate") Date valabilitate,
                     @JsonProperty("limitaFacturi") int limitaFacturi) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.valabilitate = valabilitate;
        this.limitaFacturi = limitaFacturi;
    }

    public String getNume() {
        return nume;
    }

    public float getPret() {
        return pret;
    }

    public Date getValabilitate() {
        return valabilitate;
    }

    public int getLimitaFacturi() {
        return limitaFacturi;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
