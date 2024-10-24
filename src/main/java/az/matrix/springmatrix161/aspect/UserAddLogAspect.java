package az.matrix.springmatrix161.aspect;

import az.matrix.springmatrix161.entity.User;
import az.matrix.springmatrix161.entity.UserAddLog;
import az.matrix.springmatrix161.repository.UserAddLogRepository;
import az.matrix.springmatrix161.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Aspect
@Component
@Configurable
@RequiredArgsConstructor
public class UserAddLogAspect {

    private final UserAddLogRepository addLogRepository;
    private final UserAddLogRepository userAddLogRepository;
    private final UserRepository userRepository;

    @SneakyThrows
    @AfterReturning("execution(* az.matrix.springmatrix161.repository.UserRepository.save(..))")
    public void userAddLog(JoinPoint joinPoint) {
        UserAddLog userAddLog = new UserAddLog();
        User user = (User) joinPoint.getArgs()[0];
        Optional<UserAddLog> optional = userAddLogRepository
                .findByUser_Id(user.getId());
        if(optional.isEmpty()) {
            userAddLog.setUser(user);
            userAddLog.setRegisterDate(LocalDateTime.now());
            userAddLogRepository.save(userAddLog);
            log.info("user log added");
        }
    }


}
