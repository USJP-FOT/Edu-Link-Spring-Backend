package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.PredictRequest;
import edu.usjp.edulink.dto.trashdto.TrashBin;
import edu.usjp.edulink.entity.TrashBinEntity;
import edu.usjp.edulink.service.TrashBinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/trashBin")
public class TrashBinController {

    final private TrashBinService trashBinService;

    @PostMapping("/add")
    public TrashBinEntity createTrashBin(@RequestBody TrashBin trashBin) {
        return trashBinService.addTrashBin(trashBin);
    }
    @GetMapping("/all")
    public List<TrashBin> getAllTrashBin() {
        return trashBinService.getAll();
    }

    @PutMapping("/set-Capacity")
    public ResponseEntity<String> updateTrashBinCapacity(@RequestParam(value = "id") Integer id, @RequestParam(value = "capacity") Integer capacity) {

        Boolean responseStatus = trashBinService.updateTrashBinCapacity(id, capacity);
        if (responseStatus) {
            return ResponseEntity.ok("capacity updated success");
        }else {
            return ResponseEntity.badRequest().body("capacity update failed");
        }

    }
    @PutMapping("/garbage-type")
    public ResponseEntity<?> tellGarbageType(@RequestParam(value = "id") Integer id, @RequestParam(value = "garbageType") Integer garbageType) {

        Boolean responseStatus = trashBinService.tellType(id,garbageType);
        if (responseStatus) {
            return ResponseEntity.ok("garbage type updated success");
        }else return ResponseEntity.badRequest().body("garbage type update failed invalid id");
    }
    @PutMapping("/type")
    public ResponseEntity<?> tellType(@RequestBody PredictRequest predictRequest) {
       String responseStatus = trashBinService.tellType(predictRequest);
        if (responseStatus != null) {
            return ResponseEntity.ok("type updated : " + responseStatus);
        } else return ResponseEntity.badRequest().body("type update failed invalid id");
    }
}
