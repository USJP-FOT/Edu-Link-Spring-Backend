package edu.usjp.edulink.service.impl;



import edu.usjp.edulink.dto.EditRequest;
import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.PredictResponse;
import edu.usjp.edulink.dto.trashdto.TrashData;
import edu.usjp.edulink.entity.TrashDataEntity;
import edu.usjp.edulink.repository.TrashDataRepository;
import edu.usjp.edulink.service.ClassificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClipClassificationService implements ClassificationService {

    private  final TrashDataRepository trashDataRepository;
    private final ModelMapper modelMapper;

    @Override
    public PredictResponse classify(PredictRequest request) {
        PredictResponse response = classifyImage(request);

        String image = request.getImage_b64();
        String actualValue = request.getActualValue();
        String predictedValue = response.getLabel();
        String confidence = Double.toString(response.getConfidence());
        Timestamp timestamp = new Timestamp(new Date().getTime());

        TrashDataEntity trashDataEntity = new TrashDataEntity(null,image,actualValue,predictedValue,confidence,timestamp);

        trashDataRepository.save(trashDataEntity);
        return response;
    }

    @Override
    public List<TrashData> getAll() {
        List<TrashData> list = new ArrayList<>();
        trashDataRepository.findAll().forEach(trashDataEntity -> {
            list.add(modelMapper.map(trashDataEntity, TrashData.class));
        });
        return list;
    }

    @Override
    public TrashData findById(Long id) {
        return modelMapper.map(trashDataRepository.findById(id).get(), TrashData.class);
    }

    @Override
    public Boolean update(EditRequest req) {
        TrashDataEntity save = trashDataRepository.save(modelMapper.map(req, TrashDataEntity.class));
        return save.getId() != null;
    }

    @Override
    public Boolean deleteById(Long id) {

        try {
            trashDataRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private PredictResponse classifyImage(PredictRequest request) {
        String url = "http://localhost:8000/classify";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PredictRequest> entity = new HttpEntity<>(request, headers);

        // Send request and parse response
        return restTemplate.postForObject(url, entity, PredictResponse.class);
    }
}
