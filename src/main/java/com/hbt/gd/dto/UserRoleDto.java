package com.hbt.gd.dto;

import java.io.Serializable;

public class UserRoleDto implements Serializable {
    private Long id;
    private String name;
    private String description;

    public UserRoleDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public UserRoleDto() {
    }

    public Long getId() {
        if(null == id){
            return 0l;
        }
        return id;
    }

    public void setId(Long id) {
        if(null == id){
            this.id = 0l;
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
