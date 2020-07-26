package com.mypj.today_study.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.today_study.R;

public class FragmentVisibleGone extends Fragment {

    private ViewGroup viewGroup;

    public FragmentVisibleGone() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_visiblity_gone, container, false);

        return viewGroup;
    }
}
