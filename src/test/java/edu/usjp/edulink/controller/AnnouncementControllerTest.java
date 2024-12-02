package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Announcement;
import edu.usjp.edulink.service.AnnouncementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnnouncementController.class)
public class AnnouncementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AnnouncementService announcementService;

    private Announcement announcement;

    @BeforeEach
    public void setUp() {
        announcement = new Announcement();
        announcement.setId(1);
        announcement.setTitle("New Announcement");
        announcement.setDescription("This is a test announcement.");
    }

    @Test
    public void testAddAnnouncement() throws Exception {
        Mockito.doNothing().when(announcementService).addAnnouncement(any(Announcement.class));

        mockMvc.perform(post("/announcement/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"title\":\"New Announcement\",\"description\":\"This is a test announcement.\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAnnouncement() throws Exception {
        Mockito.when(announcementService.getAllAnouncement()).thenReturn(Collections.singletonList(announcement));

        mockMvc.perform(get("/announcement/get-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].title").value("New Announcement"))
                .andExpect(jsonPath("$[0].description").value("This is a test announcement."));
    }

    @Test
    public void testDeleteAnnouncementById() throws Exception {
        Mockito.doNothing().when(announcementService).deleteById(1);

        mockMvc.perform(delete("/announcement/delete")
                        .param("id", "1"))
                .andExpect(status().isOk());
    }
}
