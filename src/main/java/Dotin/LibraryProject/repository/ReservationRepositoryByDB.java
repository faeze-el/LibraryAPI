package Dotin.LibraryProject.repository;

import Dotin.LibraryProject.entity.enums.ReservationStatus;
import Dotin.LibraryProject.entity.ReservationRequest;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Profile("ByDb")
@Repository
class ReservationRepositoryByDB implements ReservationRepository{

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
    public boolean updateReservation(Long Id, ReservationStatus status) {
        boolean isUpdate = false;
        ReservationRequest request = em.find(ReservationRequest.class, Id);
        if (request != null && status!=null){
                request.setReservationStatus(status);
                isUpdate = true;
        }
        return isUpdate;
    }
}