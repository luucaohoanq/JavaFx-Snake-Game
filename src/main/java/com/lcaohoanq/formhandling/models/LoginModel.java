package com.lcaohoanq.formhandling.models;

import com.lcaohoanq.formhandling.exceptions.DataException;
import com.lcaohoanq.formhandling.modules.user.UserDAO;
import com.lcaohoanq.formhandling.modules.user.UserEntity;
import com.lcaohoanq.formhandling.utils.PBKDF2;

public record LoginModel(String username, String password) {
    public LoginModel() {
        this("", "");
    }

    public boolean isAdmin(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    public boolean isMatching(String username, String password) {
        UserEntity db;
        UserDAO executeQuery = UserDAO.getInstance();
        try {
            db = executeQuery.selectEmailAndPasswordByEmail(username);
            if (db != null) {
                return new PBKDF2().authenticate(password.toCharArray(), db.getPassword());
            } else {
                throw new DataException("Error authenticate, password do not match");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean isEmpty(String username, String password) {
        return username.isEmpty() || password.isEmpty();
    }
}
