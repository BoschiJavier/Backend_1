package consultorio.odontologico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consultorio.odontologico.model.Domicilio;
import consultorio.odontologico.model.Domicilio;
import consultorio.odontologico.repository.IDomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService {

    @Autowired
    IDomicilioRepository domicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public Domicilio leerDomicilio(Long id) throws Exception {
        Optional<Domicilio> optionalDomicilio = domicilioRepository.findById(id);
        if(optionalDomicilio.isPresent())
            return mapper.convertValue(optionalDomicilio, Domicilio.class);
        else
            throw new Exception("Domicilio no encontrado");


    }

    @Override
    public void modificarDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public void elimiarDomicilio(Long id) {
        domicilioRepository.deleteById(id);

    }

    @Override
    public List<Domicilio> verTodos() {
        List<Domicilio> domicilioList = domicilioRepository.findAll();
        return domicilioList;

    }
}
