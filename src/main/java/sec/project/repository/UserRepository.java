package sec.project.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sec.project.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public List<User> findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public List<User> findByUsername(String username);
    
    @Query(value = "?1", nativeQuery = true)
    public List<User> query(String query);
}
