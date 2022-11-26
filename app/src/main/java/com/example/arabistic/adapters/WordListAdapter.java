package com.example.arabistic.adapters;

import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;
import android.content.Context;
import android.view.ViewGroup;
import android.view.View;
import android.widget.TextView;
import com.example.arabistic.R;
import com.example.arabistic.ui.arabistic.active_words.ActiveWordsFragment;

import androidx.annotation.NonNull;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {
    public static final ActiveWordsFragment WORDS_FRAGMENT = ActiveWordsFragment.ctx.get();

    @NonNull
    @Override
    public WordListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView;
        ViewHolder(View view){
            super(view);
            nameView = view.findViewById(R.id.word_format);
        }
    }
}
