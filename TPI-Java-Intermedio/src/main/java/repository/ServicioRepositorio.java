package repository;

import java.util.Set;

import entity.Servicio;

public interface ServicioRepositorio {
    void agregarServicio(Servicio servicio);
    void actualizarServicio(Servicio servicio);
    void eliminarServicio(int id);
    Servicio traerServicioPorID(int id);
    Set<Servicio> listaServicios();
}
