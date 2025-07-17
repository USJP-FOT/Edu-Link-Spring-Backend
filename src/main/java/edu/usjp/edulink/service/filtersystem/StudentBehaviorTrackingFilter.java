package edu.usjp.edulink.service.filtersystem;


import edu.usjp.edulink.dto.academicdto.ClassRoomStudentStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentBehaviorTrackingFilter {

    public Boolean isHandRice(ClassRoomStudentStatus status, Mode mode) {
        return status.getHandRice() && Mode.EXAM == mode;
    }

    public Boolean track(ClassRoomStudentStatus status, Mode mode) {

        if (mode == Mode.EXAM){
            return status.getMobilePhoneUse() || status.getTalkWithOthers();

        }
        else if (mode == Mode.LECTURE){
            return status.getMobilePhoneUse() || status.getSleep();
        }
        else if (mode == Mode.GROUP_WORK) {
            return status.getSleep();
        }

        else return false;
    }
}
