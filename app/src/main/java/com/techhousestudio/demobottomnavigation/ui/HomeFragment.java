package com.techhousestudio.demobottomnavigation.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.techhousestudio.demobottomnavigation.R;
import com.techhousestudio.demobottomnavigation.adapters.ArticleRecyclerAdapter;
import com.techhousestudio.demobottomnavigation.models.Article;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {



    // widget
    private RecyclerView article_list;


    // var
    private static HomeFragment INSTANCE;


    public static synchronized HomeFragment getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HomeFragment();
        }
        return(INSTANCE);
    }

    private HomeFragment(){
        Log.d("WKKN","Call Fragment");
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        article_list = view.findViewById(R.id.article_list);
        article_list.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Article> articles = new ArrayList<>();
        articles.add(new Article("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Clip Component", "Clips Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("NavigationView Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("TabLayout Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("RecyclerView Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Toast Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Activity Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
        articles.add(new Article("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));

        ArticleRecyclerAdapter articleRecyclerAdapter = new ArticleRecyclerAdapter(getContext(), articles);


        article_list.setAdapter(articleRecyclerAdapter);
    }
}
