package com.example.praktikum_mobile_4_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rvPahlawan;
    private RecyclerView.Adapter mRecyclerView;
    private ArrayList<PahlawanModel> listPahlawan       =   new ArrayList<>();
    private Button share;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rvPahlawan              = rvPahlawan.findViewById(R.id.rv_heroes);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(PahlawanData.getListData());
        showRecyclerList();

        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    private void showRecyclerList() {
        rvPahlawan.setLayoutManager(new LinearLayoutManager(getContext()));
        PahlawanAdapter pahlawanAdapter         =   new PahlawanAdapter(this);
        pahlawanAdapter.setPahlawanModels(listPahlawan);
        rvPahlawan.setAdapter(pahlawanAdapter);
    }

}
