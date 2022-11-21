package com.OverhealthApp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;


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
                    Snackbar popup = Snackbar.make(ok, "Preencha todos os campos!", Snackbar.LENGTH_SHORT);
                    popup.show();
                } else {
                    auth.createUserWithEmailAndPassword(email, senha).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Snackbar popup = Snackbar.make(ok, "Sucesso a cadastrar usuário", Snackbar.LENGTH_SHORT);
                                popup.show();
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

