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
        announcementService.addAnnouncement(announcement);
    }

    @GetMapping("/get-all")//Return All Announcement
    public List<Announcement> getAllAnnouncement() {
        return announcementService.getAllAnouncement();
    }

    @DeleteMapping("/delete")
    public void deleteAnnouncementById(@RequestParam(value = "id") Integer id) {
        announcementService.deleteById(id);
    }
}
