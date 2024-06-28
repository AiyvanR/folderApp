package com.example.demo.Service.impl;

import com.example.demo.Entity.Folders;
import com.example.demo.Entity.MyUser;
import com.example.demo.Entity.TaskCategories;
import com.example.demo.Entity.Tasks;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.FolderRepository;
import com.example.demo.Repository.TasksRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FolderServiceImpl implements FolderService {

    CategoryRepository categoryRepository;
    FolderRepository folderRepository;
    TasksRepository tasksRepository;

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public FolderServiceImpl(CategoryRepository categoryRepository, FolderRepository folderRepository, TasksRepository tasksRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.categoryRepository = categoryRepository;
        this.folderRepository = folderRepository;
        this.tasksRepository = tasksRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Folders> getAllFolders() {
        return folderRepository.findAll();
    }

    @Override
    public Folders getFolder(long id) {
        var folder = folderRepository.findById(id);
        if(folder.isPresent()){
            return folder.get();
        }else{
            throw new RuntimeException("something went wrong with id = " + id);
        }
    }

    @Override
    public Folders saveFolder(Folders folders) {
        return folderRepository.save(folders);
    }

    @Override
    public void deleteFolder(Long id) {
        folderRepository.delete(getFolder(id));
    }

    @Override
    public Folders updateFolder(Folders folders) {
        return folderRepository.save(folders);
    }

    @Override
    public List<TaskCategories> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public TaskCategories getCategory(Long id) {
        var category = categoryRepository.findById(id);

        if(category.isPresent()){
            return category.get();
        }else{
            throw new RuntimeException("something went wrong with id= "+id);
        }
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.delete(getCategory(id));
    }

    @Override
    public List<Tasks> getAllTasks() {
        return tasksRepository.findAll();
    }

    @Override
    public Tasks getTask(Long id) {
        var task = tasksRepository.findById(id);

        if(task.isPresent()){
            return task.get();
        }else{
            throw new RuntimeException("something went wrong with id= "+id);
        }
    }

    @Override
    public void deleteTask(Long id) {
        tasksRepository.delete(getTask(id));
    }

    @Override
    public Tasks updateTask(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public Tasks saveTask(Tasks task) {
        return tasksRepository.save(task);
    }

    @Override
    public List<Tasks> findAllByFolder_Id(Long id) {
        return tasksRepository.findAllByFolder_Id(id);
    }


    @Override
    public void addUser(MyUser user) {
        var User = user;
        User.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(User);
    }
}
