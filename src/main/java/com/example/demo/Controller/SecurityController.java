package com.example.demo.Controller;

import com.example.demo.Entity.MyUser;
import com.example.demo.Service.FolderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shop")
@AllArgsConstructor
public class SecurityController {

    private final FolderService folderService;

    @PostMapping("/new-user")
    public void addUser(@RequestBody MyUser user){
        folderService.addUser(user);
        System.out.println("User is saved");
    }
}
