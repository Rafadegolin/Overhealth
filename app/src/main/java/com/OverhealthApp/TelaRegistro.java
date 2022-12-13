package com.OverhealthApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.OverhealthApp.databinding.ActivityTelaRegistroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;


public class TelaRegistro extends AppCompatActivity {

    private ActivityTelaRegistroBinding binding;

    private FirebaseAuth auth;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);

        //criando as bindings para cadastro
        binding = ActivityTelaRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //cadastrando
        auth = FirebaseAuth.getInstance();


        //checando se esta tudo preenchido
        binding.btRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View ok) {
                String usuario = binding.inputUsuario.getText().toString();
                String email = binding.inputEmail.getText().toString();
                String senha = binding.inputSenha.getText().toString();
                String confirmaSenha = binding.inputConfirmaSenha.getText().toString();

                if (email.isEmpty() || senha.isEmpty() || confirmaSenha.isEmpty() || usuario.isEmpty()) {
                    Toast.makeText(TelaRegistro.this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!senha.equals(confirmaSenha)) {
                        Toast.makeText(TelaRegistro.this, senha + confirmaSenha, Toast.LENGTH_SHORT).show();
                    } else {
                        auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(TelaRegistro.this, "Sucesso ao cadastrar usuário", Toast.LENGTH_SHORT).show();
                                    binding.inputUsuario.setText(" ");
                                    binding.inputEmail.setText(" ");
                                    binding.inputSenha.setText(" ");
                                    binding.inputConfirmaSenha.setText(" ");
                                } else {
                                    String exception = " ";

                                    try {
                                        throw task.getException();
                                    } catch (FirebaseAuthWeakPasswordException e) {
                                        exception = "Digite uma senha com no minimo 6 digitos";
                                    } catch (FirebaseAuthInvalidCredentialsException e) {
                                        exception = "Digite um e-mail valido";
                                    } catch (FirebaseAuthUserCollisionException e) {
                                        exception = "Esse e-mail já possui conta cadastrada";
                                    } catch (Exception e) {
                                        exception = "Erro a cadastrar o usúario" + e.getMessage();
                                        e.printStackTrace();
                                    }
                                    Toast.makeText(TelaRegistro.this, exception, Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
                    }
                }
                    }
                });
            }

            public void jaPossuiConta(View view){
                Intent i = new Intent(TelaRegistro.this, TelaLogin.class);
                startActivity(i);
            }
}

