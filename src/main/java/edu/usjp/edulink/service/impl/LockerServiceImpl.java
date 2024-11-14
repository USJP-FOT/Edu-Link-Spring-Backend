package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.repository.LockerRepository;
import edu.usjp.edulink.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LockerServiceImpl implements LockerService {
    private final LockerRepository lockerRepository;
    private final ModelMapper modelMapper;
}
