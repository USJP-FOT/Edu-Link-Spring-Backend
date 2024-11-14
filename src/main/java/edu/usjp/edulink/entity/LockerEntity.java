package edu.usjp.edulink.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Locker")
@Data
public class LockerEntity {
    @Id
    private Integer id;
    private String name;
    private Boolean status;
}
