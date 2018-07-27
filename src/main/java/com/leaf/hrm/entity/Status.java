package com.leaf.hrm.entity;

import javax.persistence.*;

/**
 * @author : Rusiru on 27-Jul-18.
 */
@Entity
@Table(name = "status")
public class Status {

    private Long id;
    private String code;
    private String description;
    private StatusCategory statusCategory;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_category", nullable = false)
    public StatusCategory getStatusCategory() {
        return statusCategory;
    }

    public void setStatusCategory(StatusCategory statusCategory) {
        this.statusCategory = statusCategory;
    }
}
