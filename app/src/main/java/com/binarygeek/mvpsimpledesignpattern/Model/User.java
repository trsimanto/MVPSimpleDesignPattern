package com.binarygeek.mvpsimpledesignpattern.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        if (TextUtils.isEmpty(getEmail()))
            return 0;
        if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        if (getPassword().length() < 6)
            return 2;
        return -1;
    }
}
