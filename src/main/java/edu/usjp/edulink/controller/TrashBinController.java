package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.TrashBin;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trashBin")
public class TrashBinController {



    @GetMapping("/all")
    public List<TrashBin> getAllTrashBin() {
        return List.of();
    }

    @PostMapping
    public TrashBin createTrashBin(@RequestBody TrashBin trashBin) {
       return trashBin;
    }

    @PutMapping
    public Integer updateTrashBinCapacity(@RequestParam(value = "id") Integer id, @RequestParam(value = "capacity") Integer capacity) {
        return capacity;
    }
}
