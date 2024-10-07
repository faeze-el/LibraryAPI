package Dotin.LibraryProject.repository;


import Dotin.LibraryProject.entity.Book;
import org.hibernate.annotations.Parent;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Profile({"ByDb"})
class BookRepositoryByDb implements BookRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> getAllBooks() {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b", Book.class);
        return query.getResultList();
    }

    @Transactional
    @Override
    public void addBook(Book b) {
        em.persist(b);
    }

    @Override
    public Book getBookById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book getBookByTitle(String title) {
        TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
        query.setParameter("title", title);
        return query.getResultList().get(0);
    }

    @Transactional
    @Override
    public boolean removeBookByTitle(String title) {
        boolean isRemove = false;
        Book book = getBookByTitle(title);
        if (book != null){
            em.remove(book);
            isRemove = true;
        }
        return isRemove;
    }
}