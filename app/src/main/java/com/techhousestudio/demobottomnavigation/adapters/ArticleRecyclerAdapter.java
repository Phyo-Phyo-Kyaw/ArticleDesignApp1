package com.techhousestudio.demobottomnavigation.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.text.HtmlCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.techhousestudio.demobottomnavigation.R;
import com.techhousestudio.demobottomnavigation.models.Article;

import java.util.List;

public class ArticleRecyclerAdapter extends RecyclerView.Adapter<ArticleRecyclerAdapter.ArticleViewHolder> {
    private Context context;
    private List<Article> articles;
    private int[] colors = {Color.RED, Color.GREEN, Color.BLACK, Color.GRAY, Color.CYAN};

    public ArticleRecyclerAdapter(Context context, List<Article> articles) {
        this.articles = articles;
        this.context = context;
        Log.d("WKKN", "Call Recycler View");
    }

    @NonNull
    @Override

    public ArticleRecyclerAdapter.ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ArticleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_article_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleRecyclerAdapter.ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.tvTitle.setText(article.title);
        holder.tvContent.setText(article.content);
        holder.btnLike.setText(article.likeCount > 1 ? article.likeCount + " Likes" : article.likeCount + " Like");
        final int random = (int) (Math.random() * 5 + 0);

        holder.viewLine.setBackgroundColor(colors[random]);
        holder.tvTitle.setTextColor(colors[random]);

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.btnLike.setText(random > 1 ? random + " Likes" : random + " Like");
            }
        });
    }

    @Override
    public int getItemCount() {
        if (articles == null) return 0;
        return articles.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvContent;
        Button btnLike;
        View viewLine;

        ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            viewLine = itemView.findViewById(R.id.view_line);
            tvContent = itemView.findViewById(R.id.tvContent);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            btnLike = itemView.findViewById(R.id.btnLike);
        }
    }
}
