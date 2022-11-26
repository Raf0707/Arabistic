package com.example.arabistic.developer_params;

import static com.example.arabistic.util.UtilFragment.changeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.arabistic.R;
import com.example.arabistic.R;
import com.example.arabistic.databinding.FragmentDeveloperParamsBinding;
import com.example.arabistic.ui.about_app.AppAboutFragment;
import com.google.android.material.snackbar.Snackbar;

import java.util.concurrent.ThreadLocalRandom;


public class DeveloperParamsFragment extends Fragment {
    private FragmentDeveloperParamsBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentDeveloperParamsBinding
                .inflate(inflater,
                        container, false);

        binding.sincNow.setOnClickListener(view -> {
            Snackbar.make(requireView(),
                    new StringBuilder()
                            .append(getString(R.string.Gradle_build))
                            .append(" ")
                            .append(ThreadLocalRandom
                                    .current()
                                    .nextInt(12, 561))

                            .append(getString(R.string.Milly_sec))
                            .toString(),

                    Snackbar.LENGTH_LONG).show();
        });

        binding.restartNow.setOnClickListener(view ->
                Snackbar.make(requireView(),
                R.string.Apply_changes,
                        Snackbar.LENGTH_LONG).show());

        binding.debugNow.setOnClickListener(view ->
                Snackbar.make(requireView(),
                new StringBuilder()
                        .append(getString(R.string.Debug_finish))
                        .append(" ")
                        .append(ThreadLocalRandom
                                .current()
                                .nextInt(132, 834))

                        .append(getString(R.string.Milly_sec))
                        .toString(),

                Snackbar.LENGTH_LONG).show());

        binding.exitNowToAppABoutFragment.setOnClickListener(view -> {

            changeFragment(requireActivity(),
                    new AppAboutFragment(),
                    R.id.kontainerFragment, savedInstanceState);

        });

        return binding.getRoot();
    }
}