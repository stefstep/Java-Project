package blog.services;

import blog.models.User;
import blog.repositories.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Primary
public class UserServiceJpaImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    //@Autowired
    //private PersonRepository personRepo;
    @Override
    public boolean authenticate(String username, String password_hash) {
        // Provide a sample password check: username == password
        return Objects.equals(username, password_hash);
    }
    //public boolean authenticate(String username) {
        // Provide a sample password check: username == password
       // return Objects.equals(username);
    //}
    public boolean authenticate(String username, String password_hash, String fullname,String email) {
        // Provide a sample password check: username == password
        return Objects.equals(username, password_hash);
    }

    @Override
    public List<User> findAll() {
        return this.userRepo.findAll();
    }
    @Override
    public User findById(Long id) {
        return this.userRepo.findOne(id);
    }
    @Override
    public User findByUsername(String username){
        return this.userRepo.findByUsername(username);
    }
    @Override
    public List<User> findByName(String username) {
        //List<User> persons;
        return this.userRepo.findByName(username);
    }
    @Override
    public User findByEmail (String email) {
        return this.userRepo.findByEmail(email);
    }

    @Override
    public boolean checkUsername (String username) {
       // return this.userRepo.findByEmail();
        User user=new User();
        try {
            user = userRepo.findByUsername(username);
            if (user.getUsername().equals(username)) {
                return true;
            }
        }catch (Exception e){ return false;};
        return  false;
    }

    @Override
    public boolean checkEmailExist (String email) {
        // return this.userRepo.findByEmail();
        User user=new User();
        try {
            user = userRepo.findByEmail(email);
            if (user.getEmail().equals(email)) {
                return true;
            }
        }catch (Exception e){ return false;};
        return  false;
    }
    //@Override
    public User findFilterByEmail (String email){
        return this.userRepo.findAll().stream()
                .filter(p -> Objects.equals(p.getEmail(), email))
                .findFirst()
                .orElse(null);
    }
     //
    @Override
    public User create(User user) {
       // user.setPassword_hash(password_hash);
        String hashed = BCrypt.hashpw(user.getPassword_hash(), BCrypt.gensalt());
        user.setPassword_hash(hashed);
        return this.userRepo.save(user); }

    @Override
    public User edit(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public void deleteById(Long id) {
        this.userRepo.delete(id);
    }
}
