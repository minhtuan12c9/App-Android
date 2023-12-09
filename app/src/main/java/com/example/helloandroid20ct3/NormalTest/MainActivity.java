package com.example.helloandroid20ct3.NormalTest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloandroid20ct3.LastTest.Start;
import com.example.helloandroid20ct3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.v("MAIN", "#onCreate");
        Log.d("MAIN", "#onCreate");
        Log.i("MAIN", "#onCreate");
        Log.w("MAIN", "#onCreate");
        Log.e("MAIN", "#onCreate");

        Toast.makeText(this, "Bắt đầu Activity", Toast.LENGTH_LONG).show();


    }

    public void doButtonHello(View v){
        Intent i1 = new Intent(this, HelloActivity.class);

        EditText fullname = findViewById(R.id.fullname);
        EditText year = findViewById(R.id.year);

        String getFullname = fullname.getText().toString();
        String getYear = year.getText().toString();

        i1.putExtra("getFullname", getFullname);
        i1.putExtra("getYear", getYear);

        startActivity(i1);

        fullname.setText("");
        year.setText("");
    }
    public void doButtonMusic(View v){
        Intent i1 = new Intent(this, MusicActivity.class);
        i1.putExtra("Song_Start", 1);
        startActivity(i1);
    }
    public void doButtonQuote(View v){
        Intent i1 = new Intent(this, QuotationsActivity.class);
        startActivity(i1);
    }
    public void doButtonBMI(View v){
        Intent i1 = new Intent(this, BMI.class);
        startActivity(i1);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        Intent i1 = new Intent(Intent.ACTION_VIEW);
        i1.setData(Uri.parse("https://google.com.vn"));
        startActivity(i1);

        return  super.onTouchEvent(event);
    }
    public void doButtonMain2(View v){
        Intent i1 = new Intent(this, MainActivity2.class);
        startActivity(i1);
    }
    public void layout3(View v){
        Intent i1 = new Intent(this, LayoutActivity3.class);
        startActivity(i1);
    }
    public void opera(View v){
        Intent i1 = new Intent(this, OperaActivity3.class);
        startActivity(i1);
    }
    public void relaytive(View v){
        Intent i1 = new Intent(this, Login.class);
        startActivity(i1);
    }
    public void seek(View v){
        Intent i1 = new Intent(this, SeekTextActivity.class);
        startActivity(i1);
    }
    public void profile(View v){
        Intent i1 = new Intent(this, ProfileActivity.class);
        startActivity(i1);
    }
    public void user(View v){
        Intent i1 = new Intent(this, UserActivity.class);
        startActivity(i1);
    }
    public void listView(View v){
        Intent i1 = new Intent(this, ListViewExample.class);
        startActivity(i1);
    }
    public void lastTest(View v){
        Intent i1 = new Intent(this, Start.class);
        startActivity(i1);
    }
}