package com.mjc.school.repository.impl;

import com.mjc.school.repository.BaseByTagRepository;
import com.mjc.school.repository.BaseRepository;
import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.News;
import com.mjc.school.repository.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;

@Repository
@Component("newsRepository")
public class NewsRepository implements BaseRepository <News, Long>, BaseByTagRepository <News, Long> {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    @Autowired
    public NewsRepository(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }
    @Override
    public List<News> readAll() {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<News> newsList = session.createQuery("from News", News.class).getResultList();
        transaction.commit();
        session.close();
        sessionFactory.close();
        return newsList;
    }

    @Override
    public Optional<News> readById(Long id) {
        return Optional.ofNullable(entityManager.find(News.class, id));
    }

    @Override
    public News create(News entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return  entity;
    }

    @Override
    public News update(News entity) {
        entityManager.getTransaction().begin();
        Optional<News> newsOptional= readById(entity.getId());
        if (newsOptional.isEmpty()) {
            return null;
        }
        News news = newsOptional.get();
        news.setContent(entity.getContent());
        news.setTitle(entity.getTitle());
        news.setAuthorId(entity.getAuthorId());
        news.setCreateDate(entity.getCreateDate());
        news.setLastUpdateTime(entity.getLastUpdateTime());
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            entityManager.getTransaction().begin();
            News news = readById(id).get();
            entityManager.remove(news);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean existById(Long id) {
        return readById(id)!=null;
    }

    @Override
    public List<News> byTagName(String name) {
        Tag tag =(Tag)entityManager.createNativeQuery("SELECT * FROM tag WHERE name LIKE :name", Tag.class)
                .setParameter("name", name).getSingleResult();

        return tag.getNews();
    }

    @Override
    public List<News> byTagId(Long id) {
        Tag tag =(Tag)entityManager.createNativeQuery("SELECT * FROM tag WHERE id=:id", Tag.class)
                .setParameter("id", id).getSingleResult();
        return tag.getNews();
    }

    @Override
    public List<News> byAuthorName(String name) {
        Author author =(Author) entityManager.createNativeQuery("select * from Author WHERE name LIKE :name", Author.class)
                .setParameter("name", name).getSingleResult();
        List<News> newsList =entityManager.createNativeQuery("SELECT * FROM news WHERE ID="+author.getId(), News.class)
                .setParameter("id", author.getId()).getResultList();
        return newsList;
    }

    @Override
    public News byTitle(String title) {
        News news = (News) entityManager.createNativeQuery("SELECT * FROM news WHERE title like '%"+title+"%'", News.class)
                .setParameter("title", title).getSingleResult();
        return news;
    }

    @Override
    public News byContent(String content) {
        News news = (News) entityManager.createNativeQuery("SELECT * FROM news WHERE content like '%"+content+"%'", News.class)
                .setParameter("content", content).getSingleResult();
        return news;
    }
}
