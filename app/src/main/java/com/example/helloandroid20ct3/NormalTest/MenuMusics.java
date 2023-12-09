package com.example.helloandroid20ct3.NormalTest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

import java.util.ArrayList;

public class MenuMusics extends AppCompatActivity {
    public static boolean mediaPlayerIsPlaying = false;
    Button back;
    private ListView lv_music;

    private int songIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_musics);

        lv_music = findViewById(R.id.listView1);

        Intent data = getIntent();

        songIndex = data.getIntExtra("songIndex", 0);

        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        createLv2();
    }

    private void createLv(){
        ArrayList<String> items = new ArrayList<>();
        items.add("À Lôi");
        items.add("Một Ngày Chẳng Nắng");
        items.add("See Tình");
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,items);
        lv_music.setAdapter(adapter1);
    }
    ArrayList<Music> musics = new ArrayList<>();
    private void createLv2(){
        musics.add(new Music("À Lôi", R.drawable.aloivuong, "Double2T", "03:17"));
        musics.add(new Music("See Tình", R.drawable.seetinhvuong, "Hoàng Thuỳ Linh", "03:05"));
        musics.add(new Music("Một Ngày Chẳng Nắng", R.drawable.motngaychangnangvuong, "Pháo", "03:13"));

        CountryAdapter adapter1 = new CountryAdapter();
        lv_music.setAdapter(adapter1);
        lv_music.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Music selectedItem = musics.get(i);

                // Tạo Intent
                Intent intent = new Intent();

                // Đặt dữ liệu trong Intent
                intent.putExtra("songIndex", i);

                // Chuyển sang MusicActivity
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
    class CountryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return musics.size();
        }

        @Override
        public Object getItem(int i) {
            return musics.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater1 = LayoutInflater.from(getBaseContext());
            View itemView = inflater1.inflate(R.layout.activity_song_item,null);
            Music citem = musics.get(i);

            if(songIndex == i){
                GradientDrawable shape = new GradientDrawable();
                shape.setShape(GradientDrawable.RECTANGLE);
                shape.setColor(Color.parseColor("#40FFFFFF"));
                shape.setCornerRadius(40);

                itemView.setBackground(shape);
            }

            ImageView imageView1 = itemView.findViewById(R.id.imageView1);
            imageView1.setImageResource(citem.imgSong);

            TextView tvTen = itemView.findViewById(R.id.textView1);
            tvTen.setText(citem.name);

            TextView tvMili = itemView.findViewById(R.id.textView2);
            tvMili.setText(citem.singer);

            TextView timeSong = itemView.findViewById((R.id.textView3));
            timeSong.setText(citem.timeSong);

            return itemView;
        }
    }
    class Music {
        String name;
        int imgSong;
        String singer;
        String timeSong;
        public Music(String name,int imgSong,String singer, String timeSong){
            this.name = name;
            this.imgSong = imgSong;
            this.singer = singer;
            this.timeSong = timeSong;
        }
    }
}