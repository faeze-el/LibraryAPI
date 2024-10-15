package dotin.library_project.exception_handler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class MyException extends Exception{
    private String message ;

    private HttpStatus status ;
    public MyException(String message, HttpStatus status){
        this.message = message;
        this.status = status;
    }
}
