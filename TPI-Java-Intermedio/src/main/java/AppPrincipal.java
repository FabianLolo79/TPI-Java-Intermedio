import repository.dao.*;

import util.*;
public class AppPrincipal {

    public static void main(String[] args) {
        //DAO dao = new JpaDAO();
        GenerarClientes clientes = new GenerarClientes();
        GenerarEmpleadosTecnicos tecnicos = new GenerarEmpleadosTecnicos();
        GenerarServicios servicios = new GenerarServicios();

        clientes.getSetClientes();
    }
}
