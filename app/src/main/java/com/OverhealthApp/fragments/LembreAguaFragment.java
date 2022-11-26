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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LembreAguaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LembreAguaFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LembreAguaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LembreAguaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LembreAguaFragment newInstance(String param1, String param2) {
        LembreAguaFragment fragment = new LembreAguaFragment();
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

    private EditText inputPesoCalcularAgua;
    private EditText  inputIdadeCalcularAgua;
    private TextView resultadoCalculoAgua;
    private Button btn_calcularAgua;

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
            public void onClick(View v){
                Log.d("ClicouCalularAgua!", "calculou agua");

            }
        });

        return LembreAguaFragment;
    }

    public void CalcularAgua(View view){
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
}