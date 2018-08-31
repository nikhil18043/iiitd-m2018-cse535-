package com.donotcopy.musicplayer;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class List_Homework2_MT18043 extends Fragment implements AdapterView.OnItemClickListener{

    ListView lt;
    List list;
    ArrayAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_list__homework2__mt18043, container, false);
        lt = (ListView) view.findViewById(R.id.listview);
        list = new ArrayList<>();
        String[] f = new String[0];
            try {
                f = getActivity().getAssets().list("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,list);
        lt.setAdapter(adapter);
        for(int i=0;i<f.length;i++)
            {
                if(f[i].equals("images")||f[i].equals("sounds")||f[i].equals("webkit"));
                else
                    list.add(f[i]);
            }
             lt.setOnItemClickListener(this);
        return view;
    }
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        String name = (String) adapterView.getItemAtPosition(i);
        Intent intent = new Intent(getActivity(), MusicService_Homework2_MT18043.class);
        Bundle b = new Bundle();
        b.putString("song",name);
        intent.putExtras(b);
        getActivity().startService(intent);

    }

}
