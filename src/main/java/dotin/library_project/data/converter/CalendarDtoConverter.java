package dotin.library_project.data.converter;

import dotin.library_project.data.dto.CalendarDto;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.enums.ReservationStatus;

import java.time.ZoneId;
import java.util.Date;

public class CalendarDtoConverter {
    public static CalendarDto toCalendarDto(final ReservationRequestDto requestDto, Book book) {
        CalendarDto calendarDto = new CalendarDto();
        String title = String.format("Reservation status for <%s> book is %s",book.getTitle() , ReservationStatus.PENDING_APPROVAL.toString());
        calendarDto.setTitle(title);
        Date date1 =  Date.from(requestDto.getIssueDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date date2 =  Date.from(requestDto.getReturnDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        calendarDto.setStartDate(date1);
        calendarDto.setEndDate(date2);
        return calendarDto;
    }
}
