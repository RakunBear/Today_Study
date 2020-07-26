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

public class LoginActivity extends AppCompatActivity {

    Context context = this;

    /* ID */
    @BindView(R.id.login_Basic)
    Button login_Basic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        login_Basic.setOnClickListener(LoginOnClickListener);
    }

    /* OnClickListener */
    private View.OnClickListener LoginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent;

            switch (v.getId()) {
                case R.id.login_Basic :
                    intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                    finish();
                    break;
            }
        }
    };

    /* End OnClickListener */
}