import java.util.HashSet;
import java.util.Set;

import entity.Especialidad;
import repository.dao.*;

import util.*;
public class AppPrincipal {

    public static void main(String[] args) {
        //DAO dao = new JpaDAO();
        GenerarClientes clientes = new GenerarClientes();
        GenerarEmpleadosTecnicos tecnicos = new GenerarEmpleadosTecnicos();
        GenerarServicios servicios = new GenerarServicios();

        clientes.getSetClientes().forEach(System.out:: println);
        tecnicos.getSetEmpleadosTecnicos().forEach(System.out::println);
        servicios.getSetServicios().forEach(serv ->{
            System.out.println(serv.getDescripcion());
            serv.getSetApps().forEach(System.out::println);            
        });
    }
}
