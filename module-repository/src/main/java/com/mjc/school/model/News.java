package com.mjc.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="news")
@NoArgsConstructor
@AllArgsConstructor
public class News  implements BaseEntity <Long>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;
    @Column(name="title", nullable = false)
    private String title;
    @Column(name="content", nullable = false)
    private String content;
    @Column(name="create_date", nullable = false)
    private LocalDateTime createDate;
    @LastModifiedDate
    @Column(name="last_update_time", nullable = false)
    private LocalDateTime lastUpdateTime;
    @Column(name="author_id", nullable = true)
    private Long authorId;

//    public News(String title, String content, Long authorId) {
//        this.lastUpdateTime = LocalDateTime.now();
//        this.createDate=LocalDateTime.now();
//        this.title = title;
//        this.content = content;
//        this.authorId = authorId;
//    }
    public LocalDateTime getCreateDate() {
        return createDate;
    }
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }
    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long author) {
        this.authorId = author;
    }
    @Override
    public Long getId(
    ) {
        return this.id;
    }

    @Override
    public void setId(Long id) {
    this.id=id;
    }
}
