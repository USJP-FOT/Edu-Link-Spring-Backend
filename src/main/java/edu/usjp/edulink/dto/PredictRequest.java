package edu.usjp.edulink.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PredictRequest {
    @NotBlank
    private String image_b64;
    private String actualValue;
    private Integer trashBinId;
    private Boolean return_reason = Boolean.TRUE;

}
