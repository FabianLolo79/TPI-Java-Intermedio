package Entity;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="ordenes_de_trabajo")
public class OdenDeTrabajo {

    @Id
    @GeneratedValue
    private int id;

    private String comentario;

    //relaciones
    // clientes_id;
    // clientes_cuit;
    // create_by;

}
