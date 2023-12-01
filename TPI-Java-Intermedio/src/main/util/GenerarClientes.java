import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import entity.Cliente;

public class GenerarClientes {
    private Set<Cliente> setClientes;
    private List<String[]> listaClientes;

    private String cliente1 = "34228612138;Innova;Vieytes 2684; Capital Federal; innovacompany@hotmail.com; 01146432100";
    private String[] cl1 = cl.split(";");

    private String cliente2 = "20355660560;Meyer S.A.;Ramirez de Velasco 1153; Buenos Aires; meyeralfombras@yahoo.com.ar; 01149553457";
    private String[] cl2 = cl.split(";");

    private String cliente3 = "34525889090;Neyra S.R.L; Erezcano 3950;Pompeya (CABA); hijosdeneyra@outlook.com;01149186653";
    private String[] cl3 = cl.split(";");

    private String cliente4 = "20865796072;Neumen;Boedo 2402; Boedo (CABA);boedo@autoneumen.com.ar;01149271190";
    private String[] cl4 = cl.split(";");
    
    public GenerarClientes(){
        this.listaClientes = List.of(cl1, cl2, cl3, cl4);

        listaClientes.forEach(cl ->{
            Cliente cliente = new Cliente(0, cl[0], cl[1], cl[2], cl[3], cl[4], cl[5], null, null);
            setClientes.add(cliente);
        });
    }   
}
