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
        int isLoginSuccess=user.isValidData();

        if (isLoginSuccess==0)
            loginView.onLoginResult("Email is required");
        else if (isLoginSuccess==1)
            loginView.onLoginResult("Email is invalid");
        else if (isLoginSuccess==2)
            loginView.onLoginResult("Password invalid");
        else
            loginView.onLoginResult("Login Success");
    }
}
