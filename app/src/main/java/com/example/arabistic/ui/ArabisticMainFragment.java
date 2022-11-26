package com.example.arabistic.ui;

import static com.example.arabistic.util.UtilFragment.changeFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.arabistic.R;
import com.example.arabistic.databinding.FragmentArabisticMainBinding;
import com.example.arabistic.ui.arabistic.active_words.ActiveWordsFragment;


public class ArabisticMainFragment extends Fragment {
    private FragmentArabisticMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentArabisticMainBinding
                .inflate(inflater, container, false);

        binding.materialCardACtiveWords.setOnClickListener(view -> {
            changeFragment(requireActivity(), new ActiveWordsFragment(),
                    R.id.kontainerFragment, savedInstanceState);
        });

        return binding.getRoot();
    }
}