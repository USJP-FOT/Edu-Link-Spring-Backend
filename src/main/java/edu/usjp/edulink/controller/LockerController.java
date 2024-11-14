package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Locker;
import edu.usjp.edulink.service.LockerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locker")
@RequiredArgsConstructor
public class LockerController {
    private final LockerService lockerService;

    @PostMapping("/add")
    public void addLocker(@RequestBody Locker locker) {
        //
        //To Do
        //
    }

    @DeleteMapping("/delete")
    public void deleteLocker(@RequestParam(value = "id") Integer id) {
        //
        //To do
        //
    }

}

