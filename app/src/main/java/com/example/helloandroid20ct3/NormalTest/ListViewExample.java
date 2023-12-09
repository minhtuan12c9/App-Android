package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloandroid20ct3.R;

import java.util.ArrayList;

public class ListViewExample extends AppCompatActivity {
    private ListView lv_country;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        lv_country = findViewById(R.id.listView1);
        //createLv();
        createLv2();
    }

    private void createLv(){
        ArrayList<String> items = new ArrayList<>();
        items.add("Việt Nam");
        items.add("United State");
        items.add("Russia");
        items.add("Italy");
        items.add("Germany");
        items.add("France");

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,items);
        lv_country.setAdapter(adapter1);

//        lv_country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(ListView1.this, "Bạn chọn mục: "+ items.get(i),Toast.LENGTH_SHORT ).show();
//            }
//        });
    }
    ArrayList<Country> countries = new ArrayList<>();
    private void createLv2(){
        countries.add(new Country("Việt Nam", R.drawable.vietnam, 200));
        countries.add(new Country("United State", R.drawable.usa, 900));
        countries.add(new Country("Russia", R.drawable.russia, 600));

        CountryAdapter adapter1 = new CountryAdapter();
        lv_country.setAdapter(adapter1);
        lv_country.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Country citem = countries.get(i);
            }
        });
    }
    class CountryAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return countries.size();
        }

        @Override
        public Object getItem(int i) {
            return countries.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater1 = LayoutInflater.from(getBaseContext());
            View itemView = inflater1.inflate(R.layout.activity_country_item,null);
            Country citem = countries.get(i);

            ImageView imageView1 = itemView.findViewById(R.id.imageView1);
            imageView1.setImageResource(citem.flag);
            TextView tvTen = itemView.findViewById(R.id.textView1);
            tvTen.setText(citem.name);
            TextView tvMili = itemView.findViewById(R.id.textView2);
            tvMili.setText("Military:"+ citem.military);
            return itemView;
        }
    }
    class Country {
        String name;
        int flag;
        int military;
        public Country(String name,int flag,int military){
            this.name = name;
            this.flag = flag;
            this.military = military;
        }
    }
}