package sec.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sec.project.domain.User;

public interface LoginRepository extends JpaRepository<User, Long> {
       
    @Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2")
    public List<User> findLogin(String email, String password);
    
}
