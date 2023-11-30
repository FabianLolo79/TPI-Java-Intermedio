package entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

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

    @OneToMany
    @JoinColumn(name = "especialidades_id")
    private Set<Especialidad> aplicaciones;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleadoTecnico;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
