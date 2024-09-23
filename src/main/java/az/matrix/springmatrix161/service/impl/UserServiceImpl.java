package az.matrix.springmatrix161.service.impl;

import az.matrix.springmatrix161.dto.UserDto;
import az.matrix.springmatrix161.entity.Account;
import az.matrix.springmatrix161.entity.User;
import az.matrix.springmatrix161.mapper.UserMapper;
import az.matrix.springmatrix161.model.Customer;
import az.matrix.springmatrix161.repository.AccountRepository;
import az.matrix.springmatrix161.repository.UserRepository;
import az.matrix.springmatrix161.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void add(UserDto userDto){
        User user = userMapper.toEntity(userDto);
        userRepository.save(user);
        if(user.getAccount() != null){
            Account account = user.getAccount();
            account.setUser(user);
            accountRepository.save(account);
        }
    }

    @Override
    public void update(UserDto userDto){
        User user = userRepository.findById(userDto.getId()).get();
        userMapper.mapForUpdate(user, userDto);
        userRepository.save(user);
        if(user.getAccount() != null){
            Account account = user.getAccount();
            account.setUser(user);
            accountRepository.save(account);
        }
    }

    @Override
    public List<UserDto> getUsers() {
       return null;
    }

}
