package edu.usjp.edulink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LockerEntity {
    @Id
    private Integer id;
    private String name;
    private Boolean status;
}
