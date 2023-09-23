/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.components.JwtService;
import com.owen.pojo.Rating;
import com.owen.pojo.User;
import com.owen.service.RatingService;
import com.owen.service.UserService;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Trinh Bao Duy
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private RatingService RatingService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "id") int id) {
        this.userService.deleteUser(id);

    }

    @PostMapping("/login/")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> list(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.userService.getUsers(params), HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }

    @PostMapping(path = "/register",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> addUser(@RequestParam Map<String, String> params,
            @RequestPart MultipartFile avatar) {
        User user = this.userService.addUser(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> details(Principal user) {
        User u = this.userService.getUserByUsername(user.getName());
        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/login-google/")
    public ResponseEntity<String> loginGoogle(@RequestParam Map<String, String> params) {
        User userRegister = this.userService.registerUserGoogle(params);
        String token = this.jwtService.generateTokenLogin(userRegister.getUsername());
        return new ResponseEntity<>(token, HttpStatus.OK);
//        return new ResponseEntity<>(userRegister, HttpStatus.OK);

    }
    @GetMapping("/doctors")
    public ResponseEntity<List<User>> listdoctor(@RequestParam Map<String, String> params) {
        return new ResponseEntity<>(this.userService.getBacSi(params), HttpStatus.OK);
    }
    @GetMapping("/doctor/{id}")
    public ResponseEntity<User> doctor( @PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.userService.getUserById(id), HttpStatus.OK);
    }
    
    @GetMapping("/doctorRating/{id}")
    public ResponseEntity<List<Rating>> listdoctorRating( @PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.RatingService.getRatingsByIdDoctor(id), HttpStatus.OK);
    }
    
    @GetMapping("/benhnhanRating/{id}")
    public ResponseEntity<List<Rating>> listbenhNhanRating( @PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.RatingService.getRatingsByIdSickPerson(id), HttpStatus.OK);
    }

}
