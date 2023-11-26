package Services;

import java.util.HashSet;
import java.util.Set;

import entity.Servicio;
import repository.RepositorioGenerico;

public class ServicioService {
    private RepositorioGenerico servicioRepositorio;

    public ServicioService(RepositorioGenerico servicioRepositorio){
        this.servicioRepositorio = servicioRepositorio;
    }

    public void agregarServicio(Servicio servicio) {
        this.servicioRepositorio.agregar(servicio);
    }

    public void actualizarServicio(Servicio servicio) {
        this.servicioRepositorio.actualizar(servicio);
    }

    public void eliminarServicio(int id) {
        this.servicioRepositorio.eliminar(id);
    }

    public Servicio traerPorID(int id) {
       return this.servicioRepositorio.traerPorID(id);
    }

    public Set<Servicio> listaServicios() {
        Set<Servicio> setServicios = new HashSet<>();
        Set<Object> setObj = this.servicioRepositorio.traerLista();
        for (Object obj : setObj) {
            Servicio servicio = (Servicio) obj;
            setServicios.add(servicio);
        }

        return setServicios;
    }


}
