package az.matrix.springmatrix161.controller;

import az.matrix.springmatrix161.dto.UserDto;
import az.matrix.springmatrix161.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public void add(@RequestBody UserDto dto){
        userService.add(dto);
    }

    @PutMapping
    public void update(@RequestBody UserDto dto){
        userService.update(dto);
    }

}
