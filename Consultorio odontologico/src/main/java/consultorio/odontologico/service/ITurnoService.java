package consultorio.odontologico.service;

import consultorio.odontologico.model.Turno;

import java.util.List;

public interface ITurnoService {

    void crearTurno(Turno turno);
    Turno leerTurno(Long id) throws Exception;
    void modificarTurno(Turno turno);
    void elimiarTurno(Long id);
    List<Turno> verTodos();
    
    
    
}
