package com.flow.extension_block.domain.extension.repository;

import com.flow.extension_block.domain.extension.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Integer> {

    @Query("SELECT COUNT(c) > 0 FROM CustomExtension c WHERE c.extensionName = :extensionName AND c.isDeleted = FALSE")
    boolean existsByExtensionName(@Param("extensionName") String extensionName);

    @Query("SELECT c FROM CustomExtension c WHERE c.isDeleted = FALSE")
    List<CustomExtension> findCustomExtensions();

}
