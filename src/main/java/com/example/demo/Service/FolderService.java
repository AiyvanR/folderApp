package com.example.demo.Service;

import com.example.demo.Entity.Folders;
import com.example.demo.Entity.MyUser;
import com.example.demo.Entity.TaskCategories;
import com.example.demo.Entity.Tasks;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FolderService {
    List<Folders> getAllFolders();
    Folders getFolder(long id);
    Folders saveFolder(Folders folders);
    void deleteFolder(Long id);
    Folders updateFolder(Folders folders);

    List<TaskCategories> getAllCategories();
    TaskCategories getCategory(Long id);
    void deleteCategory(Long id);

    List<Tasks> getAllTasks();
    Tasks getTask(Long id);
    void deleteTask(Long id);
    Tasks updateTask(Tasks task);
    Tasks saveTask(Tasks task);
    List<Tasks> findAllByFolder_Id(Long id);



    void addUser(MyUser user);

}
