package na.severinchik.listsample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import na.severinchik.listsample.adapter.PurseAdapter;

public class BlankFragment extends Fragment implements PurseAdapter.PurseAdapterClickListener {

    private RecyclerView recyclerView;
    private final String TAG = "BlankFragment";
    
    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        ArrayList<Purse> list = new ArrayList<>();
        list.add(new Purse("Name1", "5u1ns2f8reww5d6wd1d1llbik4u4rhz6"));
        list.add(new Purse("Name1", "0ljokfa20urf4jwv2q8xlphnk2iciaxn"));
        list.add(new Purse("Name2", "6qyibzy17v3foh9sybjemoh6v9t320ub"));
        list.add(new Purse("Name3", "u82lc94nr34nu5miekwumrtd3my5jg0v"));
        list.add(new Purse("Name4", "bhekkl45q6he0ot57s4t8t5gc57xcqj2"));


        recyclerView = view.findViewById(R.id.list);
        recyclerView.setAdapter(new PurseAdapter(list, this));
        return view;
    }

    @Override
    public void onClickFullTypeView(Purse purse) {
        Log.d(TAG, "onClickFullTypeView: "+purse.toString());
    }

    @Override
    public void onClickDefaultView(Purse purse) {
        Log.d(TAG, "onClickDefaultView: "+purse.toString());
    }

    @Override
    public void defaultOnClick(Purse purse) {
        Log.d(TAG, "defaultOnClick: "+purse.toString());
    }
}