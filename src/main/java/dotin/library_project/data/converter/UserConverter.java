package dotin.library_project.data.converter;

import dotin.library_project.data.dto.UserDto;
import dotin.library_project.data.entity.User;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public class UserConverter {

    public static UserDto convertToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUsername());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static User convertToUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUserName());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
