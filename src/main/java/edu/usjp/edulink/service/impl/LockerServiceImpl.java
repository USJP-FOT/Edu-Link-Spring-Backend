package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.Locker;
import edu.usjp.edulink.entity.LockerEntity;
import edu.usjp.edulink.repository.LockerRepository;
import edu.usjp.edulink.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LockerServiceImpl implements LockerService {
    private final LockerRepository lockerRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Locker> getAll() {

        ArrayList<Locker> lockers = new ArrayList<>();

        lockerRepository.findAll().forEach(lockerEntity -> {
            lockers.add(modelMapper.map(lockerEntity, Locker.class));
        });

        return lockers;
    }

    @Override
    public void addLocker(Locker locker) {
        lockerRepository.save(modelMapper.map(locker, LockerEntity.class));
    }

    @Override
    public void setLocker(Integer id, Boolean set) {
        lockerRepository.findById(id).ifPresent(locker -> {
            locker.setIsLocked(set);
            lockerRepository.save(locker);
        });

        /*if (lockerRepository.existsById(id)) {
            LockerEntity locker = lockerRepository.findById(id).get();
            locker.setIsLocked(!locker.getIsLocked());
            lockerRepository.save(locker);
        }*/

    }

    @Override
    public Boolean getLocker(Integer id) {
        return modelMapper.map(lockerRepository.findById(id), Locker.class).getIsLocked();
    }
}
