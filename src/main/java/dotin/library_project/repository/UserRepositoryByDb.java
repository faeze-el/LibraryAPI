package dotin.library_project.repository;
import dotin.library_project.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Profile("ByDb")
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
}