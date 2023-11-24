package Entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
@Setter
@Getter

@Entity
@Table(name="empleados")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
            name = "especialidades_has_empleados",
            joinColumns = @JoinColumn(name="empleados_id"),
            inverseJoinColumns = @JoinColumn(name="especialidades_id")
    )
    private Set<Especialidad> especialidades =new HashSet<Especialidad>();
}
