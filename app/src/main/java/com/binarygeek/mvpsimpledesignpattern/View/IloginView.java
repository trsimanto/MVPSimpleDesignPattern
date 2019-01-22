package com.binarygeek.mvpsimpledesignpattern.View;

public interface IloginView {
    void onLoginSuccess(String message);
    void onLoginError(String message);
    void onLoginWarning(String message);
}
