package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import entity.Empleado;
import entity.Rol;

public class GenerarEmpleadosTecnicos {
    private Set<Empleado> setEmpleadosTecnicos;
    protected List<String[]> listaTecnicos;

    protected String tecnico1 = "RUBEN;GIL;22861213;rgil123@outlook.com;1169440539;TECNICO;27-03-2019;27-03-2020;null;null";
    protected String[] tcn1 = tecnico1.split(";");

    protected String tecnico2 = "MANUELA;RUBIO;35566056;manuela76@gmail.com;1143457887;TECNICO;27-03-2015;00-00-000;null;null";
    protected String[] tcn2 = tecnico2.split(";");

    protected String tecnico3 = "JOSE CARLOS;DELGADO;52588909;jcdelgado86@yahoo.com.ar;1134907778;TECNICO;27-03-2020;00-00-0000;null;null";
    protected String[] tcn3 = tecnico3.split(";");

    protected String tecnico4 = "IVAN;ALVAREZ;86579607;ivan1976@hotmail.com;1161900922;TECNICO;12-08-2022;00-00-0000;null;null";
    protected String[] tcn4 = tecnico4.split(";");

    protected String tecnico5 = "MIGUEL;VICENTE;44348965;mvtecnico@outlook.com;1144542637;TECNICO;15-01-2021;00-00-00;null;null";
    protected String[] tcn5 = tecnico5.split(";");

    public GenerarEmpleadosTecnicos(){
        this.listaTecnicos = List.of(tcn1, tcn2, tcn3, tcn4, tcn5);
        this.setEmpleadosTecnicos = new HashSet<>();

        listaTecnicos.forEach(tcn ->{
            try {
                agregarTecnicos(tcn);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        });
    }

    public Set<Empleado> getSetEmpleadosTecnicos(){
        return this.setEmpleadosTecnicos;
    }

    protected void agregarTecnicos(String[] tcn) throws ParseException {
        Rol rol = Rol.valueOf(tcn[5]);
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaAlta = formato.parse(tcn[6]);
        Date fechaBaja = formato.parse(tcn[7]);
        Empleado tecnico = new Empleado(0,tcn[0], tcn[1], tcn[2], tcn[3], tcn[4], rol, fechaAlta, fechaBaja, null, null);
        this.setEmpleadosTecnicos.add(tecnico);
    }
}
