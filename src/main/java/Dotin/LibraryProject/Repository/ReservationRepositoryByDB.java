package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Entity.Enums.ReservationStatus;
import Dotin.LibraryProject.Entity.ReservationRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ReservationRepositoryByDB implements ReservationRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<ReservationRequest> getAllReservations() {
        TypedQuery<ReservationRequest> query = em.createQuery("SELECT r FROM ReservationRequest r", ReservationRequest.class);
        return query.getResultList();
    }

    @Override
    public ReservationRequest getReservationsById(Long id) {
        TypedQuery<ReservationRequest> query = em.createQuery("SELECT r FROM ReservationRequest r WHERE r.userId = :userId", ReservationRequest.class);
        query.setParameter("userId", id);
        return query.getSingleResult();
    }

    @Transactional
    @Override
    public void addReservation(ReservationRequest reservation) {
        em.persist(reservation);
    }

    @Transactional
    @Override
    public boolean updateReservation(Long id, String isApprove) {
        isApprove = isApprove.toLowerCase();
        boolean isUpdate = false;
        ReservationRequest request = em.find(ReservationRequest.class, id);
        if (request != null){
            if (isApprove.equals("approve")) {
                request.setReservationStatus(ReservationStatus.APPROVED);
            }
            else if (isApprove.equals("reject")) {
                request.setReservationStatus(ReservationStatus.REJECTED);
            }
            isUpdate = true;
        }
        return isUpdate;
    }
}