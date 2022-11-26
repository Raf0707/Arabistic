package com.example.arabistic.ui.arabistic.active_words;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arabistic.R;
import com.example.arabistic.databinding.FragmentActiveWordsBinding;

import java.io.ObjectInputStream;
import java.lang.ref.WeakReference;


public class ActiveWordsFragment extends Fragment {
    public static WeakReference<ActiveWordsFragment> ctx = null;
    private FragmentActiveWordsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentActiveWordsBinding
                .inflate(inflater, container, false);
        ctx = new WeakReference<>(this);



        return  binding.getRoot();
    }
}