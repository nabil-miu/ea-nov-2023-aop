package edu.miu.cs544.labs.lab3.service;

import edu.miu.cs544.labs.lab3.entity.ActivityLog;
import edu.miu.cs544.labs.lab3.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActivityLogServiceImpl implements ActivityLogService {
    private final ActivityLogRepository repo;

    @Override
    public List<ActivityLog> findAll() {
        return repo.findAll();
    }

    @Override
    public Optional<ActivityLog> findById(long id) {
        return repo.findById(id);
    }

    @Override
    public void save(ActivityLog product) {
        repo.save(product);
    }

    @Override
    public void delete(long id) {
        repo.deleteById(id);
    }

    @Override
    public void update(ActivityLog activityLog) {
        repo.save(activityLog);
    }
}
