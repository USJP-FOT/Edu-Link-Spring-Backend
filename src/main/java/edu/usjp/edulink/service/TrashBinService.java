package edu.usjp.edulink.service;

import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.trashdto.TrashBin;
import edu.usjp.edulink.entity.TrashBinEntity;

import java.util.List;

public interface TrashBinService {
    TrashBinEntity addTrashBin(TrashBin trashBin);

    Boolean updateTrashBinCapacity(Integer id, Integer capacity);

    Boolean tellType(Integer id, Integer garbageType);

    String tellType(PredictRequest predictRequest);

    List<TrashBin> getAll();
}
