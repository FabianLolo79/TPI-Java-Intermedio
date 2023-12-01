package repository;

import entity.Empleado;
import entity.Especialidad;
import entity.Status;

public interface IncidenteRepository {
    
    public Empleado tecnicoMayorIncidentesResueltos(Status status, int dias);

    public Empleado tecnicoMayorIncidentesPorEspecialidad(Especialidad especialidad, int dias, Status status);

    public Empleado tecnicoMejorTiempoDeResolucionIncidentes();

    public void altaAppIncidente(Especialidad app, int idIncidente, int tiempoEstimadoResoilucion);
}
