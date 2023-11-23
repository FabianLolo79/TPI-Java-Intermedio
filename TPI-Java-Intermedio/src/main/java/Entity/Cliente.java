package Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter

@Entity
@Table(name="clientes")
public class Cliente {

    @Id
    @GeneratedValue
    private long id;

    private int cuit;
    private String razon_social;
    private String domicilio;
    private String ciudad;
    private String email;
    private String telefono;

}
