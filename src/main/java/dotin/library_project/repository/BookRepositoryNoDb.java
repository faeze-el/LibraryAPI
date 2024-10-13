package dotin.library_project.repository;

import dotin.library_project.data.Book;
import dotin.library_project.data.enums.BookStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Profile("dev")
class BookRepositoryNoDb  implements   BookRepository{

    private static final Logger logger = LoggerFactory.getLogger(BookRepositoryNoDb.class);


    private List<Book> list = new ArrayList<>(Arrays.asList(
            new Book(1L, "book1", BookStatus.BOOKABLE),
            new Book(2L, "book2", BookStatus.BOOKABLE),
            new Book(3L, "book3", BookStatus.BOOKABLE)
    ));

    public List<Book> getAllBooks() {
        return list;
    }

    public void addBook(Book b) {
        Book book = new Book((long) list.size()+1, b.getTitle(), b.getBookStatus() );
        list.add(book);
        logger.info("{} is added to the list", b);
    }
    public Book getBookById(Long id){
        for(Book b : list){
            if (b.getBookId() == id) return b;
        }
        return null;
    }
    public Book getBookByTitle(String title){
        for(Book b : list){
            if (Objects.equals(b.getTitle(), title)) return b;
        }
        return null;
    }
    public boolean removeBookByTitle(String title){
        Book b = getBookByTitle(title);
        if(Objects.nonNull(b)){
            list.remove(b);
            return true;
        }
        return false;
    }
}