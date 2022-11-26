package com.example.arabistic;

import static com.example.arabistic.util.UtilFragment.changeFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.arabistic.databinding.ActivityMainBinding;
import com.example.arabistic.quran.QuranFragment;
import com.example.arabistic.ui.ArabisticMainFragment;
import com.example.arabistic.ui.about_app.AppAboutFragment;
import com.example.arabistic.ui.grammar.GrammarArabicFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.arabic_words:
                    changeFragment(this, new ArabisticMainFragment(),
                            R.id.kontainerFragment, savedInstanceState);
                    break;

                case R.id.quran:
                    changeFragment(this, new QuranFragment(),
                            R.id.kontainerFragment, savedInstanceState);
                    break;

                case R.id.grammar:
                    changeFragment(this, new GrammarArabicFragment(),
                            R.id.kontainerFragment, savedInstanceState);
                    break;

                case R.id.about_app:
                    changeFragment(this, new AppAboutFragment(),
                            R.id.kontainerFragment, savedInstanceState);
                    break;
            }

            return true;
        });

    }
}