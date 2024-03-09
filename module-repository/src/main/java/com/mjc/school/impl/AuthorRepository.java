package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityTransaction;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
@Repository
@Component("authorRepository")
public class AuthorRepository implements BaseRepository<Author, Long> {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Autowired
    public AuthorRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }
    @Override
    public List<Author> readAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Author> cq = cb.createQuery(Author.class);
        Root<Author> authors = cq.from(Author.class);
        cq.select(authors);
        Query query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Optional<Author> readById(Long id) {
        Author author =(Author) entityManager.createNativeQuery("select * from Author where id=:id", Author.class)
                .setParameter("id", id).getSingleResult();

        return Optional.ofNullable(author);
    }

    @Override
    public Author create(Author entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return  entity;
    }

    @Override
    public Author update(Author entity) {
        entityManager.getTransaction().begin();
        Optional<Author> authorOptional= readById(entity.getId());
        if (authorOptional.isEmpty()) {
            return null;
        }
        Author author = authorOptional.get();
        author.setName(entity.getName());
        author.setLastUpdateTime(entity.getLastUpdateTime());
        author.setCreateDate(entity.getCreateDate());
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            entityManager.getTransaction().begin();
            Author author = readById(id).get();
            entityManager.remove(author);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id) != null;
    }
}
