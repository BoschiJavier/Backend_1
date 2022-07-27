package consultorio.odontologico.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//import static javax.persistence.GenerationType.*;

@Entity
@Table(name= "pacientes")
@Getter
@Setter
public class Paciente {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
   // private Date fechaIngreso;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name="domicilio_id")
    private Domicilio domicilio;

    @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
               // ", fechaIngreso=" + fechaIngreso +
                ", domicilio=" + domicilio +
                '}';
    }

}
