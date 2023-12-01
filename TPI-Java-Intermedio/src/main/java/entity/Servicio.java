package entity;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servicio_id")
    private int id;

    private String descripcion;
    /*
     * CascadeType.ALL afecta a las operaciones persist, merge , remove,
     * etc realizadas en la entidad Servicio aplicara a la entidad Especialidad
     * orphanRemoval = true asegura que no queden especialidades huerfanas,
     * es decir, si elimino una especialidad de un servicio, y esa especialidad
     * no esta asociada a otro servicio, se elimina
     */
    @OneToMany
    //en esta relacion el mapeo se hace con el atributo servicio..
    //de la clase Especialidad
    (mappedBy = "servicio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Especialidad> especialidades;

    
}
