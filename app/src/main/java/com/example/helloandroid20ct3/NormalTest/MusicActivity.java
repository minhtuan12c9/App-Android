package com.example.helloandroid20ct3.NormalTest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.helloandroid20ct3.R;

import java.util.Random;

public class MusicActivity extends AppCompatActivity {
    private int[] songs = {R.raw.abc, R.raw.seetinh, R.raw.motngaychangnang};
    private String[] songNames = {"À lôi", "See Tình", "Một Ngày Chẳng Nắng"};
    private String[] songSinger = {"Double2T", "Hoàng Thuỳ Linh", "Pháo"};
    private int[] imgCDs = {R.drawable.aloitron, R.drawable.seetinhtron, R.drawable.motngaychangnangtron};
    private int[] imgBackgrounds = {R.drawable.aloi, R.drawable.seetinh, R.drawable.motngaychangnang};
    private Animation rotate;
    private int songIndex = 0;
    private MediaPlayer player = null;
    private TextView name;
    private TextView singer;
    private Random rand = new Random();
    private ConstraintLayout layoutMusic;
    private SeekBar seekBar;
    private Handler handler = new Handler();
    private TextView timeSong1;
    private TextView timeSong2;
    Drawable pauseIcon;
    Button btnPlayPaused;
    private ImageView cd;
    private ConstraintLayout anhNen;
    Button heart;
    int check = 0;

    private boolean isRepeatOn = false; // Biến để kiểm tra chế độ lặp lại
    public MusicActivity() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        heart = findViewById(R.id.btnHeart);

        rotate = AnimationUtils.loadAnimation(this, R.anim.rotate);

        cd = findViewById(R.id.cd);
        anhNen = findViewById(R.id.anhNen);

        cd.setImageResource(imgCDs[songIndex]);
        //anhNen.setBackground(getResources().getDrawable(imgBackgrounds[songIndex]));
        anhNen.setBackground(getResources().getDrawable(R.drawable.phone));

        // Ánh xạ TextViews
        singer = findViewById(R.id.singer);

        Button btnPrev = findViewById(R.id.pre);
        btnPlayPaused = findViewById(R.id.btnPlayPaused);
        Button btnNext = findViewById(R.id.next);

        seekBar = findViewById(R.id.seekBar2);

        timeSong1 = findViewById(R.id.timeSong);
        timeSong2 = findViewById(R.id.timeSong2);

        // Initialize the MediaPlayer
        player = MediaPlayer.create(MusicActivity.this, songs[songIndex]);

        // Update UI
        name = findViewById(R.id.name);
        name.setText(songNames[songIndex]);
        singer.setText(songSinger[songIndex]);

        Drawable playIcon = getResources().getDrawable(R.drawable.play);
        pauseIcon = getResources().getDrawable(R.drawable.pause);

        Drawable heartnormal = getResources().getDrawable(R.drawable.heart);
        Drawable redHeart = getResources().getDrawable(R.drawable.red);

        // Set the initial icon based on the current state of the MediaPlayer
        if (player.isPlaying()) {
            btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(pauseIcon, null, null, null);
        } else {
            btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(playIcon, null, null, null);
        }

        Button btnRepeat = findViewById(R.id.repeat);
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Đảo ngược giá trị của biến isRepeatOn
                isRepeatOn = !isRepeatOn;

                // Cập nhật giao diện dựa trên trạng thái lặp lại mới
                updateRepeatButtonUI();

                // Nếu chế độ lặp lại được kích hoạt, sử dụng setOnCompletionListener để lặp lại
                if (isRepeatOn) {
                    player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            // Handle completion, e.g., move to the next song or replay the current song
                            if (isRepeatOn) {
                                // Lặp lại bài hát hiện tại
                                mp.seekTo(0);
                                mp.start();
                            } else {
                                // Di chuyển đến bài hát tiếp theo
                                playNext();
                            }
                        }
                    });
                } else {
                    // Nếu chế độ lặp lại không được kích hoạt, hủy bỏ setOnCompletionListener
                    player.setOnCompletionListener(null);
                }
            }
        });

        heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check==0){
                    heart.setCompoundDrawablesWithIntrinsicBounds(redHeart, null, null, null);
                    check = 1;
                }
                else {
                    heart.setCompoundDrawablesWithIntrinsicBounds(heartnormal, null, null, null);
                    check = 0;
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    // If the change is initiated by the user, seek to the new position
                    player.seekTo(progress);
                }
                // Update the TextView with the current time
                updateTimeTextView(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                // Handle completion, e.g., move to the next song
                playNext();
            }
        });
        player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // Set the maximum value of the SeekBar to the duration of the song
                seekBar.setMax(mp.getDuration());
                // Start updating the SeekBar
                updateSeekBar();
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playPrev();
            }
        });

        btnPlayPaused.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(player == null){
                    songIndex = rand.nextInt(songs.length);
                    player = MediaPlayer.create(MusicActivity.this, songs[songIndex]);
                    name.setText(songNames[songIndex]);
                    singer.setText(songSinger[songIndex]);
                }
                if(player.isPlaying()){
                    player.pause();
                    btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(playIcon, null, null, null);
                    cd.clearAnimation();
                }else {
                    player.start();
                    btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(pauseIcon, null, null, null);
                    cd.startAnimation(rotate);
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playNext();
            }
        });
    }
    public void doButtonMenu(View v){
        Intent i1 = new Intent(this, MenuMusics.class);
        i1.putExtra("songIndex", songIndex);
        startActivityForResult(i1, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1234 && resultCode == Activity.RESULT_OK && data != null){
            songIndex = data.getIntExtra("songIndex", 0);
            if(player != null){
                player.stop();
            }

            player = MediaPlayer.create(MusicActivity.this, songs[songIndex]);
            name.setText(songNames[songIndex]);
            singer.setText(songSinger[songIndex]);
            player.start();
            btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(pauseIcon, null, null, null);
            cd.setImageResource(imgCDs[songIndex]);
            //anhNen.setBackground(getResources().getDrawable(imgBackgrounds[songIndex]));
            anhNen.setBackground(getResources().getDrawable(R.drawable.phone));
            cd.startAnimation(rotate);
            name.setText(songNames[songIndex]);
            singer.setText(songSinger[songIndex]);
        }
    }

    private void updateSeekBar() {
        if (player != null) {
            // Update SeekBar's progress based on the current position of the MediaPlayer
            seekBar.setProgress(player.getCurrentPosition());
        }
        // Run this method again after a short delay
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateSeekBar();
            }
        }, 1000); // Update every 1 second (you can adjust this interval)
    }
    private void playPrev() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }

        if (songIndex == 0) {
            songIndex = songs.length - 1;
        } else {
            songIndex--;
        }

        player = MediaPlayer.create(MusicActivity.this, songs[songIndex]);
        name.setText(songNames[songIndex]);
        seekBar.setMax(player.getDuration());
        cd.setImageResource(imgCDs[songIndex]);
        //anhNen.setBackground(getResources().getDrawable(imgBackgrounds[songIndex]));
        anhNen.setBackground(getResources().getDrawable(R.drawable.phone));
        cd.startAnimation(rotate);
        singer.setText(songSinger[songIndex]);
        updateSeekBar();
        btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(pauseIcon, null, null, null);
        player.start();
    }
    private void playNext() {
        if (player != null) {
            player.stop();
            player.release();
            player = null;
        }

        if (songIndex == songs.length - 1) {
            songIndex = 0;
        } else {
            songIndex++;
        }

        player = MediaPlayer.create(MusicActivity.this, songs[songIndex]);
        name.setText(songNames[songIndex]);
        seekBar.setMax(player.getDuration());
        cd.setImageResource(imgCDs[songIndex]);
        //anhNen.setBackground(getResources().getDrawable(imgBackgrounds[songIndex]));
        anhNen.setBackground(getResources().getDrawable(R.drawable.phone));
        cd.startAnimation(rotate);
        singer.setText(songSinger[songIndex]);
        updateSeekBar();
        btnPlayPaused.setCompoundDrawablesWithIntrinsicBounds(pauseIcon, null, null, null);
        player.start();
    }
    private void updateTimeTextView(int currentTime) {
        int totalDuration = player.getDuration();
        int currentMinutes = currentTime / 1000 / 60;
        int currentSeconds = (currentTime / 1000) % 60;
        int totalMinutes = totalDuration / 1000 / 60;
        int totalSeconds = (totalDuration / 1000) % 60;
        String time1 = String.format("%02d:%02d", currentMinutes, currentSeconds);
        timeSong1.setText(time1);
        String time2 = String.format("%02d:%02d", totalMinutes, totalSeconds);
        timeSong2.setText(time2);
    }
    // Hàm cập nhật giao diện của nút lặp lại
    private void updateRepeatButtonUI() {
        Button btnRepeat = findViewById(R.id.repeat);
        Drawable repeatoff = getResources().getDrawable(R.drawable.repeat);
        Drawable repeaton = getResources().getDrawable(R.drawable.repeaton);
        if (isRepeatOn) {
            // Nếu chế độ lặp lại được kích hoạt, sáng nhẹ nút lặp lại
            btnRepeat.setCompoundDrawablesWithIntrinsicBounds(repeaton, null, null, null);
        } else {
            // Nếu chế độ lặp lại không được kích hoạt, không sáng nút lặp lại
            btnRepeat.setCompoundDrawablesWithIntrinsicBounds(repeatoff, null, null, null);
        }
    }
}
