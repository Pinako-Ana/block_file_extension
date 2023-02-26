package com.flow.extension_block.domain.extension.repository;

import com.flow.extension_block.domain.extension.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FixedRepository extends JpaRepository<FixedExtension, Integer> {

    @Query("SELECT f FROM FixedExtension f where f.isDeleted = false")
    List<FixedExtension> findFixedExtensions();

}
