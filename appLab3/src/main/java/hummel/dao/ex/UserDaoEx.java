package hummel.dao.ex;

import hummel.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("InterfaceNeverImplemented")
@Repository
public interface UserDaoEx extends JpaRepository<User, Integer> {
}