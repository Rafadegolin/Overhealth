package com.OverhealthApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.OverhealthApp.databinding.ActivityTelaRegistroBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;


public class TelaRegistro extends AppCompatActivity {

    private ActivityTelaRegistroBinding binding;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_registro);

        //botao ja possui conta
        TextView bt = findViewById(R.id.jaTemConta);
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(TelaRegistro.this, TelaLogin.class));
            }
        });

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
                    Snackbar popup = Snackbar.make(ok, "Preencha todos os campos!", Snackbar.LENGTH_SHORT);
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
                        }
                            else {
                                task.getException();

                            }
                                }
                            });
                        }

                    }
                });
            }
}

