package edu.usjp.edulink.service;

import edu.usjp.edulink.dto.Locker;

import java.util.List;

public interface LockerService {
    List<Locker> getAll();

    void addLocker(Locker locker);

    void setLocker(Integer id, Boolean set);

    Boolean getLocker(Integer id);

    void setPen(Integer id, Boolean set);

    Boolean getPenStatus(Integer id);
}
