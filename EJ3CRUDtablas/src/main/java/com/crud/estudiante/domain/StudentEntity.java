package com.crud.estudiante.domain;

import com.crud.comun.StringPrefixedSequenceIdGenerator;
import com.crud.estudiante.infraestructure.dto.EstudianteInputDTO;
import com.crud.estudiante_asignatura.domain.EstudianteAsignaturaEntity;
import com.crud.persona.domain.PersonaEntity;
import com.crud.persona.infraestructure.repository.PersonaRepositorio;
import com.crud.profesor.domain.ProfesorEntity;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NamedQuery(name = "StudentEntity.findByIdPersona",
        query = "select s from StudentEntity s where s.id_persona = ?1")
public class StudentEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_seq")
    @GenericGenerator(
            name="student_seq",
            strategy="com.crud.comun.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value="1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="EST"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%08d")
            }
    )
    private String id_estudiante;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PersonaEntity id_persona;

    @NonNull
    private int num_hours_week;

    private  String coments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private ProfesorEntity id_profesor;

    @NonNull
    private String branch;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstudianteAsignaturaEntity> estudianteAsignaturaLista = new ArrayList<EstudianteAsignaturaEntity>();


    public StudentEntity(){

    }

    public void setUpdate(EstudianteInputDTO estudiante){

        if(estudiante.getComents()!=null){
            this.coments=estudiante.getComents();
        }
        if(estudiante.getBranch()!=null){
            this.branch=estudiante.getBranch();
        }
        if(estudiante.getNum_hours_week()!=null){
            this.num_hours_week=estudiante.getNum_hours_week();
        }

    }

}
