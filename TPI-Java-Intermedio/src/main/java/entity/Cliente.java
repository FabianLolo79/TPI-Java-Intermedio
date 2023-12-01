package entity;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private int id;
    private int cuit;
    private String razon_social;
    private String domicilio;
    private String ciudad;
    private String email;
    private String telefono;
    @OneToMany
    @JoinTable(
            name = "clientes_has_servicios",
            joinColumns = @JoinColumn(name="clientes_id"),
            inverseJoinColumns = @JoinColumn(name="servicios_id")
    )
    private Set<Servicio> servicios =new HashSet<Servicio>();

    @OneToMany(mappedBy = "cliente")
    private List<Incidente> incidentesSurgidos;
}
