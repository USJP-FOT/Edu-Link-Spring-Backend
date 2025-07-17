package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.trashdto.TrashBin;
import edu.usjp.edulink.dto.trashdto.TrashBinGarbageType;
import edu.usjp.edulink.entity.TrashBinEntity;
import edu.usjp.edulink.repository.TrashBinRepository;
import edu.usjp.edulink.service.TrashBinService;
import edu.usjp.edulink.socket.TrashBinGarbageClassificationSocket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
        }catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    @Override
    public Boolean tellType(Integer id, Integer garbageType) {
        try{
            if(trashBinRepository.existsById(id)){
                socket.tellGarbageType(new TrashBinGarbageType(id,garbageType));
                log.trace("Trash bin capacity tellType success");
                return true;
            } else return false;
        }catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
