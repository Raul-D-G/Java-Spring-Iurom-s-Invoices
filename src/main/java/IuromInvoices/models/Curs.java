package IuromInvoices.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "curs")
public class Curs {

    @NotNull
    @Id
    private UUID id;
    @NotBlank
    private final String nume;
    @NotNull
    private final float paritate;

    @JsonIgnore
    @OneToMany(mappedBy = "curs")
    private Set<Factura> facturi;

    public Curs(@JsonProperty("nume") String nume,
                @JsonProperty("paritate") float paritate) {
        this.nume = nume;
        this.paritate = paritate;
    }

    public Curs(@JsonProperty("id") UUID id,
                @JsonProperty("nume") String nume,
                @JsonProperty("paritate") float paritate) {
        this.id = id;
        this.nume = nume;
        this.paritate = paritate;
    }

    public String getNume() {
        return nume;
    }

    public float getParitate() {
        return paritate;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

}
