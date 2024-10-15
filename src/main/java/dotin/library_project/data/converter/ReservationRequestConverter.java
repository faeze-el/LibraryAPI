package dotin.library_project.data.converter;

import dotin.library_project.business.ReservationService;
import dotin.library_project.business.UserService;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.entity.ReservationRequest;
import dotin.library_project.data.entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Optional;

public class ReservationRequestConverter {

    public static ReservationRequestDto convertToReservationRequestDto(ReservationRequest request) {
        ReservationRequestDto reservationRequestDto = new ReservationRequestDto();
        reservationRequestDto.setIssueDate(request.getIssueDate());
        reservationRequestDto.setReturnDate(request.getReturnDate());
        reservationRequestDto.setBookId(request.getBookId());
        return reservationRequestDto;
    }

    public static ReservationRequest convertToReservationRequest(ReservationRequestDto requestDto, User user) {
        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setIssueDate(requestDto.getIssueDate());
        reservationRequest.setReturnDate(requestDto.getReturnDate());
        reservationRequest.setBookId(requestDto.getBookId());
        reservationRequest.setUser(user);
        return reservationRequest;
    }
}
