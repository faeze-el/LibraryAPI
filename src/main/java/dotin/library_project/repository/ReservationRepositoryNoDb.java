package dotin.library_project.repository;

import dotin.library_project.data.Book;
import dotin.library_project.data.ReservationRequest;
import dotin.library_project.data.User;
import dotin.library_project.data.enums.BookStatus;
import dotin.library_project.data.enums.ReservationStatus;
import dotin.library_project.data.enums.UserRole;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Profile("dev")
@Repository
class ReservationRepositoryNoDb implements ReservationRepository{
    private final List<User> usersList = new ArrayList<>(Arrays.asList(
            new User(1L, "User1", "mina", "123456", UserRole.ROLE_ADMIN, true, Collections.emptyList()),
            new User(2L, "User2", "ali","123456", UserRole.ROLE_LIBRARIAN,true, Collections.emptyList()),
            new User(3L, "User3","akbar", "123456", UserRole.ROLE_READER,true, Collections.emptyList())
    ));
    private List<Book> booksList = new ArrayList<>(Arrays.asList(
            new Book(1L, "book1", BookStatus.BOOKABLE),
            new Book(2L, "book2", BookStatus.BOOKABLE),
            new Book(3L, "book3", BookStatus.BOOKABLE)
    ));
    private final List<ReservationRequest> list = new ArrayList<>(Arrays.asList(
            new ReservationRequest(1L,   randomDate(), randomDate(), ReservationStatus.PENDING_APPROVAL,2L,usersList.get(0) ),
            new ReservationRequest(2L,   randomDate(), randomDate(), ReservationStatus.PENDING_APPROVAL, 3L,usersList.get(1))
    ));

    public List<ReservationRequest> getAllReservations() {
        return list;
    }
    public ReservationRequest getReservationsById(Long id){
        for(ReservationRequest r : list){
            if(Objects.equals(r.getUser().getId(), id)) return r;
        }
        return null;
    }
    public void addReservation(ReservationRequest reservation) {
        reservation.setRequestId((long) (list.size()+1));
        list.add(reservation);
    }

    @Override
    public boolean updateReservation(Long id, ReservationStatus status) {
        ReservationRequest request = null;
        for (ReservationRequest req : list){
            if (Objects.equals(req.getRequestId(), id))
                request = req;
        }
        if (request != null && status!=null){
            request.setReservationStatus(status);
            return true;
        }
        return false;
    }

    public static LocalDate randomDate() {
        final int maxAge = 100 * 12 * 31;
        return LocalDate.now().minusDays(new Random().nextInt(maxAge));
    }

}