package com.social.media.controller;

import com.social.media.models.SocialUser;
import com.social.media.services.SocialService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SocialController {

    @Autowired
    private SocialService socialService;

    @GetMapping("/social/users")
    public ResponseEntity<List<SocialUser>> getUsers(){
        return new ResponseEntity<>(socialService.getAllUsers() , HttpStatus.OK);

    }

    @PostMapping("/social/users")
    public ResponseEntity<SocialUser> addUser(@RequestBody SocialUser socialUser){
        return new ResponseEntity<>(socialService.saveUser(socialUser) , HttpStatus.CREATED);
    }


    @DeleteMapping("/social/users/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        socialService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully" , HttpStatus.OK);
    }


}
