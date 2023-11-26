package entity;



import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Entity
@Table(name="especialidades")
public class Especialidad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String especialidad;
}
