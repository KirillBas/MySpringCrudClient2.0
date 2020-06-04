package ru.basharin.restService.restServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.basharin.restModel.ListUsers;
import ru.basharin.restModel.RestUser;
import ru.basharin.restService.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Value(value = "${application.server.url}")
    private String url;

    @Override
    public List<RestUser> getUsers() {
        return restTemplate.getForObject(url + "/rest/admin/users", List.class);
    }

    @Override
    public RestUser getUserById(Long id) {
        String tempUrl = url + "/rest/user/" + id;
        System.out.println(tempUrl);
        return restTemplate.getForObject(tempUrl, RestUser.class);
    }


    @Override
    public void save(RestUser user) {
        restTemplate.postForObject(url + "/rest/admin/users", user, RestUser.class);
    }


    @Override
    public void delete(Long id) {
        restTemplate.delete(url + "/rest/admin/delete/" + id);
    }

    @Override
    public void update(RestUser user) {
        restTemplate.postForObject(url + "/rest/admin/edit/update", user, RestUser.class);
    }

    @Override
    public RestUser getUserByNameAndEmail(String name, String email) {
        return null;
    }

    @Override
    public RestUser authUser(String name, String password) {
        Map<String, String> strings = new HashMap<>();
        strings.put("name", name);
        strings.put("password", password);
        return restTemplate.postForObject(url + "/login", strings, RestUser.class);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return restTemplate.getForObject(url + "/user/name=" + name, RestUser.class);
    }
}
