package com.github.hummel.wt.lab3.dao.ex;

import com.github.hummel.wt.lab3.bean.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SuppressWarnings("InterfaceNeverImplemented")
@Repository
public interface BookDaoEx extends JpaRepository<Book, Integer> {
}