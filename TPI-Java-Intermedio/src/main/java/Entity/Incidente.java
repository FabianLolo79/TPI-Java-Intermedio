package Entity;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="incidentes")
public class Incidente {

    @Id
    @GeneratedValue
    private int id;

    private long tecnico_id;
    private int resolution_time;
    private String status;
    private String observacion_tecnico;
    private String descripcion;
    //private DataTime create;
    private int aplicaciones_id;


    //ordenes_de_trabajo
    // private int ordenes_de_trabajo_id;

    //empleados_id
    //private int empleado_id;

}
