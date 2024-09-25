package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    Long deleteBookByTitle(String title);

}