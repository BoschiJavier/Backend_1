package consultorio.odontologico.service;


import consultorio.odontologico.model.OdontologoDTO;

import java.util.List;
import java.util.Set;

public interface IOdontologoService {

    void crearOdontologo(OdontologoDTO odontologoDTO);
    OdontologoDTO leerOdontologo(Long id) throws Exception;
    void modificarOdontologo(OdontologoDTO odontologoDTO);
    void elimiarOdontologo(Long id);

    List<OdontologoDTO> verTodos();


}
