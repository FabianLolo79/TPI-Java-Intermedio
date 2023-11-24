package entity;



import javax.persistence.*;



@Entity
@Table(name="especialidades")
public class Especialidad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String especialidad;
}
