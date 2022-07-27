package consultorio.odontologico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consultorio.odontologico.model.Turno;
import consultorio.odontologico.repository.ITurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnosService implements ITurnoService{

    @Autowired
    private ITurnoRepository turnoRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearTurno(Turno turno) {
        turnoRepository.save(turno);
    }

    @Override
    public Turno leerTurno(Long id) throws Exception {
        Optional<Turno> optionalTurno = turnoRepository.findById(id);
        if(optionalTurno.isPresent())
            return mapper.convertValue(optionalTurno, Turno.class);
        else
            throw new Exception("Turno no encontrado");
    }

    @Override
    public void modificarTurno(Turno turno) {
        turnoRepository.save(turno);

    }

    @Override
    public void elimiarTurno(Long id) {
        turnoRepository.deleteById(id);

    }

    @Override
    public List<Turno> verTodos() {
        List<Turno> turnoList = turnoRepository.findAll();
        return turnoList;
    }
}
