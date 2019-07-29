package com.techhousestudio.demobottomnavigation.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Article.class},version = 1,exportSchema=true)
public abstract class ArticleRoomDb extends RoomDatabase {
    private static volatile ArticleRoomDb INSTANCE;

    public static ArticleRoomDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ArticleRoomDb.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ArticleRoomDb.class, "library_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public abstract ArticleDao ArticleDao();
}
