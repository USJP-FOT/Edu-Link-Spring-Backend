package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.repository.TrashBinRepository;
import edu.usjp.edulink.service.TrashBinService;
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


}
