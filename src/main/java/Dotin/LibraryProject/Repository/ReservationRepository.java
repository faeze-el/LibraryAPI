package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.ReservationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<ReservationRequest,Long> {
    public List<ReservationRequest> getReservationRequestByUserId(Long id);
}
