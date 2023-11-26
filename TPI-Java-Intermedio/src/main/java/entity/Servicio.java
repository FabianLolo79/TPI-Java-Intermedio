package entity;



import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//import java.util.HashSet;
//import java.util.Set;

@Setter
@Getter
@AllArgsConstructor

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String descripcion;

    /*
     * La relacion muchos a muchos con "Incidente" solo es necesaria si se 
     * quiere listar los servicios con mas incidentes reportados,
     * que no se pide en el tp.  se deja comentado para concenso de eliminacion
     *  Se dejan comentado los import set y hashset.
     
    @ManyToMany(mappedBy = "servicios")
    private Set<Incidente> incidentes = new HashSet<>(); 

     */
    
}
