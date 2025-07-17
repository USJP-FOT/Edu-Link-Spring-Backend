package edu.usjp.edulink.service;

import edu.usjp.edulink.dto.trashdto.TrashBin;
import edu.usjp.edulink.entity.TrashBinEntity;

public interface TrashBinService {
    TrashBinEntity addTrashBin(TrashBin trashBin);

    Boolean updateTrashBinCapacity(Integer id, Integer capacity);

    Boolean tellType(Integer id, Integer garbageType);
}
