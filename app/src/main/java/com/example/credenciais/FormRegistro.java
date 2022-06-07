package com.example.credenciais;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormRegistro extends AppCompatActivity {

    EditText nome, senha, disciplina, turno, celular, email;
    RadioGroup sexo;
    Button registrar, cancelar;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_registro);

        nome = findViewById(R.id.edit_nome);
        senha = findViewById(R.id.editSenha);
        disciplina = findViewById(R.id.editDisciplina);
        turno = findViewById(R.id.editTurno);
        celular = findViewById(R.id.editTelefone);
        email = findViewById(R.id.editEmail);
        sexo = findViewById(R.id.sexo);
        registrar = findViewById(R.id.bt_registrarForm);
        cancelar = findViewById(R.id.bt_cancelar);

        preferences = getSharedPreferences("Userinfo",MODE_PRIVATE);

        getSupportActionBar().hide();

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeValue = nome.getText().toString();
                String senhaValue = senha.getText().toString();
                String disciplinaValue = disciplina.getText().toString();
                String turnoValue = turno.getText().toString();
                String celularValue = celular.getText().toString();
                String emailValue = email.getText().toString();
                RadioButton checkedBtn = findViewById(sexo.getCheckedRadioButtonId());
                String sexoValue = checkedBtn.getText().toString();

                if(senhaValue.length() >= 6 && emailValue.length() > 1){

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("nome", nomeValue);
                    editor.putString("senha", senhaValue);
                    editor.putString("disciplina", disciplinaValue);
                    editor.putString("turno", turnoValue);
                    editor.putString("celular", celularValue);
                    editor.putString("email", emailValue);
                    editor.putString("sexo", sexoValue);
                    editor.apply();

                    Toast.makeText(FormRegistro.this, "Usuário Registrado com Sucesso!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FormRegistro.this, FormLogin.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(FormRegistro.this, "Por Favor! Preencha os dados!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        cancelar.setOnClickListener((v) -> {
            emptyField();
            Intent intent = new Intent(FormRegistro.this, FormLogin.class);
            startActivity(intent);
        });
    }
    public void emptyField(){
        nome.setText("");
        senha.setText("");
        disciplina.setText("");
        turno.setText("");
        celular.setText("");
        email.setText("");
    }


    }
