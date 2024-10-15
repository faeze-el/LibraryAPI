package dotin.library_project.web;

import lombok.Getter;

@Getter
public class ApiResponse <T>{
    private boolean success;
    private String message;
    private T data;

    public ApiResponse(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
