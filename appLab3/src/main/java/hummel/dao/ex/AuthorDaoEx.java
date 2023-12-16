package hummel.dao.ex;

import hummel.bean.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDaoEx extends JpaRepository<Author, Integer> {
}