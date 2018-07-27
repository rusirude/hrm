package com.leaf.hrm.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Entity
@Table(name = "status_category")
public class StatusCategory {

    private Long id;
    private String code;
    private String description;
    private Set<Status> statuses = new HashSet<>(0);


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "code", nullable = false, length = 15 ,unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Column(name = "description", nullable = false, length = 150)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "statusCategory")
    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }
}