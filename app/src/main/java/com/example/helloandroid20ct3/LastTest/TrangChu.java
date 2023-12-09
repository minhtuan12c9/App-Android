package com.example.helloandroid20ct3.LastTest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloandroid20ct3.Adaptor.CategoryAdaptor;
import com.example.helloandroid20ct3.Adaptor.PopularAdaptor;
import com.example.helloandroid20ct3.Domain.CategoryDomain;
import com.example.helloandroid20ct3.Domain.FoodDomain;
import com.example.helloandroid20ct3.R;

import java.util.ArrayList;

public class TrangChu extends AppCompatActivity {
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);

        recyclerViewCategory();
        recyclePopular();
    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> category = new ArrayList<>();
        category.add(new CategoryDomain("Pizza", "cat_1"));
        category.add(new CategoryDomain("Burger", "cat_2"));
        category.add(new CategoryDomain("Hotdog", "cat_3"));
        category.add(new CategoryDomain("Donut", "cat_5"));
        category.add(new CategoryDomain("Drink", "cat_4"));


        adapter = new CategoryAdaptor(this, category);
        recyclerViewCategoryList.setAdapter(adapter);


    }

    private void recyclePopular(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recycleView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList = new ArrayList<>();
        foodList.add(new FoodDomain("Pepperoni Pizza","pop_1"));
        foodList.add(new FoodDomain("Cheese Burger","pop_2"));
        foodList.add(new FoodDomain("New York Pizza","pop_3"));

        adapter2 = new PopularAdaptor(this,foodList);
        recyclerViewPopularList.setAdapter(adapter2);


    }
}