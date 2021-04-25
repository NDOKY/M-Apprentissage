package com.example.m_apprentissage;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SimpleAdapter;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VideoListActivity extends AppCompatActivity {

    VideoView videoView;
    ListView listView;
    ArrayList<String> videoArrayList;

    String []titleStr = {"Cour 1 Video","Cour 2 Video","Cour 3 Video","Cour 4 Video","Cour 5 Video","Cour 6 Video"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*@SuppressLint("WrongViewCast") VideoView videoView = findViewById(R.id.videoLview);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.videoplayback);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);*/

        videoView = findViewById(R.id.videoViewList);
        listView = findViewById(R.id.listViewList);

        videoArrayList = new ArrayList<>();
        videoArrayList.add("Sub title video 1");
        videoArrayList.add("Sub title video 2");
        videoArrayList.add("Sub title video 3");
        videoArrayList.add("Sub title video 4");
        videoArrayList.add("Sub title video 5");
        videoArrayList.add("Sub title video 6");

        List<Map<String, String>> data = new ArrayList<Map<String, String>>();
        for (int i=0; i<titleStr.length; i++) {
            Map<String, String> datum = new HashMap<String, String>(2);
            datum.put("title", titleStr[i]);
            datum.put("subtitle", videoArrayList.get(i));
            data.add(datum);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, data,
                android.R.layout.simple_list_item_2,
                new String[] {"title", "subtitle"},
                new int[] {android.R.id.text1,
                        android.R.id.text2});

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback));
                        break;
                    case 4:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback));
                        break;
                    case 5:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.videoplayback));
                        break;
                    default:
                        break;
                }
                videoView.setMediaController(new MediaController(VideoListActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });


    }
}