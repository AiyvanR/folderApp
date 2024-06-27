package com.example.demo.Repository;

import com.example.demo.Entity.Folders;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface FolderRepository extends JpaRepository<Folders, Long> {
}
