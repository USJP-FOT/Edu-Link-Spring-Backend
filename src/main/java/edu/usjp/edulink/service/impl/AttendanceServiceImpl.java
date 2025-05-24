package edu.usjp.edulink.service.impl;

import edu.usjp.edulink.dto.Attendance;
import edu.usjp.edulink.dto.Student;
import edu.usjp.edulink.entity.AttendanceEntity;
import edu.usjp.edulink.repository.AttendanceRepository;
import edu.usjp.edulink.repository.StudentRepository;
import edu.usjp.edulink.service.AttendanceService;
import edu.usjp.edulink.socket.AttendanceSocket;
//import edu.usjp.edulink.socket.MessageSender;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;
//    private final MessageSender sender;
    private final AttendanceSocket attendanceSocket;


    @Override
    public void markAttendant(Attendance attendance) {
        if (!attendanceRepository.existsByStudentId(attendance.getStudentId())) {
            if (studentRepository.existsById(attendance.getStudentId())) {

                attendanceRepository.save(modelMapper.map(attendance, AttendanceEntity.class));


//                Student student = modelMapper.map(studentRepository.findStudentEntityById(attendance.getStudentId()), Student.class);
//                sender.sendMessage(student);

                attendance.setStudentName(studentRepository.findStudentEntityById(attendance.getStudentId()).getName());
                attendanceSocket.brodeCast(attendance);
            }
        }
    }

    @Override
    public List<Attendance> getAll() {
        List<Attendance> attendanceList = new ArrayList<>();
        List<AttendanceEntity> attendanceEntities = attendanceRepository.findAll();

        attendanceEntities.forEach(attendanceEntity -> {
            attendanceList.add(modelMapper.map(attendanceEntity, Attendance.class));
        });

        attendanceList.forEach(attendance -> {
            attendance.setStudentName(studentRepository.findStudentEntityById(attendance.getStudentId()).getName());
        });
        return attendanceList;
    }

    @Override
    public void delete(Integer id) {
        attendanceRepository.deleteById(id);
    }
}
