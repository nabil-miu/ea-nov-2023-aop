package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;

import java.util.List;
import java.util.Optional;

public interface ActivityLogService {

    List<ActivityLog> findAll();

    Optional<ActivityLog> findById(long id);

    void save(ActivityLog product);

    void delete(long id);

    void update(ActivityLog activityLog);
}
