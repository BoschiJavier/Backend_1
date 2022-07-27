package consultorio.odontologico.service;

import consultorio.odontologico.model.Domicilio;

import java.util.List;

public interface IDomicilioService {

    void crearDomicilio(Domicilio domicilio);
    Domicilio leerDomicilio(Long id) throws Exception;
    void modificarDomicilio(Domicilio domicilio);
    void elimiarDomicilio(Long id);

    List<Domicilio> verTodos();



}
