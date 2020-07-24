package com.example.today_study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.today_study.MainLog.MainLogAdapter;
import com.example.today_study.MainLog.MainLogItem;

import java.util.ArrayList;
import java.util.logging.Level;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    LayoutInflater layoutInflater;
    Intent intent;
    // BGM
    MediaPlayer mediaPlayer;
    // RankTable

    // MainLog System
    MainLogAdapter mainLogAdapter;

    /* ID */
    // Bottom&Side Bar
    @BindView(R.id.mainView)
    ViewGroup mainView;
    //
    @BindView(R.id.bottomBar)
    ViewGroup bottomBar;
    @BindView(R.id.bottomBar_Menu)
    ViewGroup bottomBar_Menu;
    @BindView(R.id.bottomBar_daily)
    ViewGroup bottomBar_daily;
    @BindView(R.id.bottomBar_special)
    ViewGroup bottomBar_special;
    @BindView(R.id.dailyBtn)
    Button dailyBtn;
    @BindView(R.id.specialBtn)
    Button specialBtn;
    @BindView(R.id.talkRoomBtn)
    Button talkRoomBtn;
    //
    @BindView(R.id.sideBar_MenuOut)
    Button sideBar_MenuOut;
    @BindView(R.id.sideBar_MenuIn)
    Button sideBar_MenuIn;
    @BindView(R.id.sideBar)
    ViewGroup sideBar;
    // Sound Bar
    @BindView(R.id.soundBar)
    SeekBar soundBar;
    // RankTable
    @BindView(R.id.rankTable)
    TableLayout rankTable;
    // Level System
    @BindView(R.id.level_Text)
    TextView level_Text;
    @BindView(R.id.level_Progress)
    ProgressBar level_Progress;
    // MainLog System
    @BindView(R.id.mainLogList)
    ListView mainLogList;

    /* Basic Variable */
    // Level System
    private int require_Exp = 50;
    private int currentLevel = 1;
    // Bottom&Side Bar
    private boolean isBottomBarShow = false;
    private boolean isSideBarShow = false;
    // MainLog System
    private ArrayList<MainLogItem> mainLogDataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // Set MediaPlayer
        mediaPlayer = MediaPlayer.create(context, R.raw.littleidea);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        // Set OnClikListener
        dailyBtn.setOnClickListener(ButtonOnClickListener);
        specialBtn.setOnClickListener(ButtonOnClickListener);
        talkRoomBtn.setOnClickListener(ButtonOnClickListener);
        sideBar_MenuOut.setOnClickListener(ButtonOnClickListener);
        sideBar_MenuIn.setOnClickListener(ButtonOnClickListener);
        soundBar.setOnSeekBarChangeListener(OnSeekBarChangeListener);

        // Get LayoutInflater
        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Adapter
        FixMainLogData();
        mainLogAdapter = new MainLogAdapter(context, mainLogDataList);

        // Set ListView
        mainLogList.setAdapter(mainLogAdapter);

        // RankTable
        AddTableRow(rankTable);
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();

        // mediaPlayer
        mediaPlayer.pause();
    }

    /* Listener */
    private View.OnClickListener ButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                // BottomBar
                case R.id.dailyBtn :
                    if (isBottomBarShow) {
                        if (bottomBar_special.getVisibility() == View.VISIBLE) {
                            bottomBar_special.setVisibility(View.GONE);
                            bottomBar_daily.setVisibility(View.VISIBLE);
                        } else {
                            HideBottomBar(bottomBar_daily);
                            isBottomBarShow = false;
                        }
                    } else {
                        ShowBottomBar(bottomBar_daily);
                        isBottomBarShow = true;
                    }
                    break;
                case R.id.specialBtn :
                    if (isBottomBarShow) {
                        if (bottomBar_daily.getVisibility() == View.VISIBLE) {
                            bottomBar_daily.setVisibility(View.GONE);
                            bottomBar_special.setVisibility(View.VISIBLE);
                        } else {
                            HideBottomBar(bottomBar_special);
                            isBottomBarShow = false;
                        }
                    } else {
                        ShowBottomBar(bottomBar_special);
                        isBottomBarShow = true;
                    }
                    break;
                case R.id.talkRoomBtn :
                    intent = new Intent(context, TalkRoomActivity.class);
                    startActivity(intent);
                    break;
                // SideBar
                case R.id.sideBar_MenuOut :
                case R.id.sideBar_MenuIn :
                    if (isSideBarShow) {
                        isSideBarShow = false;
                        HideSideBar();
                    } else {
                        isSideBarShow = true;
                        ShowSideBar();
                    }
                    break;
                // SoundBar

            }
        }
    };

    private SeekBar.OnSeekBarChangeListener OnSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            float vol = (float)progress/10.0f;
            mediaPlayer.setVolume(vol, vol);
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    /* End Listener */

    /* Rank Table */
    private void AddTableRow(TableLayout _tableLayout)
    {
        View tempRaw = layoutInflater.inflate(R.layout.layout_tablerow_ranking, null, false);

        _tableLayout.addView(tempRaw);
    }

    /* End Rank Table */

    /* BottomBar */
    private void ShowBottomBar(ViewGroup _bottomBar) {
        Animation slide = AnimationUtils.loadAnimation(context, R.anim.bottombar_show);

        bottomBar_Menu.startAnimation(slide);
        _bottomBar.startAnimation(slide);
        _bottomBar.setVisibility(View.VISIBLE);

    }

    private void HideBottomBar(ViewGroup _bottomBar) {
        Animation slide = AnimationUtils.loadAnimation(context, R.anim.bottombar_hidden);

        bottomBar_Menu.startAnimation(slide);
        _bottomBar.setVisibility(View.GONE);
    }

    /* End Bottom Bar */

    /* SideBar */
    private void ShowSideBar() {
        Animation slide = AnimationUtils.loadAnimation(context, R.anim.sidebar_show);

        sideBar_MenuOut.startAnimation(slide);
        sideBar.startAnimation(slide);
        sideBar.setVisibility(View.VISIBLE);
        sideBar.setEnabled(true);
        mainView.setEnabled(false);
        bottomBar.setEnabled(false);
    }

    private void HideSideBar() {
        Animation slide = AnimationUtils.loadAnimation(context, R.anim.sidebar_hidden);

        sideBar_MenuOut.startAnimation(slide);
        sideBar.startAnimation(slide);
        sideBar.setVisibility(View.GONE);
        sideBar.setEnabled(true);
        mainView.setEnabled(true);
        bottomBar.setEnabled(true);
    }

    /* End Side Bar */

    /* Level System */
    private void CheckExp() {
        int currentExp = level_Progress.getProgress();
        if (currentExp >= require_Exp) {
            int remainExp = currentExp - require_Exp;
            level_Progress.setProgress(remainExp);
            LevelUp();
        }
    }

    private void LevelUp() {
        level_Text.setText(++currentLevel);
    }
    /* End Level System */

    /* MainLog System */
    public void FixMainLogData() {
        String logText[] = getResources().getStringArray(R.array.testMainLog_Name);
        mainLogDataList = new ArrayList<MainLogItem>();

        for (int i = 0; i < logText.length; i++)
            mainLogDataList.add(new MainLogItem(logText[i]));
    }

    public void FixMainLogData(ArrayList<MainLogItem> _itemList) {
        mainLogDataList = _itemList;
    }

    public void UpdateMainLog() {
        mainLogAdapter.notifyDataSetChanged();
    }

    /* End MainLog System */
}