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
    public  Servicio(String descripcion, Set<Especialidad> setApps){
        this.descripcion = descripcion;
        this.setApps = setApps;
    }
    /*
     * CascadeType.ALL afecta a las operaciones persist, merge , remove,
     * etc realizadas en la entidad Servicio aplicara a la entidad Especialidad
     * orphanRemoval = true asegura que no queden especialidades huerfanas,
     * es decir, si elimino una especialidad de un servicio, y esa especialidad
     * no esta asociada a otro servicio, se elimina
     */
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JoinColumn(name = "servicio_id")
    private Set<Especialidad> setApps;
    
    @Override
    public String toString(){
        return "Servicio "+descripcion+" Especialidades:\n";
    }
}
