package hummel.dao.ex;

import hummel.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("InterfaceNeverImplemented")
@Repository
public interface BookDaoEx extends JpaRepository<Book, Integer> {
}