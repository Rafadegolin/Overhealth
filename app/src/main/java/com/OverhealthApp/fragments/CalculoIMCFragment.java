package com.OverhealthApp.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.OverhealthApp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculoIMCFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculoIMCFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculoIMCFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculoIMCFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculoIMCFragment newInstance(String param1, String param2) {
        CalculoIMCFragment fragment = new CalculoIMCFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private TextView resultadoCalculo;
    private EditText inputPesoCalcular;
    private EditText inputAlturaCalcular;
    private Button btn_calcularIMC;

    Activity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_calculo_imc, container, false);
        View CalculoIMCFragment = inflater.inflate(R.layout.fragment_calculo_imc, container, false);

        resultadoCalculo = CalculoIMCFragment.findViewById(R.id.resultadoCalculo);
        inputPesoCalcular = CalculoIMCFragment.findViewById(R.id.inputPesoCalcular);
        inputAlturaCalcular = CalculoIMCFragment.findViewById(R.id.inputAlturaCalcular);
        btn_calcularIMC = CalculoIMCFragment.findViewById(R.id.btn_calcularIMC);

        btn_calcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View CalculoIMCFragment){
                Log.d("ClicouCalular!", "calculou");
                Double peso = Double.parseDouble(inputPesoCalcular.getText().toString());
                Double altura = Double.parseDouble(inputAlturaCalcular.getText().toString());
                Double resultado = peso / (altura * altura);

                if (inputPesoCalcular.getText().toString().equals("") || inputAlturaCalcular.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Precisa preencher os campos", Toast.LENGTH_SHORT).show();
                } else if (inputPesoCalcular.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Precisa digitar um peso", Toast.LENGTH_SHORT).show();
                } else if (inputAlturaCalcular.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "Precisa digitar uma altura", Toast.LENGTH_SHORT).show();
                } else if (resultado < 18.5){
                    resultadoCalculo.setText("Magreza");
                } else if (resultado <= 18.5 || resultado < 24.9){
                    resultadoCalculo.setText("Normal");
                }else if (resultado <= 25 || resultado < 29.9){
                    resultadoCalculo.setText("Sobrepeso obesidade grau I");
                }else if (resultado <= 30 || resultado < 39.9){
                    resultadoCalculo.setText("Obesidade grau II");
                }else if (resultado >= 40){
                    resultadoCalculo.setText("Obesidade grave grau III");
                }
            }
        });

        return CalculoIMCFragment;
    }
    
}