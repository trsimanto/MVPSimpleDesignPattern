package com.binarygeek.mvpsimpledesignpattern.Presenter;

import com.binarygeek.mvpsimpledesignpattern.Model.User;
import com.binarygeek.mvpsimpledesignpattern.View.IloginView;

public class LoginPresenter implements ILoginPresenter {
IloginView loginView;

    public LoginPresenter(IloginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user=new User(email,password);
        boolean isLoginSuccess=user.isValidData();

        if (isLoginSuccess)
            loginView.onLoginResult("Login Success");
        else
            loginView.onLoginResult("Login error");
    }
}
