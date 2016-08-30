package blog.services;

import blog.models.User;

import java.util.List;

/**
 * Created by Hristo on 05.08.2016 г..
 */
public interface UserService {
    boolean authenticate(String username, String password_hash);
    //boolean authenticate(String username);
    boolean authenticate(String username, String password_hash, String fullname, String email);
    boolean checkUsername(String username);
    boolean checkEmailExist(String email);
    List<User> findAll();
    User findById(Long id);
    //
    List<User> findByName(String username);//
    User findByUsername(String username);//
    User findByEmail(String email);//
    User findFilterByEmail(String email);
    User create(User user);
    User edit(User user);
    void deleteById(Long id);
}
