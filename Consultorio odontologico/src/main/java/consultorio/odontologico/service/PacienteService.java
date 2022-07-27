package consultorio.odontologico.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import consultorio.odontologico.model.Paciente;
import consultorio.odontologico.model.PacienteDTO;
import consultorio.odontologico.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService implements IPacienteService {

    @Autowired
    IPacienteRepository pacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void crearPaciente(PacienteDTO pacienteDTO) {
        Paciente nuevoPaciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(nuevoPaciente);
    }

    @Override
    public PacienteDTO leerPaciente(Long id) throws Exception {
        Optional<Paciente> optionalPaciente = pacienteRepository.findById(id);

        if(optionalPaciente.isPresent())
            return mapper.convertValue(optionalPaciente, PacienteDTO.class);
        else
            throw new Exception("Paciente no encontrado");


    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente nuevoPaciente = mapper.convertValue(pacienteDTO, Paciente.class);
        pacienteRepository.save(nuevoPaciente);
    }

    @Override
    public void elimiarPaciente(Long id) {
        pacienteRepository.deleteById(id);

    }

    @Override
    public List<PacienteDTO> verTodos() {
        List<Paciente> pacienteList = pacienteRepository.findAll();
        List <PacienteDTO> pacienteDTOList= pacienteList.stream().map(paciente -> mapper.convertValue(paciente, PacienteDTO.class)).collect(Collectors.toList());

        return pacienteDTOList;

    }

    public PacienteDTO devuelvePacienteDTO() throws Exception{
        PacienteDTO pacienteDTO = new PacienteDTO() ;
        if (pacienteDTO == null) {
            throw new Exception("paciente no encontrado");
        } else{
            return pacienteDTO;

        }
    }

}
