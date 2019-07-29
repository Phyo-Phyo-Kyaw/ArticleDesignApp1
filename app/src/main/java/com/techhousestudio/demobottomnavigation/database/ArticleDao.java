package com.techhousestudio.demobottomnavigation.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM Article")
    LiveData<List<Article>> getAllArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertArticle(Article article);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateArticle(Article article);

    @Delete
    void deleteArticle(Article article);
}
