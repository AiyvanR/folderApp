package com.example.demo.Repository;

import com.example.demo.Entity.Tasks;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface TasksRepository extends JpaRepository<Tasks, Long> {
    List<Tasks> findAllByFolder_Id(Long id);
}
