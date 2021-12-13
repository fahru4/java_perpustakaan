package com.fahruzydow.perpustakaan.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
@DynamicUpdate
@SuppressWarnings("unchecked")

public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1477876135846170795L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "created_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;

    @Column(name = "updated_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedTime;

    @PrePersist
    protected void onCreate(){
        setCreatedTime(new Date());
    }

    @PrePersist
    protected void onUpdate(){
        setUpdatedTime(new Date());
    }
}
