/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.owen.controllers;

import com.owen.components.JwtService;
import com.owen.pojo.Rating;
import com.owen.pojo.User;
import com.owen.service.AppointmentService;
import com.owen.service.RatingService;
import com.owen.service.UserService;
import java.io.File;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Autowired
    private AppointmentService appointmentService;

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Model model, @PathVariable(value = "id") int id) {
        this.userService.deleteUser(id);

    }
    
    @GetMapping("/delete/{id}")
    public ResponseEntity<Integer> canhbaodeleteuser(@PathVariable(value = "id") int id) {
        User u = this.userService.getUserById(id);
        return new ResponseEntity<>(this.appointmentService.CountAppointmentbyUser(u), HttpStatus.OK);
    }
    
    @GetMapping("/deletes/{id}")
    public ResponseEntity<Integer> canhbaodeleteuser1(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(id, HttpStatus.OK);
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

    }

    @GetMapping("/benhnhan/{id}/rating")
    public ResponseEntity<List<Rating>> listbenhNhanRating(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(this.RatingService.getRatingsByIdSickPerson(id), HttpStatus.OK);
    }

    @PostMapping("/user/update")
    public ResponseEntity<Boolean> updatetaikhoan(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User usercurrent = this.userService.getUserByUsername(userDetails.getUsername());
        return new ResponseEntity<>(this.userService.updateTaiKhoan(usercurrent, params, avatar), HttpStatus.OK);
    }

    @GetMapping("/check/{username}/{id}")
    public ResponseEntity<Boolean> checkusernameforupdate(@PathVariable(value = "username") String username, @PathVariable(value = "id") int id) {
        User user = this.userService.getUserById(id);
        if (!user.getUsername().equals(username)) {
            return new ResponseEntity<>(this.userService.checkUserName(username), HttpStatus.OK);
        }
            return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/check/{username}")
    public ResponseEntity<Boolean> checkusernameforadd(@PathVariable(value = "username") String username
    ) {
        return new ResponseEntity<>(this.userService.checkUserName(username), HttpStatus.OK);
    }

}
