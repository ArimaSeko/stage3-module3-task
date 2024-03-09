package com.mjc.school.repository.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "news_tag",
            joinColumns = @JoinColumn(name = "news_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
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
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
    this.id=id;
    }
}
