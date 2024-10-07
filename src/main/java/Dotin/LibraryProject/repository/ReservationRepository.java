package Dotin.LibraryProject.repository;

import Dotin.LibraryProject.entity.enums.ReservationStatus;
import Dotin.LibraryProject.entity.ReservationRequest;

import java.util.List;

public interface ReservationRepository {
    public List<ReservationRequest> getAllReservations();
    public ReservationRequest getReservationsById(Long id);
    public void addReservation(ReservationRequest reservation);
    public boolean updateReservation(Long id, ReservationStatus status);
}
