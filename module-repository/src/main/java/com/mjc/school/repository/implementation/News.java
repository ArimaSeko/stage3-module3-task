package com.mjc.school.repository.implementation;

import com.mjc.school.repository.BaseByTag;
import com.mjc.school.repository.model.Author;
import com.mjc.school.repository.model.Tag;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository("newsRepository")
public class News implements BaseByTag<com.mjc.school.repository.model.News, Long> {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<com.mjc.school.repository.model.News> readAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<com.mjc.school.repository.model.News> cq = cb.createQuery(com.mjc.school.repository.model.News.class);
        Root<com.mjc.school.repository.model.News> news = cq.from(com.mjc.school.repository.model.News.class);
        cq.select(news);
        Query query = entityManager.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Optional<com.mjc.school.repository.model.News> readById(Long id) {
        return Optional.ofNullable(entityManager.find(com.mjc.school.repository.model.News.class, id));
    }

    @Override
    public com.mjc.school.repository.model.News create(com.mjc.school.repository.model.News entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return  entity;
    }

    @Override
    public com.mjc.school.repository.model.News update(com.mjc.school.repository.model.News entity) {
        entityManager.getTransaction().begin();
        Optional<com.mjc.school.repository.model.News> newsOptional= readById(entity.getId());
        if (newsOptional.isEmpty()) {
            return null;
        }
        com.mjc.school.repository.model.News news = newsOptional.get();
        news.setContent(entity.getContent());
        news.setTitle(entity.getTitle());
        news.setAuthorId(entity.getAuthorId());
        news.setCreateDate(entity.getCreateDate());
        news.setLastUpdateTime(entity.getLastUpdateTime());
        entityManager.getTransaction().commit();
        return news;
    }

    @Override
    public boolean deleteById(Long id) {
        if (existById(id)) {
            entityManager.getTransaction().begin();
            com.mjc.school.repository.model.News news = readById(id).get();
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
    public List<com.mjc.school.repository.model.News> byTagName(String name) {
        Tag tag =(Tag)entityManager.createNativeQuery("SELECT * FROM tag WHERE name LIKE :name", Tag.class)
                .setParameter("name", name).getSingleResult();

        return tag.getNews();
    }

    @Override
    public List<com.mjc.school.repository.model.News> byTagId(Long id) {
        Tag tag =(Tag)entityManager.createNativeQuery("SELECT * FROM tag WHERE id=:id", Tag.class)
                .setParameter("id", id).getSingleResult();
        return tag.getNews();
    }

    @Override
    public List<com.mjc.school.repository.model.News> byAuthorName(String name) {
        Author author =(Author) entityManager.createNativeQuery("select * from Author WHERE name LIKE :name", Author.class)
                .setParameter("name", name).getSingleResult();
        List<com.mjc.school.repository.model.News> newsList =entityManager.createNativeQuery("SELECT * FROM news WHERE ID="+author.getId(), com.mjc.school.repository.model.News.class)
                .setParameter("id", author.getId()).getResultList();
        return newsList;
    }

    @Override
    public com.mjc.school.repository.model.News byTitle(String title) {
        com.mjc.school.repository.model.News news = (com.mjc.school.repository.model.News) entityManager.createNativeQuery("SELECT * FROM news WHERE title like '%"+title+"%'", com.mjc.school.repository.model.News.class)
                .setParameter("title", title).getSingleResult();
        return news;
    }

    @Override
    public com.mjc.school.repository.model.News byContent(String content) {
        com.mjc.school.repository.model.News news = (com.mjc.school.repository.model.News) entityManager.createNativeQuery("SELECT * FROM news WHERE content like '%"+content+"%'", com.mjc.school.repository.model.News.class)
                .setParameter("content", content).getSingleResult();
        return news;
    }
}
