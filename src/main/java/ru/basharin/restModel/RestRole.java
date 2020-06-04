package ru.basharin.restModel;

import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Set;

public class RestRole implements GrantedAuthority {

    private long id;
    private String role;
    private Set<RestUser> userSet;

    public RestRole(long id, String role) {
        this.id = id;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<RestUser> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<RestUser> userSet) {
        this.userSet = userSet;
    }

    @Override
    public String getAuthority() {
        return getRole();
    }
}
