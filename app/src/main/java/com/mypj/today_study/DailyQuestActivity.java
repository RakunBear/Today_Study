package com.mypj.today_study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.today_study.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyQuestActivity extends AppCompatActivity implements View.OnClickListener{

    /* Find ID */
    @BindView(R.id.dailyQuest_AddBtn)
    Button dailyQuest_AddBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_quest);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dailyQuest_AddBtn :

                break;
        }
    }
}