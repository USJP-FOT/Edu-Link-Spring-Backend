package edu.usjp.edulink.dto.academicdto;

import edu.usjp.edulink.service.filtersystem.Mode;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ClassRoom {
    private Integer id;
    private Boolean isReady;
    private Mode currentMode;
}
