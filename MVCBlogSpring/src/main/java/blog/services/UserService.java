package blog.services;

import blog.models.User;

import java.util.List;

/**
 * Created by Hristo on 05.08.2016 г..
 */
public interface UserService {
    boolean authenticate(String username, String password);
    boolean authenticate(String username, String password, String fullname);
    List<User> findAll();
    User findById(Long id);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
