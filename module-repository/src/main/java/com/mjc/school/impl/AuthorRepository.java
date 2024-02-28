package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.model.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Component("authorRepository")
public class AuthorRepository implements BaseRepository<Author, Long> {
    @Override
    public List<Author> readAll() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Author> authors = session.createQuery("from Author ", Author.class).getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return authors;
    }

    @Override
    public Optional<Author> readById(Long id) {
        return Optional.empty();
    }

    @Override
    public Author create(Author entity) {
        return null;
    }

    @Override
    public Author update(Author entity) {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return false;
    }
}
