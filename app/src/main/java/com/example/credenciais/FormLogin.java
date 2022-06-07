package com.example.credenciais;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FormLogin extends AppCompatActivity {

    SharedPreferences preferences;
    Button registrar , login;
    EditText email, senha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_login);

        email = findViewById(R.id.edit_localizacao);
        senha = findViewById(R.id.edit_senhaLogin);
        login = findViewById(R.id.bt_login);
        registrar = findViewById(R.id.bt_cadastrar);

        preferences = getSharedPreferences("Userinfo", MODE_PRIVATE);

        getSupportActionBar().hide();
        IniciarComponentes();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = email.getText().toString();
                String passwordValue = senha.getText().toString();

                String registrarEmail = preferences.getString("email","");
                email.setText(registrarEmail);
                String registrarSenha = preferences.getString("senha","");
                senha.setText(registrarSenha);
                if(usernameValue.equals(registrarEmail) && passwordValue.equals(registrarSenha)){
                    Intent intent = new Intent(FormLogin.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(FormLogin.this, FormRegistro.class);
                startActivity(intent);
            }
        });
    }

    private void IniciarComponentes(){
        registrar = findViewById(R.id.bt_cadastrar);
    }
}