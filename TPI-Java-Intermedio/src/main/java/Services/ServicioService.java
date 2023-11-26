package Services;

import java.util.Set;

import entity.Servicio;
import repository.ServicioRepositorio;

public class ServicioService {
    private ServicioRepositorio servicioRepositorio;

    public ServicioService(ServicioRepositorio servicioRepositorio){
        this.servicioRepositorio = servicioRepositorio;
    }

    public void agregarServicio(Servicio servicio) {
        this.servicioRepositorio.agregarServicio(servicio);;
    }

    public void actualizarServicio(Servicio servicio) {
        this.servicioRepositorio.actualizarServicio(servicio);
    }

    public void eliminarServicio(int id) {
        this.servicioRepositorio.eliminarServicio(id);
    }

    public Servicio traerPorID(int id) {
       return this.servicioRepositorio.traerServicioPorID(id);
    }

    public Set<Servicio> listaServicios() {
        return this.servicioRepositorio.listaServicios();
    }


}
