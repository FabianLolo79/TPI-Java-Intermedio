package Services;

import java.util.HashSet;
import java.util.Set;

import entity.Especialidad;
import entity.Servicio;
import repository.RepositorioGenerico;

public class EspecialidadService {
    private RepositorioGenerico especialidadRepositorio;

    public EspecialidadService(RepositorioGenerico especialidadRepositorio){
        this.especialidadRepositorio = especialidadRepositorio;
    }

    public void agregarEspecialidad(Especialidad especialidad) {
        this.especialidadRepositorio.agregar(especialidad);
    }

    public void actualizarEspecialidad(Especialidad especialidad) {
        this.especialidadRepositorio.actualizar(especialidad);
    }

    public void eliminarEspecialidad(int id) {
        this.especialidadRepositorio.eliminar(id);;
    }

    public Especialidad traerPorID(int id) {
       return (Especialidad)this.especialidadRepositorio.traerPorID(id);
    }

    public Set<Especialidad> listaEspecialidadesSet() {
        Set<Especialidad> setEspecialidad = new HashSet<>();
        Set<Object> setObj = this.especialidadRepositorio.traerLista();
        for (Object obj : setObj) {
            Especialidad especialidad = (Especialidad) obj;
            setEspecialidad.add(especialidad);
        }

        return setEspecialidad;
    }
}
