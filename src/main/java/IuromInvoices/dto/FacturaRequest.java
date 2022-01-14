package IuromInvoices.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

public class FacturaRequest {

    @NotBlank
    private final String serie;
    @NotNull
    @Min(0)
    private final int nr;
    @NotNull
    private final Date dataEmitere;
    @NotNull
    private final Date termenPlata;
    @NotBlank
    private final String delegat;
    @NotNull
    @Range(min = 0, max = 24)
    private final int tva;
    @NotNull
    private final long idUtilizator;
    @NotNull
    private final UUID idClient;
    @NotNull
    private final UUID idProdus;
    @NotNull
    private final UUID idCurs;

    public FacturaRequest(@JsonProperty("serie") String serie,
                   @JsonProperty("nr") int nr,
                   @JsonProperty("dataEmitere") Date dataEmitere,
                   @JsonProperty("termenPlata") Date termenPlata,
                   @JsonProperty("delegat") String delegat,
                   @JsonProperty("tva") int tva,
                   @JsonProperty("idUtilizator") long idUtilizator,
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

    public String getSerie() {
        return serie;
    }

    public int getNr() {
        return nr;
    }

    public Date getDataEmitere() {
        return dataEmitere;
    }

    public Date getTermenPlata() {
        return termenPlata;
    }

    public String getDelegat() {
        return delegat;
    }

    public int getTva() {
        return tva;
    }

    public long getIdUtilizator() {
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
