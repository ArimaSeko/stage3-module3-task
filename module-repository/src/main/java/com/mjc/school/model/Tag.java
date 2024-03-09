package com.mjc.school.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tag")
@AllArgsConstructor
@NoArgsConstructor
public class Tag implements BaseEntity <Long>{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "tags")
    private List<News> news;
    public Long getId() {
        return id;
    }

    public List<News> getNews() {
        return news;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
