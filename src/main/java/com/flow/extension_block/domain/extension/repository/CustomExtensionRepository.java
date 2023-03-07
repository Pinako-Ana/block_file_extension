package com.flow.extension_block.domain.extension.repository;

import com.flow.extension_block.domain.extension.entity.CustomExtension;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomExtensionRepository extends JpaRepository<CustomExtension, Integer> {

    @Query("SELECT COUNT(c) > 0 FROM CustomExtension c WHERE c.extensionName = :extensionName AND c.isDeleted = FALSE")
    boolean existsByExtensionName(@Param("extensionName") String extensionName);

    @Query("SELECT COUNT(c) > 0 FROM CustomExtension c WHERE c.seq = :extensionSeq AND c.isDeleted = FALSE")
    boolean existsBySeq(@Param("extensionSeq") Integer extensionSeq);

    @Query("SELECT c FROM CustomExtension c WHERE c.isDeleted = FALSE")
    List<CustomExtension> findCustomExtensions();

    @Query("SELECT c FROM CustomExtension c where c.seq = :extensionSeq AND c.isDeleted = FALSE")
    Optional<CustomExtension> findBySeq(@Param("extensionSeq") Integer extensionSeq);

    @Query("SELECT COUNT(c) > 0 FROM CustomExtension c WHERE c.extensionName = :extensionName AND c.isDeleted = TRUE")
    boolean isDeleted(@Param("extensionName") String extensionName);

    @Query("SELECT c FROM CustomExtension c WHERE c.extensionName = :extensionName AND c.isDeleted = TRUE")
    Optional<CustomExtension> findByDeletedExtensionName(@Param("extensionName") String extensionName);

    @Query("SELECT COUNT(c) FROM CustomExtension c WHERE c.isDeleted = FALSE")
    Integer getCustomExtensionSize();

}
