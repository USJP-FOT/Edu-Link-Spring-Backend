package edu.usjp.edulink.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Announcement {
    
    private int id;
    private String title;
    private String description;
}
