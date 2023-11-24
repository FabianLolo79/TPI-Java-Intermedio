package entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;
    @ManyToMany(mappedBy = "servicios")
    private Set<Incidente> incidentes = new HashSet<>();
}
