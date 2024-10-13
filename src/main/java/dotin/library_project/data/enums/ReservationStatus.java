package dotin.library_project.data.enums;

public enum ReservationStatus {
    PENDING_APPROVAL,
    APPROVED,
    REJECTED;

    public static ReservationStatus convertStringToReservationStatus(String statusString) {
        try {
            return ReservationStatus.valueOf(statusString);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
