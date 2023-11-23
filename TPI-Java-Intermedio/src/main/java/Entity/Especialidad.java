package Entity;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="especialidad")
public class Especialidad {

        @Id
        @GeneratedValue
        private int id;

        private String especialidad;

}
