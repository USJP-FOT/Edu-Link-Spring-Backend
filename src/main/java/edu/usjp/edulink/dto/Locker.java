package edu.usjp.edulink.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Locker {
    private Integer id;
    private String name;
    private Boolean isPenReady;
    private Boolean isLocked;

    private Integer classRoomId; // FK from locker
}
