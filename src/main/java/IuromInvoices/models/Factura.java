package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "facturi")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private long idUtilizator;
    @NotNull
    private UUID idClient;
    @NotNull
    private UUID idProdus;
    @NotNull
    private UUID idCurs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utilizator_id", referencedColumnName = "id")
    private Utilizator utilizator;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produs_id", referencedColumnName = "id")
    private Produs produs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "curs_id", referencedColumnName = "id")
    private Curs curs;


    public Factura(@JsonProperty("serie") String serie,
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

    public Factura(@JsonProperty("id") Long id,
                   @JsonProperty("serie") String serie,
                   @JsonProperty("nr") int nr,
                   @JsonProperty("dataEmitere") Date dataEmitere,
                   @JsonProperty("termenPlata") Date termenPlata,
                   @JsonProperty("delegat") String delegat,
                   @JsonProperty("tva") int tva,
                   @JsonProperty("idUtilizator") long idUtilizator,
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public void setUtilizator(Utilizator utilizator) {
        this.utilizator = utilizator;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setProdus(Produs produs) {
        this.produs = produs;
    }

    public void setCurs(Curs curs) {
        this.curs = curs;
    }
}
