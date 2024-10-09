package dotin.library_project.entity.enums;

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
