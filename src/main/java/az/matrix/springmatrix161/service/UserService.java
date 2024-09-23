package az.matrix.springmatrix161.service;

import az.matrix.springmatrix161.dto.UserDto;
import az.matrix.springmatrix161.entity.User;
import az.matrix.springmatrix161.model.Customer;

import java.util.List;

public interface UserService {
    void add(UserDto userDto);
    void update(UserDto userDto);

    List<UserDto> getUsers();
}
