package consultorio.odontologico.controller;


import consultorio.odontologico.model.Odontologo;
import consultorio.odontologico.model.OdontologoDTO;
import consultorio.odontologico.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("consultorio/odontologico")
public class OdontologoController {

    @Autowired
    IOdontologoService odontologoService;

    @GetMapping("/{id}")
    public OdontologoDTO traerOdontologo(@PathVariable Long id) throws Exception {
        return odontologoService.leerOdontologo(id);
    }

    @PostMapping()
    public ResponseEntity<OdontologoDTO> agregarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.crearOdontologo(odontologoDTO);
        return new ResponseEntity<>(odontologoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) {

        ResponseEntity<String> response = null;
        odontologoService.elimiarOdontologo(id);
        response = ResponseEntity.status(HttpStatus.OK).body("Eliminado");
        return response;
    }

    @PutMapping()
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO) {
        odontologoService.modificarOdontologo(odontologoDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OdontologoDTO>> verTodos(){
        List<OdontologoDTO> odontologoDTOList =odontologoService.verTodos();
        return new ResponseEntity<>(odontologoDTOList, HttpStatus.OK);
    }
}
