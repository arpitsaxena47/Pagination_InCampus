package com.arpit.paginationincampus;

import android.graphics.Movie;

import java.util.ArrayList;
import java.util.List;

public class Songs {
    private String songName;
    private String singer;

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
    public Songs()
    {

    }

    public Songs(String songName, String singer) {
        this.songName = songName;
        this.singer = singer;
    }
public static List<Songs> createSongs(int itemCount) {
    List<Songs> songsList = new ArrayList<>();
   songsList.add(new Songs("abc" , "1"));
    songsList.add(new Songs("def" , "2"));
    songsList.add(new Songs("ghi" , "3"));
    songsList.add(new Songs("jkl" , "4"));
    songsList.add(new Songs("mno" , "5"));
    songsList.add(new Songs("pqr" , "6"));
    songsList.add(new Songs("stu" , "7"));
    songsList.add(new Songs("vwx" , "8"));
    return songsList;
}
}
