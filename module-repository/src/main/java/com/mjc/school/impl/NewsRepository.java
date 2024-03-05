package com.mjc.school.impl;

import com.mjc.school.BaseRepository;
import com.mjc.school.model.Author;
import com.mjc.school.model.News;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
@Component("newsRepository")
public class NewsRepository implements BaseRepository <News, Long>{

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
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<News> cq = cb.createQuery(News.class);
        Root<News> newsRoot = cq.from(News.class);
        cq.select(newsRoot).where(cb.equal(newsRoot.get("id"), id));
        News newsResult = entityManager.createQuery(cq).getSingleResult();
        return Optional.ofNullable(newsResult);
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
}
