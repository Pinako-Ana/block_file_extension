package com.flow.extension_block.domain.extension.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_fixed_extension")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"seq", "extensionName", "isChecked", "isDeleted"})
public class FixedExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fixed_extension_seq", columnDefinition = "INTEGER")
    private Integer seq;

    @Column(nullable = false)
    private String extensionName;

    @Column(nullable = false, columnDefinition = "TINYINT default false")
    private boolean isChecked;

    @Column(nullable = false, columnDefinition = "TINYINT default false")
    private boolean isDeleted;

    @Builder
    public FixedExtension(Integer seq, String extensionName, boolean isChecked, boolean isDeleted) {
        this.seq = seq;
        this.extensionName = extensionName;
        this.isChecked = isChecked;
        this.isDeleted = isDeleted;
    }
}
