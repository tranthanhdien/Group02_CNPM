package com.example.mp3app.activity;

import android.content.Intent;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.View;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.example.mp3app.adapter.ViewPagerList;
import com.example.mp3app.fragment.Fragment_Disk;
import com.example.mp3app.fragment.Fragment_Play_Danh_Sach_Bai_Hat;
import com.example.mp3app.model.BaiHat;
import com.example.mp3app.R;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PlayNhacActivity extends AppCompatActivity {
    Toolbar toolbar;
    ViewPager viewPagerPlayNhac;
    TextView txtTimeSong, txtTimeTotal;
    SeekBar skSong;
    ImageButton imgPre, imgPlay, imgPause, imgNext, imgRepeat, imgShuff;
    public static ArrayList<BaiHat> listSong = new ArrayList<BaiHat>();
    public static ViewPagerList adapterNhac;
    Fragment_Disk fragment_disk;
    Fragment_Play_Danh_Sach_Bai_Hat fragment_play_danh_sach_bai_hat;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_nhac);
        // kiểm tra tín hiệu mạng
        StrictMode.ThreadPolicy threadPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(threadPolicy);

        addControls();
        getDataFromIntent();
        addEvents();
    }

    private void getDataFromIntent() {
        // lấy intent từ BaiHatAdapter và DanhSachBaiHatAdapter qua
        Intent intent = getIntent();
        listSong.clear();

        if (intent != null) { // nếu có data
            if (intent.hasExtra("baihat")) {
                // lấy BaiHat ra
                BaiHat baiHat = intent.getParcelableExtra("baihat"); // lấy data dạng Object
                //Toast.makeText(PlayNhacActivity.this, baiHat.getTenBaiHat(), Toast.LENGTH_LONG).show();
                listSong.add(baiHat);
            }
            // lấy intent từ DanhSachBaiHatActivity qua (danh sách bài hát)
            if (intent.hasExtra("listsong")) {
                // lấy danh sách bài hát
                ArrayList<BaiHat> arrayList = intent.getParcelableArrayListExtra("listsong");
                //listSong = arrayList;
                // duyệt vòng for để lấy các bài hát trong danh sách
//                for (int i = 0; i < arrayList.size(); i++) {
//                    //Toast.makeText(PlayNhacActivity.this, baiHat.getTenBaiHat(), Toast.LENGTH_LONG).show();
//                    listSong.add(arrayList.get(i));
//                    //Toast.makeText(PlayNhacActivity.this, listSong.size(), Toast.LENGTH_LONG).show();
//                }
                for (BaiHat baiHat : arrayList) {
                    listSong.add(baiHat);
                }

            }
        }

    }

    private void addEvents() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (adapterNhac.getItem(1) != null) {
                    if (listSong.size() > 0) {
                        fragment_disk.playNhac(listSong.get(0).getHinhCaSi());
                        handler.removeCallbacks(this);

                    } else {
                        // nửa giây cập nhật rồi chạy lại
                        handler.postDelayed(this, 500);
                    }
                }


                handler.postDelayed(this, 500); // nửa giây cập nhật rồi chạy lại
            }
        }, 100);

        // sự kiện nhấn nút play
        imgPlay.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                // nếu đang mở thì dừng
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.iconplay1);
                    if (fragment_disk.objectAnimator != null) {
                        fragment_disk.objectAnimator.pause();
                    }

                } else { // ngược lại đang nghe
                    mediaPlayer.start();
                    imgPlay.setImageResource(R.drawable.iconpause1);
                    if (fragment_disk.objectAnimator != null) {
                        fragment_disk.objectAnimator.resume();
                    }
                    ///fragment_disk.circleImageView.clearAnimation();

                }
            }
        });

    }

    private void addControls() {
        toolbar = (Toolbar) findViewById(R.id.tbPlayNhac);
        txtTimeSong = (TextView) findViewById(R.id.txtTimeSong);
        txtTimeTotal = (TextView) findViewById(R.id.txtTimeTotal);
        skSong = (SeekBar) findViewById(R.id.seekBarSong);
        imgShuff = (ImageButton) findViewById(R.id.imgButtonShuff);
        imgPre = (ImageButton) findViewById(R.id.imgButtonPre);
        imgPlay = (ImageButton) findViewById(R.id.imgButtonPlay);
        imgNext = (ImageButton) findViewById(R.id.imgButtonNext);
        imgRepeat = (ImageButton) findViewById(R.id.imgButtonRepeat);
        viewPagerPlayNhac = (ViewPager) findViewById(R.id.vpNhac);
        //imgDisk = (ImageView) findViewById(R.id.imgDisk);


        // vì đã xoá action bar nên thay thế bằng SupportAction
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        toolbar.setTitleTextColor(Color.WHITE);
        // gắn ViewPager
        adapterNhac = new ViewPagerList(getSupportFragmentManager());
        fragment_disk = new Fragment_Disk(); // new ra Fragment đĩa nhạc
        fragment_play_danh_sach_bai_hat = new Fragment_Play_Danh_Sach_Bai_Hat(); // new ra Fragment danh sách bài hát
        // thêm vào View Pager (View Pager để chuyển qua lại các màn hình)

        // Fragment danh sách sẽ nằm bên trái Fragment đĩa nhạc
        adapterNhac.addFragment(fragment_play_danh_sach_bai_hat);
        adapterNhac.addFragment(fragment_disk);
        viewPagerPlayNhac.setAdapter(adapterNhac);

        fragment_disk = (Fragment_Disk) adapterNhac.getItem(1);
        if (listSong.size() > 0) {
            getSupportActionBar().setTitle(listSong.get(0).getTenBaiHat());
            //fragment_disk.txtNameCaSi.setText(listSong.get(0).getCaSi());
            new PlayMP3().execute(listSong.get(0).getLinkBaiHat());
            imgPlay.setImageResource(R.drawable.iconpause1);
        }
    }

    class PlayMP3 extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            return strings[0];
        }

        @Override
        protected void onPostExecute(String baihat) {
            super.onPostExecute(baihat);
            try {
                mediaPlayer = new MediaPlayer();
                mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC); // chạy online
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        mediaPlayer.stop();
                        mediaPlayer.reset();

                    }
                });

                mediaPlayer.setDataSource(baihat);
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
            timeSong();
        }
    }

    private void timeSong() {
        // lấy time hiện tại cập nhật lại phút giây
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTimeTotal.setText(simpleDateFormat.format(mediaPlayer.getDuration())); // lấy vị trí hiện tại của Media Player
        // gán max của thanh Seekbar = tổng thời gian bài hát (getDuration)
        skSong.setMax(mediaPlayer.getDuration());
    }
}