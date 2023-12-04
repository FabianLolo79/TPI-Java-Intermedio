package util;

import java.util.HashSet;
import java.util.Set;

import Services.EspecialidadService;
import Services.ServicioService;

import java.util.List;

import entity.Especialidad;
import entity.Servicio;
import repository.JpaServicioRepositorio;
import repository.RepositorioGenerico;
import repository.jpaEspecialidadRepositorio;
import repository.dao.DAO;


public class GenerarServicios {

    private Set<Especialidad> setApps;
    protected List<String[]> listaServicios;


    protected String srv1 = "MacOS;instalacion y configuracion;Actualizacion del sistema;conectividad;Optimizacion y rendimiento";
    protected String[] servicio1 = srv1.split(";");

    protected String srv2 = "Office (Windows);word;excel;acces;powerpoint";
    protected String[] servicio2 = srv2.split(";");

    protected String srv3 = "Tango;Instalacion Tango;Migracion de version o servidor;Puesta en marcha y planeamiento;Desarrollo de interfaces";
    protected String[] servicio3 = srv3.split(";");

    public GenerarServicios(DAO dao){

        this.setApps = new HashSet<>();
        agregarServicios(dao);
    }

    public Set<Especialidad> getSetApps(){
        return this.setApps;
    }

    protected void agregarServicios(DAO dao) {
        RepositorioGenerico servicicioRepositorio = new JpaServicioRepositorio(dao);
        ServicioService serviciosService = new ServicioService(servicicioRepositorio);
        
        this.listaServicios = List.of(servicio1, servicio2, servicio3);
        /*
         * En cada array de Strings el primer string es el servicio, 
         * el resto de strings son las
         * especialidades de ese servicio.
         */
        this.listaServicios.forEach(srv ->{
            Servicio objServicio = new Servicio(srv[0], setApps);
            serviciosService.agregarServicio(objServicio);
            for (int i = 1; i < srv.length; i++) {
                Especialidad app = new Especialidad(srv[i]);
                objServicio.getSetApps().add(app);
            }
        });
    }
}
