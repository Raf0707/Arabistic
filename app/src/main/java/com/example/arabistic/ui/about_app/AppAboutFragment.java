package com.example.arabistic.ui.about_app;

import static com.example.arabistic.util.UtilFragment.changeFragment;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.arabistic.BuildConfig;
import com.example.arabistic.R;

import com.example.arabistic.databinding.*;
import com.example.arabistic.developer_params.DeveloperParamsFragment;
import com.example.arabistic.developer_params.PasswordDevFragment;
import com.example.arabistic.util.CustomTabUtil;

import com.google.android.material.snackbar.Snackbar;


public class AppAboutFragment extends Fragment {

    private FragmentAppAboutBinding binding;
    private int clickCount = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void addOnClick(View view, String text, ClipData clipData) {
        ClipboardManager clipboardManager = (ClipboardManager)
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE);

        clipboardManager.setPrimaryClip(clipData);
        Snackbar.make(requireView(), text, Snackbar.LENGTH_LONG).show();
    }

    @SuppressLint("IntentReset")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAppAboutBinding
                .inflate(inflater, container, false);

        binding.appVersionBtn.setText(new StringBuilder()
                .append(getString(R.string.version))
                .append(getString(R.string.str_dv))
                .append(BuildConfig.VERSION_NAME)
                .append(getString(R.string.val_str_sk_right))
                .append(BuildConfig.VERSION_CODE)
                .append(getString(R.string.val_str_sk_left))
                .toString());

        binding.appVersionBtn.setOnLongClickListener(view -> {
            addOnClick(view, getString(R.string.version_copied),
                    ClipData.newPlainText(
                            getString(R.string.getContext),
                            new StringBuilder()
                                    .append(getString(R.string.app_name))
                                    .append(getString(R.string.version))
                                    .append(getString(R.string.str_dv))
                                    .append(BuildConfig.VERSION_NAME)
                                    .append(getString(R.string.val_str_sk_right))
                                    .append(BuildConfig.VERSION_CODE)
                                    .append(getString(R.string.val_str_sk_left))
                                    .toString()));
            return true;
        });

        binding.sourceCodeBtn.setOnLongClickListener(view -> {
            addOnClick(view, getString(R.string.link_to_source_copied),
                    ClipData.newPlainText(getString(R.string.getContext),
                            getString(R.string.source_code_url)));
            return true;
        });

        binding.rafailBtn.setOnLongClickListener(view -> {
            addOnClick(view, getString(R.string.raf_git_copylink),
                    ClipData.newPlainText(getString(R.string.getContext),
                            getString(R.string.rafail_url)));
            return true;
        });



        binding.mailRafBtn.setOnLongClickListener(view -> {
            addOnClick(view, getString(R.string.my_email_copylink),
                    ClipData.newPlainText(getString(R.string.getContext),
                            getString(R.string.mail_raf)));
            return true;
        });

        binding.vkGroupBtn.setOnLongClickListener(view -> {
            addOnClick(view, getString(R.string.vk_tabiin_coyplink),
                    ClipData.newPlainText(getString(R.string.getContext),
                            getString(R.string.tabiin_rtx)));
            return true;
        });

        binding.appVersionBtn.setOnClickListener(view -> {
            clickCount += 1;
            if (clickCount == 8) {
                changeFragment(requireActivity(),
                        new PasswordDevFragment(), //DeveloperParamsFragment(),
                        R.id.kontainerFragment, savedInstanceState);

            }
        });

        binding.sourceCodeBtn.setOnClickListener(v -> new CustomTabUtil()
                .openCustomTab(getActivity(),
                        getString(R.string.source_code_url),
                        R.color.purple_300));

        binding.rafailBtn.setOnClickListener(v -> new CustomTabUtil()
                .openCustomTab(getActivity(),
                        getString(R.string.rafail_url),
                        R.color.purple_300));

        binding.mailRafBtn.setOnClickListener(v -> {
            final Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse(getString(R.string.mailto)))
                    .setType(getString(R.string.text_plain))
                    .putExtra(android.content.Intent.EXTRA_EMAIL,
                            new String[]{getString(R.string.mail_raf)})
                    .putExtra(Intent.EXTRA_SUBJECT, R.string.app_name)
                    .putExtra(Intent.EXTRA_TEXT,
                            new StringBuilder()
                                    .append(getString(R.string.app_name))
                                    .append(getString(R.string.semicolon))
                                    .append(getString(R.string.version))
                                    .append(getString(R.string.str_dv))
                                    .append(BuildConfig.VERSION_NAME)
                                    .append(getString(R.string.val_str_sk_right))
                                    .append(BuildConfig.VERSION_CODE)
                                    .append(getString(R.string.val_str_sk_left))
                                    .toString());

            emailIntent.setType(getString(R.string.text_plain));
            // setType("message/rfc822")

            try {
                startActivity(Intent.createChooser(emailIntent,
                        getString(R.string.email_client)));

            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getActivity(),
                        R.string.no_email_client, Toast.LENGTH_SHORT).show();
            }
        });

        binding.vkGroupBtn.setOnClickListener(v -> new CustomTabUtil()
                .openCustomTab(getActivity(),
                        getString(R.string.tabiin_rtx),
                        R.color.purple_300));

        binding.otherAppsBtn.setOnClickListener(view -> {
            final String appPackageName = requireContext().getPackageName();

            try {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://search?q=pub:JVMFrog")));
            } catch (android.content.ActivityNotFoundException anfe) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.GOOGLE_PLAY))));
            }

        });

        return binding.getRoot();

    }
}