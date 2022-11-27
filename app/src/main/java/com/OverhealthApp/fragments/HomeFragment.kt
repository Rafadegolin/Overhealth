package com.OverhealthApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController

import com.OverhealthApp.R
import com.OverhealthApp.databinding.FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.layoutTreino.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_treinos) }
        binding.layoutConfig.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_configuracoes) }
        binding.layoutAlimentacao.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_dietaGeralFragment) }
        binding.layoutPerfil.setOnClickListener { findNavController(it).navigate(R.id.action_home_to_perfil) }
        return binding.root
    }
}