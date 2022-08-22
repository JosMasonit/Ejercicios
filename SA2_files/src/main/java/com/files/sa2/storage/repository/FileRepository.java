package com.files.sa2.storage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<FileEntity, Integer> {
    public List<FileEntity> findByName(String name);
}
