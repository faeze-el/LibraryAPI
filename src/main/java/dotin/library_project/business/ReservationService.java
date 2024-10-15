package dotin.library_project.business;

import dotin.library_project.data.converter.ReservationRequestConverter;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.entity.User;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.enums.BookStatus;
import dotin.library_project.data.enums.ReservationStatus;
import dotin.library_project.data.entity.ReservationRequest;
import dotin.library_project.exception_handler.MyException;
import dotin.library_project.repository.BookRepository;
import dotin.library_project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
//    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public ReservationService(@Qualifier("reservationRepositoryByDb") ReservationRepository reservationRepository, @Qualifier("bookRepositoryByDb") BookRepository bookRepository) {
        this.reservationRepository = reservationRepository;
        this.bookRepository = bookRepository;
    }

    public List<ReservationRequest> getReservationRequestList() {
        return reservationRepository.getAllReservations();
    }
    public List<ReservationRequest> getReservationsByUserId(Long userId) {
        return reservationRepository.getReservationsByUserId(userId);
    }
    public String addNewReservation(ReservationRequestDto requestDto, User user) throws MyException {
        Book book = bookRepository.getBookById(requestDto.getBookId());
        if (book == null || book.getBookStatus()!=BookStatus.BOOKABLE)
            throw new MyException("Not valid inputs",HttpStatus.BAD_REQUEST);
        ReservationRequest request = ReservationRequestConverter.convertToReservationRequest(requestDto, user);
        reservationRepository.addReservation(request);
        return "Reservation request added successfully";
    }
    public String updateReservation(Long id, ReservationStatus status) throws MyException {
        if (id<=0) throw new MyException("Enter a positive Id.",HttpStatus.BAD_REQUEST);

        ReservationRequest request = reservationRepository.getReservationsById(id);

        if (request == null) throw new MyException("Can not find this id", HttpStatus.NOT_FOUND);

        boolean flag = reservationRepository.updateReservation(id, status);
        if (!flag) throw new MyException("Update failed.", HttpStatus.INTERNAL_SERVER_ERROR);

        bookRepository.updateStatusById(request.getBookId(), status== ReservationStatus.APPROVED? BookStatus.NOT_BOOKABLE : BookStatus.BOOKABLE);
        return String.format("Reservation request %s .",status);
        }
}
