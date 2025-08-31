package edu.usjp.edulink.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PredictResponse {
    private String label;
    private double confidence;
    private String reason;
}
