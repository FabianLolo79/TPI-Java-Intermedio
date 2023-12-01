package Services;

import java.util.List;

import entity.Incidente;

import repository.RRHHRepositorio;

public class RRHHService {
    RRHHRepositorio rrhhRepositorio;

    public void emitirReporteDiario(){
        List<Incidente> incidentesDiarios = rrhhRepositorio.reporteDiarioDeIncidentes();
        for (Incidente incidente : incidentesDiarios) {
            System.out.println(incidente.toString());
            
        }
    }
    
}
