package entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@S


@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int cuit;
    private String razon_social;
    private String domicilio;
    private String ciudad;
    private String email;
    private String telefono;
    @ManyToMany
    @JoinTable(
            name = "clientes_has_servicios",
            joinColumns = @JoinColumn(name="clientes_id"),
            inverseJoinColumns = @JoinColumn(name="servicios_id")
    )
    private Set<Servicio> servicios =new HashSet<Servicio>();

}
