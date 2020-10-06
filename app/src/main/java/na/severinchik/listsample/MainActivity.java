package na.severinchik.listsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import na.severinchik.listsample.adapter.PurseAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Purse> list = new ArrayList<>();
        list.add(new Purse("Name1","5u1ns2f8reww5d6wd1d1llbik4u4rhz6"));
        list.add(new Purse("Name1","0ljokfa20urf4jwv2q8xlphnk2iciaxn"));
        list.add(new Purse("Name2","6qyibzy17v3foh9sybjemoh6v9t320ub"));
        list.add(new Purse("Name3","u82lc94nr34nu5miekwumrtd3my5jg0v"));
        list.add(new Purse("Name4","bhekkl45q6he0ot57s4t8t5gc57xcqj2"));



        recyclerView = findViewById(R.id.list);
        recyclerView.setAdapter(new PurseAdapter(list));
    }
}