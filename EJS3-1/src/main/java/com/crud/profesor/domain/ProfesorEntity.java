package com.crud.profesor.domain;


import com.crud.comun.StringPrefixedSequenceIdGenerator;
import com.crud.comun.exceptions.UnprocesableException;
import com.crud.persona.domain.PersonaEntity;
import com.crud.persona.infraestructure.dto.PersonaInputDTO;
import com.crud.profesor.infraestructure.dto.ProfesorInputDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NamedQuery(name = "ProfesorEntity.findByIdPersona",
        query = "select p from ProfesorEntity p where p.id_persona = ?1")
public class ProfesorEntity implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @GenericGenerator(
            name="profesor_seq",
            strategy="com.crud.comun.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value="1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value="PROF"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value="%08d")
            }
    )
    private String id_profesor;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private PersonaEntity id_persona;


    private String coments;

    @NonNull
    private String branch;

    public ProfesorEntity(){

    }

    public void setUpdate(ProfesorInputDTO profesor){

        if(profesor.getComents()!=null){
            this.coments=profesor.getComents();
        }
        if(profesor.getBranch()!=null){
            this.branch=profesor.getBranch();
        }
    }

}
