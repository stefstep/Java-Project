package blog.repositories;

import blog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface UserRepository extends JpaRepository<User, Long> {
       // User findUserByUsername(String username);

       // @Query("select u from User u where u.username like %?1")
       // List<User> findByUsernameEndsWith(String username);

    //@QueryHints(value = { @QueryHint(name = "name", value = "value")},
    //        forCounting = false)
    //Page<User> findByLastname(String lastname, Pageable pageable);

   // @Query(value = "SELECT * FROM users WHERE username = ?0", nativeQuery = true)
   // User findByUsername(String username);
   @Query(
    value = "SELECT * FROM users u where u.username = :username",
           nativeQuery=true
   )
   public User findByUsername(@Param("username") String username);

    @Query(value = "SELECT * FROM users WHERE fullname = ?0", nativeQuery = true)
    List<User> findByName(String fullname);

    @Query(
            value = "SELECT * FROM users u where u.email = :email",
            nativeQuery=true
    )
    public User findByEmail(@Param("email") String email);
    //from
//http://docs.spring.io/spring-data/jpa/docs/1.4.3.RELEASE/reference/html/jpa.repositories.html
    //:
  //  @Query("select u from User u where u.fullname = :fullname or u.email = :email")
   // User findByLastnameOrFirstname(@Param("fullname") String fullname,
   //                                @Param("email") String email);

    }
