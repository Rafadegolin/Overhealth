package com.OverhealthApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.OverhealthApp.databinding.ActivityTelaLoginBinding;
import com.OverhealthApp.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class TelaLogin extends AppCompatActivity {

    EditText inputEmail;
    EditText inputSenha;
    Button bt_login;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        TextView bt = findViewById(R.id.textViewRegistro);
        // função de botão faça registro
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaLogin.this, TelaRegistro.class));
            }
        });

        auth = FirebaseAuth.getInstance();
        inicializarComponentes();

        // linkando variais aos IDs da activity
        inputEmail = findViewById(R.id.inputEmail);
        inputSenha = findViewById(R.id.inputPassword);
    }

    // funcao validar para fazer o login
    public void validarLogin(View view){
        String email =  inputEmail.getText().toString();
        String senha = inputSenha.getText().toString();

        if(!email.isEmpty()){
            if(!senha.isEmpty()){
            Usuario usuario = new Usuario();

            usuario.setEmail(email);
            usuario.setSenha(senha);

            logar(usuario);

            } else {
                Toast.makeText(this, "Preencha a senha", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Prencha o email", Toast.LENGTH_SHORT).show();
        }

    }

    // funcao primordial que testa o login
    private void logar(Usuario usuario) {
        auth.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirHome();
                } else {
                    String excecao="";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e){
                        excecao = "Usuário não está cadastrado";
                    } catch (FirebaseAuthInvalidCredentialsException e){
                        excecao = "Email ou senha incorreto";
                    } catch (Exception e){
                        excecao = "Erro ao logar o usuário "+e.getMessage();
                        e.printStackTrace();
                    }
                    Toast.makeText(TelaLogin.this, excecao, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // funçção que abre a tela de home
    private void abrirHome() {
        Intent i = new Intent(TelaLogin.this, MainActivity.class);
        startActivity(i);
    }

    private void inicializarComponentes(){
        inputEmail = findViewById(R.id.inputEmail);
        inputSenha = findViewById(R.id.inputSenha);
        bt_login = findViewById(R.id.bt_login);
    }
}