package graeme.hosford.rob.morgan.assignment2.data.dao;

import graeme.hosford.rob.morgan.assignment2.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userEmail = :email AND u.userPassword = :password")
    Optional<User> getUserAccount(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.userEmail = :email")
    User getUserFromEmail(@Param("email") String email);

}
