package com.OverhealthApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

import com.OverhealthApp.R
import com.OverhealthApp.databinding.FragmentHomeBinding

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.layoutTreino.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_treinos) }
        binding.layoutConfig.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_configuracoes) }
        binding.layoutAlimentacao.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_dietaGeralFragment) }
        binding.layoutPerfil.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_perfil) }
        binding.layoutAgua.setOnClickListener{ findNavController(it).navigate(R.id.action_home_to_lembreAguaFragment) }
        binding.layoutIMC.setOnClickListener{ findNavController(it).navigate(R.id.action_home_to_calculoIMCFragment) }
        binding.layoutAlimentacao.setOnClickListener{ findNavController(it).navigate(R.id.action_home_to_alimentacaoFragment) }
        return binding.root
    }
}