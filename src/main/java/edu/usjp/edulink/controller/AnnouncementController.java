package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Announcement;
import edu.usjp.edulink.service.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcement")
@CrossOrigin
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
