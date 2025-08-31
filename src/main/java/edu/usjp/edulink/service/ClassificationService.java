package edu.usjp.edulink.service;


import edu.usjp.edulink.dto.EditRequest;
import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.PredictResponse;
import edu.usjp.edulink.dto.trashdto.TrashData;
import jakarta.validation.Valid;

import java.util.List;

public interface ClassificationService {
    PredictResponse classify(PredictRequest request);

    List<TrashData> getAll();

    TrashData findById(Long id);

    Boolean update(@Valid EditRequest req);

    Boolean deleteById(Long id);
}
