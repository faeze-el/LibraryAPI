package dotin.library_project.repository;

import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.entity.User;
import dotin.library_project.entity.enums.ReservationStatus;
import dotin.library_project.entity.enums.UserRole;
import org.springframework.context.annotation.Profile;
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
    private final List<ReservationRequest> list = new ArrayList<>(Arrays.asList(
            new ReservationRequest(1L, 1L,  randomDate(), randomDate(), ReservationStatus.PENDING_APPROVAL,usersList.get(0) ),
            new ReservationRequest(2L, 1L,  randomDate(), randomDate(), ReservationStatus.PENDING_APPROVAL, usersList.get(1))
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