package com.OverhealthApp.fragments;

import static androidx.core.content.PackageManagerCompat.LOG_TAG;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.OverhealthApp.R;

import android.util.Log;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // Definindo meus botões (containers) da home
    private LinearLayout PerfilHomeBtn;
    private LinearLayout AlimentacaoHomeBtn;
    private LinearLayout CalcularIMCHomeBtn;
    private LinearLayout IngestaoAguaHomeBtn;
    private LinearLayout TreinoHomeBtn;
    private LinearLayout ConfigHomeBtn;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false);
        View HomeFragment = inflater.inflate(R.layout.fragment_home, container, false);

        // Declarando os botões aos seus respectivos layouts
        PerfilHomeBtn = HomeFragment.findViewById(R.id.layoutPerfil);
        AlimentacaoHomeBtn = HomeFragment.findViewById(R.id.layoutAlimentacao);
        CalcularIMCHomeBtn = HomeFragment.findViewById(R.id.layoutIMC);
        IngestaoAguaHomeBtn = HomeFragment.findViewById(R.id.layoutAgua);
        TreinoHomeBtn = HomeFragment.findViewById(R.id.layoutTreino);
        ConfigHomeBtn = HomeFragment.findViewById(R.id.layoutConfig);

        // Função do botao de PERFIL
        PerfilHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Clicou perfil!", "perfil");
                Navigation.findNavController(view).navigate(R.id.action_home_to_perfil);
            }
        });

        // Função do botao de ALIMENTACAO
        AlimentacaoHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Clicou Alimentacao!", "Alimentação");
                Navigation.findNavController(view).navigate(R.id.action_home_to_alimentacao);
            }
        });


        // Função do botao de CALCULARIMC
        CalcularIMCHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Clicou IMC!", "IMC");
                Navigation.findNavController(view).navigate(R.id.action_home_to_calculoIMCFragment);
            }
        });

        // Função do botao de INGESTAOAGUA
        IngestaoAguaHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Clicou Agua!", "Agua");
                Navigation.findNavController(view).navigate(R.id.action_home_to_lembreAguaFragment);
            }
        });

        // Função do botao de TREINO
        TreinoHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Clicou treino!", "Treino");
                Navigation.findNavController(view).navigate(R.id.action_home_to_treinos);
            }
        });

        // Função do botao de CONFIGURACOES
        ConfigHomeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Log.d("Clicou config!", "Configurações");
                Navigation.findNavController(view).navigate(R.id.action_home_to_configuracoes);
            }
        });


        return HomeFragment;
    }
}