package edu.usjp.edulink.controller;

import edu.usjp.edulink.dto.academicdto.ClassRoom;
import edu.usjp.edulink.repository.ClassRoomRepository;
import edu.usjp.edulink.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/classRoom")
@Slf4j
@RequiredArgsConstructor
public class ClassRoomController {

private final ClassRoomService classRoomService;

    @PostMapping("/add")
    public ResponseEntity<String> createClassRoom(@RequestBody ClassRoom classRoom) {
        log.debug("Creating classroom with id {}", classRoom.toString());


        try {

            if (classRoomService.add(classRoom)){
                return new ResponseEntity<>("Success", HttpStatus.OK);
            }
            return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }


    }

    public ResponseEntity<String> updateClassRoom(@RequestBody ClassRoom classRoom) {
        return ResponseEntity.ok().body("Success");
    }
    public ResponseEntity<String> deleteClassRoom(@RequestBody ClassRoom classRoom) {
        return ResponseEntity.ok().body("Success");
    }
    public ResponseEntity<ClassRoom> getClassRoom(Integer id) {
        return null;
    }

}
