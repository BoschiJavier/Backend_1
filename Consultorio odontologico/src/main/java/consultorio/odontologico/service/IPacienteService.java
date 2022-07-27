package consultorio.odontologico.service;

import consultorio.odontologico.model.PacienteDTO;

import java.util.List;

public interface IPacienteService {

    void crearPaciente(PacienteDTO pacienteDTO);
    PacienteDTO leerPaciente(Long id) throws Exception;
    void modificarPaciente(PacienteDTO pacienteDTO);
    void elimiarPaciente(Long id);

    List<PacienteDTO> verTodos();

}
