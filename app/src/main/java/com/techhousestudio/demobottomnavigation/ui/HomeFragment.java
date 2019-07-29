package com.techhousestudio.demobottomnavigation.ui;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.techhousestudio.demobottomnavigation.R;
import com.techhousestudio.demobottomnavigation.adapters.ArticleRecyclerAdapter;
import com.techhousestudio.demobottomnavigation.database.Article;
import com.techhousestudio.demobottomnavigation.viewmodel.ArticleAndroidViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private ArticleAndroidViewModel model;
    private FloatingActionButton fab;

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
        fab=view.findViewById(R.id.fab);

        final ArticleRecyclerAdapter articleRecyclerAdapter = new ArticleRecyclerAdapter(getContext());

        model= ViewModelProviders.of(getActivity()).get(ArticleAndroidViewModel.class);
        model.getAllArticles().observe(getActivity(), new Observer<List<Article>>() {
            @Override
            public void onChanged(List<Article> articles1) {
                articleRecyclerAdapter.setArticles(articles1);
                article_list.setAdapter(articleRecyclerAdapter);
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),InsertArticlesActivity.class);
                intent.putExtra("BtnName","INSERT");
                startActivity(intent);
                //model.insertArticle(new Article("Material Component", "Material Button is a customizable button component with updated visual styles. This button component has several built-in styles to support different levels of emphasis, as typically any UI will contain a few different buttons to indicate different actions. These levels of emphasis include:"));
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.LEFT,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Article article=articleRecyclerAdapter.getArticles().get(viewHolder.getAdapterPosition());
                model.deleteArticle(article);
                articleRecyclerAdapter.notifyItemRemoved(viewHolder.getAdapterPosition());
            }
        }).attachToRecyclerView(article_list);
    }
}
