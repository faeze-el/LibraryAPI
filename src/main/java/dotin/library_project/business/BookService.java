package dotin.library_project.business;

import dotin.library_project.data.converter.BookConverter;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.dto.BookDto;
import dotin.library_project.exception_handler.MyException;
import dotin.library_project.repository.BookRepository;
import dotin.library_project.web.ApiResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(@Qualifier("bookRepositoryByDb") BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }

    public ApiResponse<?> getBooks() throws MyException {
        List<Book> books = bookRepository.getAllBooks();
        if(books==null || books.isEmpty())
            throw new MyException("There is nothing", HttpStatus.NO_CONTENT);
        return new ApiResponse<>(true,books);

    }
    public ApiResponse<?> addNewBook(BookDto bookdto) throws MyException {
        Optional<Book> book = BookConverter.convertToBook(bookdto);
        if(!book.isPresent()) {
            throw new MyException("Not valid inputs",HttpStatus.BAD_REQUEST);
        }
        bookRepository.addBook(book.get());
        return new ApiResponse<>(true,"Book added successfully");
    }
    public ApiResponse<?> getBookById(Long id) throws Exception {
        if (id<=0) throw new MyException("Enter a positive Id.",HttpStatus.BAD_REQUEST);
        final Book result =  bookRepository.getBookById(id);
        if (result==null) throw new MyException("There is nothing",HttpStatus.NOT_FOUND);
        return new ApiResponse<>(true,result);
    }
    @Transactional
    public ApiResponse<?> removeBookByTitle( String title) throws MyException {
        if (Objects.isNull(title) || title.isEmpty()) throw  new MyException("Enter a valid title.",HttpStatus.BAD_REQUEST);
        boolean flag =  bookRepository.removeBookByTitle(title);
        if(!flag) throw new MyException("Can not find the book",HttpStatus.NOT_FOUND);

        return new ApiResponse<>(true,"Book removed");
    }
}