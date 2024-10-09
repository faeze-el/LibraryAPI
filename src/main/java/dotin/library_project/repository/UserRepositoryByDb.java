package dotin.library_project.repository;
import dotin.library_project.entity.User;
import dotin.library_project.entity.enums.UserRole;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Profile("prod")
@Repository
class UserRepositoryByDb implements UserRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    public Optional<User> getUserByUserName(String username) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username", User.class);
        query.setParameter("username", username);
        List<User> results =  query.getResultList();
        if(results.isEmpty())
            return Optional.empty();
        else return Optional.of(results.get(0));
    }

    @Override
    public List<GrantedAuthority> getGrantedAuthorities(User u) {

        return Collections.singletonList(new SimpleGrantedAuthority(u.getRole().getAuthority()));
    }
}