package edu.usjp.edulink.service;

import edu.usjp.edulink.dto.Announcement;

import java.util.List;

public interface AnnouncementService {
    void addAnnouncement(Announcement announcement);

    List<Announcement> getAllAnouncement();

    void deleteById(Integer id);
}
