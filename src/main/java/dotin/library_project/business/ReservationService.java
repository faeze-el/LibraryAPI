package dotin.library_project.business;

import dotin.library_project.data.converter.BookConverter;
import dotin.library_project.data.converter.ReservationRequestConverter;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.entity.User;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.enums.BookStatus;
import dotin.library_project.data.enums.ReservationStatus;
import dotin.library_project.data.entity.ReservationRequest;
import dotin.library_project.repository.BookRepository;
import dotin.library_project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Converter;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<?> getReservationsByUserId(Long userId) {
        if (userId<=0) return new ResponseEntity<>("Enter a positive Id.",HttpStatus.BAD_REQUEST);
        List<ReservationRequest> requestList = reservationRepository.getReservationsByUserId(userId);
        return new ResponseEntity<>(requestList,HttpStatus.OK);
    }
    public ResponseEntity<?> addNewReservation(ReservationRequestDto requestDto, User user) {
        Book book = bookRepository.getBookById(requestDto.getBookId());
        if (book != null && book.getBookStatus()==BookStatus.BOOKABLE) {
            try {
                ReservationRequest request = ReservationRequestConverter.convertToReservationRequest(requestDto, user);
                reservationRepository.addReservation(request);
                return new ResponseEntity<>("Reservation request added successfully", HttpStatus.CREATED);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }
        return new ResponseEntity<>("Not valid inputs", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<?> updateReservation(Long id, ReservationStatus status){
        if (id<=0) return new ResponseEntity<>("Enter a positive Id.",HttpStatus.BAD_REQUEST);

        ReservationRequest req = reservationRepository.getReservationsById(id);
        if(Objects.nonNull(req)) {
            boolean flag = reservationRepository.updateReservation(id, status);
            if (flag) bookRepository.updateStatusById(req.getBookId(), status== ReservationStatus.APPROVED? BookStatus.NOT_BOOKABLE : BookStatus.BOOKABLE);
            return new ResponseEntity<>( flag ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Can not find this id", HttpStatus.NOT_FOUND);
        }
}
