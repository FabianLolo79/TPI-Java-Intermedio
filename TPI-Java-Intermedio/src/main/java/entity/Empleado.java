package entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private int id;

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    @Column(name = "alta")
    private Date fechaAlta;

    @Column(name = "baja")
    private Date fechaBaja;

    @ManyToMany
    @JoinTable(
            name = "empleado_has_especialidades",
            joinColumns = @JoinColumn(name="empleado_id"),
            inverseJoinColumns = @JoinColumn(name="especialidad_id")
    )
    private Set<Especialidad> especialidades =new HashSet<Especialidad>();

    @OneToMany(mappedBy = "empleadoTecnico")
    private List<Incidente> incidentesAsignados;

}
