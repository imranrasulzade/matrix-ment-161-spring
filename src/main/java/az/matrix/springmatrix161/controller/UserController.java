package az.matrix.springmatrix161.controller;

import az.matrix.springmatrix161.dto.UserDto;
import az.matrix.springmatrix161.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody UserDto dto) {
        userService.add(dto);
    }

    @PutMapping
    public void update(@RequestBody UserDto dto) {
        userService.update(dto);
    }

    @PutMapping("/update")
    public void update(@RequestBody Long id) {
        userService.updateV1(id);
    }

}
