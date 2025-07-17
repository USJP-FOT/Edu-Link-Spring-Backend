package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.academicdto.ClassRoom;
import edu.usjp.edulink.entity.ClassRoomEntity;
import edu.usjp.edulink.repository.ClassRoomRepository;
import edu.usjp.edulink.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final ModelMapper modelMapper;


    @Override
    public Boolean add(ClassRoom classRoom) {
        try {
            classRoomRepository.save(modelMapper.map(classRoom, ClassRoomEntity.class));

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
