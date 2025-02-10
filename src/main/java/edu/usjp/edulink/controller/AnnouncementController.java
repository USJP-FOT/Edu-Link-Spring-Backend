package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Announcement;
import edu.usjp.edulink.service.AnnouncementService;
import edu.usjp.edulink.service.EmailService;
import edu.usjp.edulink.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
@CrossOrigin
@Slf4j
@RequiredArgsConstructor
public class AnnouncementController {
    private final AnnouncementService announcementService;


    @PostMapping("/add")// Add Announcement
    public void addAnnouncement(@RequestBody Announcement announcement) {
        log.info("Add announcement: {}", announcement);
        announcementService.addAnnouncement(announcement);
    }

    @GetMapping("/get-all")//Return All Announcement
    public List<Announcement> getAllAnnouncement() {
        log.info("Send all announcement");
        return announcementService.getAllAnouncement();
    }

    @DeleteMapping("/delete")
    public void deleteAnnouncementById(@RequestParam(value = "id") Integer id) {
        log.info("Delete announcement: {}", id);
        announcementService.deleteById(id);
    }
}
