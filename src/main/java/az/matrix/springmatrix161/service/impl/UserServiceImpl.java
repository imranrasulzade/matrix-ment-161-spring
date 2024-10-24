package az.matrix.springmatrix161.service.impl;

import az.matrix.springmatrix161.exception.AlreadyExistsException;
import az.matrix.springmatrix161.dto.UserDto;
import az.matrix.springmatrix161.entity.User;
import az.matrix.springmatrix161.mapper.UserMapper;
import az.matrix.springmatrix161.repository.AccountRepository;
import az.matrix.springmatrix161.repository.UserRepository;
import az.matrix.springmatrix161.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Value("${secret.key}")
    private String key;

    @Override
    public void add(UserDto userDto) {
        Optional<User> userOptional = userRepository.findByEmail(userDto.getEmail());
            if (userOptional.isPresent()) {
                throw new AlreadyExistsException("User already exists");
            }
            User user = userMapper.toEntity(userDto);
            userRepository.save(user);
    }

    @Override
    public void update(UserDto userDto) {
        User user = userRepository.findById(userDto.getId()).get();
        userMapper.mapForUpdate(user, userDto);
//        throw new AlreadyExistsException("dslsdms");
        userRepository.save(user);

    }

    @Override
    public List<UserDto> getUsers() {
        return null;
    }

    @Override
    @Transactional
    public void updateV1(Long id) {
        User user = userRepository.findById(id).get();
        user.setName(user.getName()+"!");
    }

}
