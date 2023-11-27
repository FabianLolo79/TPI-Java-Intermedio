package entity;



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
@Table(name="especialidades")
public class Especialidad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String especialidad;
}
