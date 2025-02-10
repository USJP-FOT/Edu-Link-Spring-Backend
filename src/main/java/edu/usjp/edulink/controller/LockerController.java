package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.Locker;
import edu.usjp.edulink.service.LockerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/locker")
@RequiredArgsConstructor
public class LockerController {
    private final LockerService lockerService;

    @GetMapping("/all")
    public List<Locker> getAll() {
        log.info("Send all lockers");
        return lockerService.getAll();
    }

    @PostMapping("/add")
    public void addLocker(@RequestBody Locker locker) {
        log.info("Receive add locker or update locker");
        lockerService.addLocker(locker);
    }

    @DeleteMapping("/delete")
    public void deleteLocker(@RequestParam(value = "id") Integer id) {
        //
        //To do
        //
    }

    @PutMapping("/set-status")
    public void updateLocker(@RequestParam(value = "id") Integer id, @RequestParam(value = "set") Boolean set) {
        log.info("Receive locker {} update status to {}",id, set);
        lockerService.setLocker(id,set);
    }

    @GetMapping("/get-status")
    public Boolean getLockerStatus(@RequestParam(value = "id") Integer id) {
        Boolean status = lockerService.getLocker(id);
        log.info("Send locker status {} to locker {}",status, id);
        return status;
    }

    @PutMapping("/set-pen-status")
    public void setPenStatus(@RequestParam(value = "id") Integer id, @RequestParam(value = "set") Boolean set) {
        log.info("Receive pen {} update status to locker {}",id ,set);
        lockerService.setPen(id,set);
    }

    @GetMapping("/get-pen-status")
    public Boolean getPenStatus(@RequestParam(value = "id") Integer id) {
        Boolean status = lockerService.getPenStatus(id);
        log.info("Receive pen status {} to locker {}",status, id);
        return status;
    }

}

