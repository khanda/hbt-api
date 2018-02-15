package com.hbt.gd.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "khoi")
public class Khoi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "leader_id")
    private Long leaderId;
    @Column(name = "status")
    private boolean status;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "leader_id", insertable = false, updatable = false)
    @JsonIgnore
    private Employee leader;

    public Khoi() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        if (leaderId == null)
            this.leaderId = 0l;
        this.leaderId = leaderId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }
}
