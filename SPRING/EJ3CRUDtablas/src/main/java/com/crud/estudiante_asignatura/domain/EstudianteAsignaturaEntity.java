package com.crud.estudiante_asignatura.domain;

import com.crud.comun.StringPrefixedSequenceIdGenerator;
import com.crud.estudiante.domain.StudentEntity;
import com.crud.estudiante_asignatura.infraestructure.dto.E_A_InputDTO;
import com.crud.profesor.domain.ProfesorEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NamedQuery(name = "EstudianteAsignaturaEntity.findByEstudiante",
        query = "select e from EstudianteAsignaturaEntity e where e.estudiante = ?1")
public class EstudianteAsignaturaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_topic_seq")
    @GenericGenerator(
            name="student_topic_seq",
            strategy="com.crud.comun.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value="1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="EST_TOPIC"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%08d")
            }
    )
    private String id_estudiante_asignatura;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_estudiante")
    private StudentEntity estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profesor")
    private ProfesorEntity id_profesor;

    @NonNull
    private String id_asignatura;


    private String asignatura;


    private String coments;

    @NonNull
    private Date initial_date;


    private Date finish_date;



    public EstudianteAsignaturaEntity(){

    }

    public void setUpdate(E_A_InputDTO e_a_inputDTO, ProfesorEntity profesor){
        setId_profesor(profesor);
        setId_asignatura(e_a_inputDTO.getId_asignatura());
        setAsignatura(e_a_inputDTO.getAsignatura());
        setComents(e_a_inputDTO.getComents());
        setInitial_date(e_a_inputDTO.getInitial_date());
        setFinish_date(e_a_inputDTO.getInitial_date());
    }

    @Override
    public String toString() {
        return "EstudianteAsignaturaEntity{" +
                "id_estudiante_asignatura='" + id_estudiante_asignatura + '\'' +
                ", id_asignatura='" + id_asignatura + '\'' +
                ", asignatura='" + asignatura + '\'' +
                ", coments='" + coments + '\'' +
                ", initial_date=" + initial_date +
                ", finish_date=" + finish_date +
                '}';
    }
}
