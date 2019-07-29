package com.techhousestudio.demobottomnavigation.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.techhousestudio.demobottomnavigation.database.Article;

import java.util.List;

public class ArticleAndroidViewModel extends AndroidViewModel {
    private ArticleRepository articleRepository;
    private LiveData<List<Article>> articles;

    public ArticleAndroidViewModel(@NonNull Application application) {
        super(application);
        articleRepository =new ArticleRepository(application);
        articles = articleRepository.getArticles();

    }
    public void insertArticle(Article article){
        articleRepository.insertArticle(article);
    }
    public LiveData<List<Article>> getAllArticles(){
        return articles;
    }

    public void deleteArticle(Article article){
        articleRepository.deleteArticle(article);
    }

    public void updateArticle(Article article){
        articleRepository.updateArticle(article);
    }


}
