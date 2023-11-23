package Entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    @GeneratedValue
    private int id;

    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;
    private List<Especialidad> especialidades;

    //Faltaria establecer la relacion one to many con tecnicos
}
