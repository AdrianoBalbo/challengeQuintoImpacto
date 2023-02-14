package com.example.challenge_backend.dtos;

import com.example.challenge_backend.models.Admin;

public class AdminDTO {
    private long id;
    private String email;

    public AdminDTO() {
    }

    public AdminDTO(Admin admin) {
        this.id = admin.getId();
        this.email = admin.getEmail();
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
