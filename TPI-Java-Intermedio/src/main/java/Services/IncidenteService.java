package Services;

import java.util.HashSet;
import java.util.Set;

import entity.Empleado;
import entity.Especialidad;
import entity.Incidente;
import entity.Status;
import repository.IncidenteRepository;
import repository.RepositorioGenerico;


public class IncidenteService{
 
    private RepositorioGenerico servicioCRUDIncidente;
    private IncidenteRepository servicioIncidente;

    public IncidenteService(RepositorioGenerico servicioRepositorio, IncidenteRepository servicioIncidente){
        this.servicioCRUDIncidente = servicioRepositorio;
        this.servicioIncidente = servicioIncidente;
    }

    public void agregarIncidente(Incidente incidente) {
        servicioCRUDIncidente.agregar(incidente);
    }

    public void actualizarIncidente(Incidente incidente) {
        servicioCRUDIncidente.actualizar(incidente);
    }

    public void eliminarIncidente(Incidente incidente) {
        servicioCRUDIncidente.eliminar(incidente);
    }

    public Incidente traerIncidentePorID(int id) {
        return (Incidente)servicioCRUDIncidente.traerPorID(id);
    }

    public Set<Incidente> setListaIncidentes() {
        Set<Incidente> setIncidentes = new HashSet<>();
        Set<Object> objIncidentes = this.servicioCRUDIncidente.traerLista();
        for (Object obj : objIncidentes) {
            setIncidentes.add((Incidente)obj);
        }
        return setIncidentes;
    }

    public Empleado tecnicoMayorIncidentesResueltos(Status status, int dias) {
        this.servicioIncidente.tecnicoMayorIncidentesResueltos(status, dias);
        return null;
        
    }

    public Empleado tecnicoMayorIncidentesPorEspecialidad(Especialidad especialidad, int dias) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tecnicoMayorIncidentesPorEspecialidad'");
    }

    public Empleado tecnicoMejorTiempoDeResolucionIncidentes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'tecnicoMejorTiempoDeResolucionIncidentes'");
    }
    
}
