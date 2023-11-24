package Entity;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter

@Entity
@Table(name="incidentes")
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
    private String aplicacion;

    @ManyToOne
    @JoinColumn(name = "servicios_id")
    private Servicio servicio;

}
