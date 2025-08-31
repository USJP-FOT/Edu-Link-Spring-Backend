package edu.usjp.edulink.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "trashData")
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TrashDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob  // image may be long (Base64 string)
    @Column(nullable = false, columnDefinition = "TEXT")
    private String image;

    private String actualValue;

    private String predictedValue;

    private String confidence;

    private Timestamp timestamp;
}
