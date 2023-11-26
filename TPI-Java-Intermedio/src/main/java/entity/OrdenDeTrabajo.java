package entity;



import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="ordenes_de_trabajo")
public class OrdenDeTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "empleados_id")
    private Empleado CreateByEmpleado;

}
