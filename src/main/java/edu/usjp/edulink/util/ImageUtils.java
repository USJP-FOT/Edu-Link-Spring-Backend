package edu.usjp.edulink.util;

import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.PredictResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.util.Base64;

public final class ImageUtils {
    private ImageUtils() {}

    public static BufferedImage decodeBase64ToImage(String imageB64) throws Exception {
        String payload = imageB64;
        int comma = imageB64.indexOf(',');
        if (imageB64.startsWith("data:") && comma > 0) {
            payload = imageB64.substring(comma + 1);
        }
        byte[] bytes = Base64.getDecoder().decode(payload);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            BufferedImage img = ImageIO.read(bais);
            if (img == null) throw new IllegalArgumentException("Unsupported image format");
            return img;
        }
    }
    public static PredictResponse classifyImage(PredictRequest request) {
        String url = "http://localhost:8000/classify";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<PredictRequest> entity = new HttpEntity<>(request, headers);

        // Send request and parse response
        return restTemplate.postForObject(url, entity, PredictResponse.class);
    }
}
