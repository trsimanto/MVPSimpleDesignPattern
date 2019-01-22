package com.binarygeek.mvpsimpledesignpattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.binarygeek.mvpsimpledesignpattern.Presenter.ILoginPresenter;
import com.binarygeek.mvpsimpledesignpattern.Presenter.LoginPresenter;
import com.binarygeek.mvpsimpledesignpattern.View.IloginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements IloginView {

    EditText edt_email, edt_password;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//init view
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        //init
        loginPresenter = new LoginPresenter(this);

        //event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT, true).show();
    }

    @Override
    public void onLoginWarning(String message) {
        Toasty.warning(this, message, Toast.LENGTH_SHORT, true).show();
    }
}
