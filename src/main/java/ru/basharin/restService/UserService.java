package ru.basharin.restService;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.basharin.restModel.RestUser;

import java.util.List;

public interface UserService extends UserDetailsService {
    List<RestUser> getUsers();
    RestUser getUserById(Long id);
    void save(RestUser user);
    void delete(Long id);
    void update(RestUser user);
    RestUser getUserByNameAndEmail(String name, String email);
    RestUser authUser(String name, String password);
}
