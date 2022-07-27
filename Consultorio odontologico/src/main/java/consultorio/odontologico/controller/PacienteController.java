package consultorio.odontologico.controller;

import consultorio.odontologico.model.PacienteDTO;
import consultorio.odontologico.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("consultorio/pacientes")
public class PacienteController {


    @Autowired
    IPacienteService pacienteService;

    @GetMapping("/{id}")
    public PacienteDTO traerPaciente(@PathVariable Long id) throws Exception {
        return pacienteService.leerPaciente(id);
    }

    @PostMapping()
    public ResponseEntity<PacienteDTO> agregarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.crearPaciente(pacienteDTO);
        return new ResponseEntity<>(pacienteDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPaciente(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        pacienteService.elimiarPaciente(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }
    



    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO) {
        pacienteService.modificarPaciente(pacienteDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<PacienteDTO>> verTodos(){
        List<PacienteDTO> pacienteDTOList =pacienteService.verTodos();
        return new ResponseEntity<>(pacienteDTOList, HttpStatus.OK);
    }
}
