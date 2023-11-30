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
@Table(name="especialidades")
public class Especialidad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "especialidad_id")
        private int id;

        private String especialidad;

        @ManyToMany(mappedBy = "especialidades")
        private Set<Empleado> empleados;

        @ManyToOne
        @JoinColumn(name = "servicio_id")
        private Servicio servicio;
}
