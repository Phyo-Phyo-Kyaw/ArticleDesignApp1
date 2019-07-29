package com.techhousestudio.demobottomnavigation.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Article {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    public String title, content;
    public int likeCount;


    public Article(int uid, String title, String content, int likeCount) {
        this.uid = uid;
        this.title = title;
        this.content = content;
        this.likeCount = likeCount;
    }

    @Ignore
    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
    @Ignore
    public Article(int uid, String title, String content) {
        this.uid = uid;
        this.title = title;
        this.content = content;
    }
}
