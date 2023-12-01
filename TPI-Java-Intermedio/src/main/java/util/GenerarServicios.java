package util;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

import entity.Especialidad;
import entity.Servicio;
import lombok.Getter;


public class GenerarServicios {
    private Set<Servicio> setServicios;
    private Set<Especialidad> setApps;
    protected List<String[]> listaServicios;


    protected String srv1 = "MacOS;instalacion y configuracion;Actualizacion del sistema;conectividad;Optimizacion y rendimiento";
    protected String[] servicio1 = srv1.split(";");

    protected String srv2 = "Office (Windows);word;excel;acces;powerpoint";
    protected String[] servicio2 = srv2.split(";");

    protected String srv3 = "Tango;Instalacion Tango;Migracion de version o servidor;Puesta en marcha y planeamiento;Desarrollo de interfaces";
    protected String[] servicio3 = srv3.split(";");

    public GenerarServicios(){
        agregarServicios();
    }

    public Set<Servicio> getSetServicios(){
        return this.setServicios;
    }

    public Set<Especialidad> getSetApps(){
        return this.setApps;
    }

    protected Set<Servicio> agregarServicios() {

        this.setServicios = new HashSet<>();
        
        this.listaServicios = List.of(servicio1, servicio2, servicio3);
        /*
         * En cada array de Strings el primer string es el servicio, 
         * el resto de strings son las
         * especialidades de ese servicio.
         */
        this.listaServicios.forEach(srv ->{
            
            Servicio objServicio = new Servicio(0,srv[0], new HashSet<>());
            for (int i = 1; i < srv.length; i++) {
                Especialidad especialidad = new Especialidad(0, srv[i]);
                objServicio.getSetApps().add(especialidad);
            }
            this.setServicios.add(objServicio);
            }
        );
        return this.setServicios;
    }
}
