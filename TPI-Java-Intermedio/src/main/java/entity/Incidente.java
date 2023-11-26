package entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;

@Setter
@Getter
@AllArgsConstructor

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "empleados_id")
    private Empleado tecnicoAsignado;

    @Column(name = "resolution_time") // en horas
    private int resolutionTime;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String descripcion;

    @Column(name = "observation_tecnico")
    private String observacionTecnico;

    @Column(name = "create_at")
    private Date createAt;

    @ManyToOne
    @JoinColumn(name = "ordenes_trabajo_id")
    private OrdenDeTrabajo ordenDeTrabajo;

    @ManyToOne
    @JoinColumn(name = "especialidades_id")
    private Especialidad aplicacion;

    /*
     * La relacion muchos a muchos con "Servicios" solo es necesaria si se 
     * quiere listar los servicios con mas incidentes reportados,
     * que no se pide en el tp.  se deja comentado para concenso de eliminacion
     * Se dejan comentado los import set y hashset.
     
    @ManyToMany
    @JoinTable(
            name = "servicios_has_incidentes",
            joinColumns = @JoinColumn(name = "incidente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private Set<Servicio> servicios = new HashSet<>();

    */

    // Constructor, getters, setters y otros métodos...

}
