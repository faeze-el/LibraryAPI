package dotin.library_project.data.converter;

import dotin.library_project.data.dto.BookDto;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.enums.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

public class BookConverter {
    public static BookDto convertToBookDto(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setTitle(book.getTitle());
        bookDto.setBookStatus(book.getBookStatus().toString());
        return bookDto;
    }

    public static Optional<Book> convertToBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        String bookStatus = bookDto.getBookStatus().trim().toUpperCase();
        if(BookStatus.isValidEnum(bookStatus)) {
            book.setBookStatus(BookStatus.valueOf(bookStatus));
            return Optional.of(book);
        }
        return Optional.empty();
    }
}
