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

public class CategoryList extends AppCompatActivity {

    public static boolean mediaPlayerIsPlaying = false;
    Button back;
    private ListView lv_pizza;

    private int songIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

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

    ArrayList<CategoryList.Pizza> pizzas = new ArrayList<>();
    private void createLv2(){
        pizzas.add(new CategoryList.Pizza("Pepperoni Pizza", R.drawable.pz1_vuong, "Italian", "30:00"));
        pizzas.add(new CategoryList.Pizza("Pizza Margherita", R.drawable.pz2_vuong, "Italian", "35:00"));
        pizzas.add(new CategoryList.Pizza("New York Pizza", R.drawable.pz3_vuong, "United States", "25:00"));

        CategoryList.CountryAdapter adapter1 = new CategoryList.CountryAdapter();
        lv_pizza.setAdapter(adapter1);
        lv_pizza.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                CategoryList.Pizza selectedItem = pizzas.get(i);

                // Tạo Intent để mở activity tương ứng với item được chọn
                Intent intent;
                switch (i) {
                    case 0:
                        intent = new Intent(CategoryList.this, DishActivity1.class);
                        CategoryList.this.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(CategoryList.this, DishActivity2.class);
                        CategoryList.this.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(CategoryList.this, DishActivity3.class);
                        CategoryList.this.startActivity(intent);
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
            CategoryList.Pizza citem = pizzas.get(i);

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