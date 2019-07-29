package com.techhousestudio.demobottomnavigation.viewmodel;

import android.app.Application;

import androidx.lifecycle.LiveData;


import com.techhousestudio.demobottomnavigation.database.AppExecutors;
import com.techhousestudio.demobottomnavigation.database.Article;
import com.techhousestudio.demobottomnavigation.database.ArticleDao;
import com.techhousestudio.demobottomnavigation.database.ArticleRoomDb;

import java.util.List;

public class ArticleRepository {
    private ArticleRoomDb articleRoomDb;
    private ArticleDao articleDao;
    private LiveData<List<Article>> articles;
    ArticleRepository(Application application)
    {
        articleRoomDb =ArticleRoomDb.getDatabase(application);
        articleDao = articleRoomDb.ArticleDao();
        articles = articleDao.getAllArticles();
    }

    public LiveData<List<Article>> getArticles() {
        return articles;
    }

    public void insertArticle(final Article article){
       // new insertAsyncTask(articleDao).execute(user);
        new AppExecutors().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                articleDao.insertArticle(article);
            }
        });
    }

    public void deleteArticle(final Article article){
        //new deleteAsyncTask(articleDao).execute(user);
        new AppExecutors().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                articleDao.deleteArticle(article);
            }
        });
    }

    public void updateArticle(final Article article){
        //articleRoomDb.ArticleDao().updateArticle(user);
        new AppExecutors().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                articleDao.updateArticle(article);
            }
        });
    }


}
