package com.files.sa2.storage.repository;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class FileEntity {

    @Id
    @GeneratedValue
    private Integer id_file;
    private String name;
    private String fecha;


    //Constructores
    public FileEntity(){

    }
    public FileEntity(String name, String fecha){
        this.name = name;
        this.fecha = fecha;
    }
}
