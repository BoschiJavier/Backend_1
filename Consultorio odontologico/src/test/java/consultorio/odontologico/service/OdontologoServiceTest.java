package consultorio.odontologico.service;

import consultorio.odontologico.model.OdontologoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OdontologoServiceTest {

    @Autowired
    IOdontologoService odontologoService;

    @Test
    public void testCrear() throws Exception {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Juan");
        odontologoDTO.setApellido("Roman");
        odontologoDTO.setMatricula("123456");
        odontologoService.crearOdontologo(odontologoDTO);
        OdontologoDTO odontologoJuan = odontologoService.leerOdontologo(1L);

        assertTrue(odontologoJuan!=null);

    }


}