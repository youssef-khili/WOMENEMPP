package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  IUserService iUserService;

    // http://localhost:8080/SpringMVC/user/add-user
    @PostMapping("/add-user")
    @ResponseBody
    public User addUser(@RequestBody User u){
        return iUserService.addUser(u);
    }


}
