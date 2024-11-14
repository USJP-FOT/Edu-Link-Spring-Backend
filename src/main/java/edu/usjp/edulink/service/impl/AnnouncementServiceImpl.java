package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.Announcement;
import edu.usjp.edulink.entity.AnnouncementEntity;
import edu.usjp.edulink.repository.AnnouncementRepository;
import edu.usjp.edulink.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository anousmentRepository;
    private final ModelMapper modelMapper;

    @Override
    public void addAnnouncement(Announcement announcement) {
        anousmentRepository.save(modelMapper.map(announcement, AnnouncementEntity.class));
    }

    @Override
    public List<Announcement> getAllAnouncement() {
        List<Announcement> announcementList = new ArrayList<>();
        anousmentRepository.findAll().forEach(announcementEntity -> {
            announcementList.add(modelMapper.map(announcementEntity, Announcement.class));
        });
        return announcementList;
    }

    @Override
    public void deleteById(Integer id) {
        anousmentRepository.deleteById(id);
    }
}
