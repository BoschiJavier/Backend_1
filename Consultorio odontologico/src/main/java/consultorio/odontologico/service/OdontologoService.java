package consultorio.odontologico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consultorio.odontologico.model.Odontologo;
import consultorio.odontologico.model.OdontologoDTO;
import consultorio.odontologico.repository.IOdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    IOdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo nuevoOdontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(nuevoOdontologo);
    }

    @Override
    public OdontologoDTO leerOdontologo(Long id) throws Exception {
Optional<Odontologo> optionalOdontologo = odontologoRepository.findById(id);
    if(optionalOdontologo.isPresent())
        return mapper.convertValue(optionalOdontologo, OdontologoDTO.class);
    else
        throw new Exception("Odontologo no encontrado");

    }
    


    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo nuevoOdontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        odontologoRepository.save(nuevoOdontologo);
    }

    @Override
    public void elimiarOdontologo(Long id) {
        odontologoRepository.deleteById(id);

    }

    @Override
    public List<OdontologoDTO> verTodos() {
        List<Odontologo> odontologoList = odontologoRepository.findAll();
        List <OdontologoDTO> odontologoDTOList= odontologoList.stream().map(odontologo -> mapper.convertValue(odontologo, OdontologoDTO.class)).collect(Collectors.toList());
        return odontologoDTOList;

    }



}
