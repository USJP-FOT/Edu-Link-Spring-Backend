package edu.usjp.edulink.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TrashBin {
    private Integer id;
    private Integer availableCapacity;
    private String place;
}
