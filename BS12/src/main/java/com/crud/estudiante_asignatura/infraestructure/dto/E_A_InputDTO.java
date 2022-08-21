package com.crud.estudiante_asignatura.infraestructure.dto;

import lombok.Data;
import java.util.Date;

@Data
public class E_A_InputDTO {

    private String id_profesor;
    private String id_asignatura;
    private String asignatura;
    private String coments;
    private Date initial_date;
    private Date finish_date;


    public E_A_InputDTO(){

    }

    public E_A_InputDTO(String id_profesor, String id_asignatura, String asignatura, String coments, Date initial_date, Date finish_date){
        setId_profesor(id_profesor);
        setId_asignatura(id_asignatura);
        setAsignatura(asignatura);
        setComents(coments);
        setInitial_date(initial_date);
        setFinish_date(finish_date);

    }
}
