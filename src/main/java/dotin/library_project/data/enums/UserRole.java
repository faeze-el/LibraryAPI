package dotin.library_project.data.enums;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ROLE_READER,
    ROLE_LIBRARIAN,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
