package edu.usjp.edulink.controller;


import edu.usjp.edulink.dto.EditRequest;
import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.PredictResponse;
import edu.usjp.edulink.dto.trashdto.TrashData;
import edu.usjp.edulink.service.ClassificationService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class ClassificationController {

    private final ClassificationService service;

    public ClassificationController(ClassificationService service) {
        this.service = service;
    }

    @PostMapping(path = "/classify", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PredictResponse classify(@Valid @RequestBody PredictRequest req) {
        return service.classify(req);
    }

    @GetMapping("/all-data")
    public List<TrashData> all() {
        return service.getAll();
    }
    @GetMapping("/findDataById")
    public TrashData findById(@RequestParam Long id) {
        return service.findById(id);
    }
    @PostMapping("/update-recode")
    public Boolean updateRecode(@Valid @RequestBody EditRequest req) {
        return  service.update(req);
    }
    @DeleteMapping("/delete-data")
    public Boolean deleteRecode(@RequestParam Long id) {
        return  service.deleteById(id);
    }

}
