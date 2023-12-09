package com.example.helloandroid20ct3.LastTest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid20ct3.R;

import java.util.ArrayList;

public class BurgerList extends AppCompatActivity {

    public static boolean mediaPlayerIsPlaying = false;
    Button back;
    private ListView lv_pizza;

    private int songIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_list);

        lv_pizza = findViewById(R.id.listView1);

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

    ArrayList<BurgerList.Pizza> pizzas = new ArrayList<>();
    private void createLv2(){
        pizzas.add(new BurgerList.Pizza("Bacon Cheeseburger", R.drawable.bg1_vuong, "Italian", "30:00"));
        pizzas.add(new BurgerList.Pizza("Avocado Turkey Burger", R.drawable.bg2_vuong, "Italian", "35:00"));
        pizzas.add(new BurgerList.Pizza("Mushroom Swiss Burger", R.drawable.bg3_vuong, "United States", "25:00"));

        BurgerList.CountryAdapter adapter1 = new BurgerList.CountryAdapter();
        lv_pizza.setAdapter(adapter1);
        lv_pizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BurgerList.Pizza selectedItem = pizzas.get(i);

                // Tạo Intent để mở activity tương ứng với item được chọn
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(BurgerList.this, DishActivity4.class);
                        BurgerList.this.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(BurgerList.this, DishActivity5.class);
                        BurgerList.this.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(BurgerList.this, DishActivity6.class);
                        BurgerList.this.startActivity(intent);
                        break;
                    default:
                        // Nếu có thêm item, thì thêm các case tương ứng ở đây
                        return;
                }
            }
        });
    }
    class CountryAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return pizzas.size();
        }

        @Override
        public Object getItem(int i) {
            return pizzas.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater1 = LayoutInflater.from(getBaseContext());
            View itemView = inflater1.inflate(R.layout.activity_song_item,null);
            BurgerList.Pizza citem = pizzas.get(i);

            ImageView imageView1 = itemView.findViewById(R.id.imageView1);
            imageView1.setImageResource(citem.imgPizza);

            TextView tvTen = itemView.findViewById(R.id.textView1);
            tvTen.setText(citem.name);

            TextView tvMili = itemView.findViewById(R.id.textView2);
            tvMili.setText(citem.singer);

            TextView timeSong = itemView.findViewById((R.id.textView3));
            timeSong.setText(citem.timeSong);

            return itemView;
        }
    }
    class Pizza {
        String name;
        int imgPizza;
        String singer;
        String timeSong;
        public Pizza(String name, int imgPizza, String singer, String timeSong){
            this.name = name;
            this.imgPizza = imgPizza;
            this.singer = singer;
            this.timeSong = timeSong;
        }
    }
}