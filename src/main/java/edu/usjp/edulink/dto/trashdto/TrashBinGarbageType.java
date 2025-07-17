package edu.usjp.edulink.dto.trashdto;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class TrashBinGarbageType {
    private Integer trashBinId;
    private Integer GarbageAttogray;

    public TrashBinGarbageType(Integer id, Integer garbageType) {
        this.trashBinId = id;
        this.GarbageAttogray = garbageType;
    }
}
