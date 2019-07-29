package com.techhousestudio.demobottomnavigation.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.techhousestudio.demobottomnavigation.R;
import com.techhousestudio.demobottomnavigation.database.Article;
import com.techhousestudio.demobottomnavigation.viewmodel.ArticleAndroidViewModel;

public class InsertArticlesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText etContent,etTitle;
    private Intent intent;
    String title,content,BtnName;
    private Button btnClickMe;
    private ArticleAndroidViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_articles);
        initView();
        btnClickMe.setText(BtnName);
        if(BtnName.equals("UPDATE")){
            etTitle.setText(title);
            etContent.setText(content);
        }
        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BtnName.equals("INSERT")){
                    model.insertArticle(new Article(etTitle.getText().toString(),etContent.getText().toString()));
                    finish();
                }else if(BtnName.equals("UPDATE")){
                    model.updateArticle(new Article(intent.getExtras().getInt("id"),etTitle.getText().toString(),etContent.getText().toString()));
                    finish();
                }
            }
        });
    }

    private void initView() {
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        etTitle=findViewById(R.id.etTitle);
        etContent=findViewById(R.id.etContent);
        btnClickMe=findViewById(R.id.btnClick);
        intent=getIntent();
        BtnName=intent.getExtras().getString("BtnName");
        title=intent.getExtras().getString("title");
        content=intent.getExtras().getString("content");
        model= ViewModelProviders.of(InsertArticlesActivity.this).get(ArticleAndroidViewModel.class);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_row,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.done:
                break;
        }
        return super.onOptionsItemSelected(item);
    }*/
}
