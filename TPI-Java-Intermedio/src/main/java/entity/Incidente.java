package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "servicios_has_incidentes",
            joinColumns = @JoinColumn(name = "incidente_id"),
            inverseJoinColumns = @JoinColumn(name = "servicio_id")
    )
    private Set<Servicio> servicios = new HashSet<>();

    // Constructor, getters, setters y otros métodos...

}
