package com.flow.extension_block.domain.extension.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_custom_extension")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(of = {"seq", "extensionName", "isDeleted"})
public class CustomExtension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "custom_extension_seq", columnDefinition = "INTEGER")
    private Integer seq;

    @Column(nullable = false)
    private String extensionName;

    @Column(nullable = false, columnDefinition = "TINYINT default false")
    private boolean isDeleted;

    @Builder
    public CustomExtension(Integer seq, String extensionName, boolean isDeleted) {
        this.seq = seq;
        this.extensionName = extensionName;
        this.isDeleted = isDeleted;
    }

    public void changeDeleteState() {
        this.isDeleted = !this.isDeleted;
    }
}
