package com.mypj.today_study;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.today_study.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TalkRoomActivity extends AppCompatActivity {

    Intent intent;
    Context context = this;

    @BindView(R.id.talk_HomeBtn)
    Button talk_HomeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_talk_room);
        ButterKnife.bind(this);

        talk_HomeBtn.setOnClickListener(ButtonOnClickListener);
    }

    /* Listenr */
    private View.OnClickListener ButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.talk_HomeBtn :
                    finish();
                    break;
            }
        }
    };
}