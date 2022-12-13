package com.OverhealthApp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.OverhealthApp.R;

public class LembreAguaFragment extends Fragment {

    EditText inputPesoCalcularAgua;
    EditText  inputIdadeCalcularAgua;
    TextView resultadoCalculoAgua;
    Button btn_calcularAgua;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_lembre_agua, container, false);
        View LembreAguaFragment = inflater.inflate(R.layout.fragment_lembre_agua, container, false);

        inputPesoCalcularAgua = LembreAguaFragment.findViewById(R.id.inputPesoCalcularAgua);
        inputIdadeCalcularAgua = LembreAguaFragment.findViewById(R.id.inputIdadeCalcularAgua);
        resultadoCalculoAgua = LembreAguaFragment.findViewById(R.id.resultadoCalculoAgua);
        btn_calcularAgua = LembreAguaFragment.findViewById(R.id.btn_calcularAgua);

        btn_calcularAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View LembreAguaFragment){
                Log.d("ClicouCalularAgua!", "calculou agua");
                double peso = Double.parseDouble((inputPesoCalcularAgua.getText().toString()));
                double idade = Double.parseDouble(( inputIdadeCalcularAgua.getText().toString()));
                double resultado = peso * idade;

                if (idade <= 17){
                    resultado = peso * 40.0;
                    resultadoCalculoAgua.setText(resultado + " ml");
                } else if (idade <= 55){
                    resultado = peso * 35.0;
                    resultadoCalculoAgua.setText(resultado + " ml");
                } else if (idade <= 65){
                    resultado = peso * 30.0;
                    resultadoCalculoAgua.setText(resultado + " ml");
                } else {
                    resultado = peso * 25.0;
                    resultadoCalculoAgua.setText(resultado + " ml");
                }
            }
        });

        return LembreAguaFragment;
    }


}