package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.PredictResponse;
import edu.usjp.edulink.dto.trashdto.TrashBin;
import edu.usjp.edulink.dto.trashdto.TrashBinGarbageType;
import edu.usjp.edulink.entity.TrashBinEntity;
import edu.usjp.edulink.repository.TrashBinRepository;
import edu.usjp.edulink.service.TrashBinService;
import edu.usjp.edulink.socket.TrashBinGarbageClassificationSocket;
import edu.usjp.edulink.util.ImageUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrashBinServiceImpl implements TrashBinService {
    private final ModelMapper modelMapper;
    private final TrashBinRepository trashBinRepository;
    private final TrashBinGarbageClassificationSocket socket;

    static {
        log.trace("TrashBinServiceImpl init");
    }


    @Override
    public TrashBinEntity addTrashBin(TrashBin trashBin) {
        return trashBinRepository.save(modelMapper.map(trashBin, TrashBinEntity.class));
    }

    @Override
    public Boolean updateTrashBinCapacity(Integer id, Integer capacity) {
        try {
            int availableCapacity = 10 - capacity;
            TrashBinEntity trashBinEntity = trashBinRepository.findById(id).stream().findFirst().get();
            log.debug("Trash bin capacity from dab while update internal available capacity: {}", trashBinEntity);
            trashBinEntity.setAvailableCapacity(availableCapacity);
            trashBinRepository.save(trashBinEntity);
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean tellType(Integer id, Integer garbageType) {
        try {
            if (trashBinRepository.existsById(id)) {
                socket.tellGarbageType(new TrashBinGarbageType(id, garbageType));
                log.trace("Trash bin capacity tellType success");
                return true;
            } else return false;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public String tellType(PredictRequest predictRequest) {
        try {
            PredictResponse response = ImageUtils.classifyImage(predictRequest);
            String label = response.getLabel();
            int type = 0;
            switch (label) {
                case "plastic" -> type = 1;
                case "Polythene" -> type = 2;
                case "glass" -> type = 3;
                case "paper" -> type = 4;
            }
            Integer trashBinId = predictRequest.getTrashBinId();

            socket.tellGarbageType(new TrashBinGarbageType(trashBinId, type));

            log.trace("Trash bin capacity tellType success");


            return label + " on " + trashBinId;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<TrashBin> getAll() {
        List<TrashBin> trashBinList = new ArrayList<>();
        trashBinRepository.findAll().forEach(trashBinEntity -> {
            trashBinList.add(modelMapper.map(trashBinEntity, TrashBin.class));
        });
        return trashBinList;
    }


}
