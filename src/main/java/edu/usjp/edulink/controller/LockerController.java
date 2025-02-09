package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Locker;
import edu.usjp.edulink.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locker")
@RequiredArgsConstructor
public class LockerController {
    private final LockerService lockerService;

    @GetMapping("/all")
    public List<Locker> getAll() {
        return lockerService.getAll();
    }

    @PostMapping("/add")
    public void addLocker(@RequestBody Locker locker) {
        lockerService.addLocker(locker);
    }

    @DeleteMapping("/delete")
    public void deleteLocker(@RequestParam(value = "id") Integer id) {
        //
        //To do
        //
    }

    @PatchMapping("/set-status")
    public void updateLocker(@RequestParam(value = "id") Integer id, @RequestParam(value = "set") Boolean set) {
        lockerService.setLocker(id,set);
    }

    @GetMapping("/get-status")
    public Boolean getLockerStatus(@RequestParam(value = "id") Integer id) {
        return lockerService.getLocker(id);
    }


}

