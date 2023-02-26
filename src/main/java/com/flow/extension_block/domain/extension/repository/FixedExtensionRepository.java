package com.flow.extension_block.domain.extension.repository;

import com.flow.extension_block.domain.extension.entity.FixedExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FixedExtensionRepository extends JpaRepository<FixedExtension, Integer> {

    @Query("SELECT f FROM FixedExtension f where f.isDeleted = FALSE")
    List<FixedExtension> findFixedExtensions();

    @Query("select f FROM FixedExtension f where f.seq = :seq AND f.isDeleted = FALSE")
    Optional<FixedExtension> findBySeq(@Param("seq") Integer seq);

}
