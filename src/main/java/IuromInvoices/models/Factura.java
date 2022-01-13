package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Factura {

    @NotNull
    private UUID id;
    @NotBlank
    private final String serie;
    @NotNull
    @Min(0)
    private final int nr;
    @NotBlank
    private final String dataEmitere;
    @NotBlank
    private final String termenPlata;
    @NotBlank
    private final String delegat;
    @NotNull
    @Min(0)
    @Max(24)
    private final int tva;
    @NotBlank
    private final UUID idUtilizator;
    @NotBlank
    private final UUID idClient;
    @NotBlank
    private final UUID idProdus;
    @NotBlank
    private final UUID idCurs;

    public Factura(@JsonProperty("serie") String serie,
                   @JsonProperty("nr") int nr,
                   @JsonProperty("dataEmitere") String dataEmitere,
                   @JsonProperty("termenPlata") String termenPlata,
                   @JsonProperty("delegat") String delegat,
                   @JsonProperty("tva") int tva,
                   @JsonProperty("idUtilizator") UUID idUtilizator,
                   @JsonProperty("idClient") UUID idClient,
                   @JsonProperty("idProdus") UUID idProdus,
                   @JsonProperty("idCurs") UUID idCurs) {

        this.serie = serie;
        this.nr = nr;
        this.dataEmitere = dataEmitere;
        this.termenPlata = termenPlata;
        this.delegat = delegat;
        this.tva = tva;
        this.idUtilizator = idUtilizator;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.idCurs = idCurs;
    }

    public Factura(@JsonProperty("id") UUID id,
                   @JsonProperty("serie") String serie,
                   @JsonProperty("nr") int nr,
                   @JsonProperty("dataEmitere") String dataEmitere,
                   @JsonProperty("termenPlata") String termenPlata,
                   @JsonProperty("delegat") String delegat,
                   @JsonProperty("tva") int tva,
                   @JsonProperty("idUtilizator") UUID idUtilizator,
                   @JsonProperty("idClient") UUID idClient,
                   @JsonProperty("idProdus") UUID idProdus,
                   @JsonProperty("idCurs") UUID idCurs) {
        this.id = id;
        this.serie = serie;
        this.nr = nr;
        this.dataEmitere = dataEmitere;
        this.termenPlata = termenPlata;
        this.delegat = delegat;
        this.tva = tva;
        this.idUtilizator = idUtilizator;
        this.idClient = idClient;
        this.idProdus = idProdus;
        this.idCurs = idCurs;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String getSerie() {
        return serie;
    }

    public int getNr() {
        return nr;
    }

    public String getDataEmitere() {
        return dataEmitere;
    }

    public String getTermenPlata() {
        return termenPlata;
    }

    public String getDelegat() {
        return delegat;
    }

    public int getTva() {
        return tva;
    }

    public UUID getIdUtilizator() {
        return idUtilizator;
    }

    public UUID getIdClient() {
        return idClient;
    }

    public UUID getIdProdus() {
        return idProdus;
    }

    public UUID getIdCurs() {
        return idCurs;
    }
}
