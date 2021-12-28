package com.rdc.paises;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rdc.paises.databinding.FragmentJuegoBanderasBinding;

public class JuegoBanderasFragment extends Fragment {

    private FragmentJuegoBanderasBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentJuegoBanderasBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        return view;
    }
}