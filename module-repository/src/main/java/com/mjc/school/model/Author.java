package com.mjc.school.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name="author")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author implements BaseEntity<Long>{
    @Id
    @Column(name="id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="create_date")
    private Date createDate;
    @Column(name="last_update_time")
    private Date lastUpdateTime;
}
