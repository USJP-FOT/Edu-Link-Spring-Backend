package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.Announcement;
import edu.usjp.edulink.entity.AnnouncementEntity;
import edu.usjp.edulink.repository.AnnouncementRepository;
import edu.usjp.edulink.service.AnnouncementService;
import edu.usjp.edulink.service.EmailService;
import edu.usjp.edulink.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository anousmentRepository;
    private final ModelMapper modelMapper;
    private final StudentService studentService;
    private final EmailService emailService;

    @Override
    public void addAnnouncement(Announcement announcement) {
        anousmentRepository.save(modelMapper.map(announcement, AnnouncementEntity.class));

        studentService.getAllStudent().forEach(student -> {
            if(student.getEmail()!=null) {
                emailService.sendEmail(student.getEmail(),announcement.getTitle(),announcement.getDescription());
            }
            else log.info("Email is not found in{}", student);

        });
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
