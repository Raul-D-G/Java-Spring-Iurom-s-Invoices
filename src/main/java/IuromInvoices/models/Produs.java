package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "produse")
public class Produs {

    @Id
    private UUID id;
    @NotBlank
    private final String nume;
    private final float pret;
    private final int cantitate;
    @NotBlank
    @Column(unique = true, nullable = false, name = "unitatemasura")
    private final String unitateMasura;
    private final String descriere;

    @JsonIgnore
    @OneToMany(mappedBy = "produs")
    private Set<Factura> facturi;

    public Produs(@JsonProperty("nume") @NotBlank String nume,
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

    public Produs(@JsonProperty("id") UUID id,
                  @JsonProperty("nume") @NotBlank String nume,
                  @JsonProperty("pret") float pret,
                  @JsonProperty("cantitate") int cantitate,
                  @JsonProperty("unitateMasura") @NotBlank String unitateMasura,
                  @JsonProperty("descriere")  String descriere) {
        this.id = id;
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
        this.unitateMasura = unitateMasura;
        this.descriere = descriere;
    }

    public void setId(UUID id) { this.id = id; }

    public UUID getId() {
        return id;
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
