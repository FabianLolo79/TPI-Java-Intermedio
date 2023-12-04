import java.util.HashSet;
import java.util.Set;

import Services.EspecialidadService;
import Services.ServicioService;
import entity.Especialidad;
import entity.Servicio;
import repository.JpaServicioRepositorio;
import repository.RepositorioGenerico;
import repository.jpaEspecialidadRepositorio;
import repository.dao.*;

import util.*;
public class AppPrincipal {

    public static void main(String[] args) {
        DAO dao = new JpaDAO();

        //GenerarClientes clientes = new GenerarClientes();
        //GenerarEmpleadosTecnicos tecnicos = new GenerarEmpleadosTecnicos();
        GenerarServicios servicios = new GenerarServicios(dao);

        //clientes.getSetClientes().forEach(System.out:: println);
        //tecnicos.getSetEmpleadosTecnicos().forEach(System.out::println);
    }
}
