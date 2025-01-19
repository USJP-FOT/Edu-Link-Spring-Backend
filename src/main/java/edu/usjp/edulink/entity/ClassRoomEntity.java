package edu.usjp.edulink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "class_room")
public class ClassRoomEntity {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Boolean isReady;
}
