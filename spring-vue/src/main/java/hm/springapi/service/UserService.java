//–¢Žg—p
package hm.springapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import hm.springapi.domain.User;
import hm.springapi.domain.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}