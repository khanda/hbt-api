package com.hbt.gd.dto;

public class UserRoleDto {
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
        return id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
