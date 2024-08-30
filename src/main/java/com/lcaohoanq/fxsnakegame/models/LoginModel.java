package com.lcaohoanq.fxsnakegame.models;

public record LoginModel(String username, String password) {
    public LoginModel() {
        this("", "");
    }

    public boolean isAdmin(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    public boolean isEmpty(String username, String password) {
        return username.isEmpty() || password.isEmpty();
    }
}
