package jpashop.newshop.repository;

import jpashop.newshop.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

//    boolean existsByUserNm(String username);
//    boolean existsByEmail(String email);
}
