package com.example.tazabilim;

import android.os.Bundle;
import android.content.Context;
import android.widget.ListView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class ArticlesActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Article> articles;
    private ArticleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        Toolbar toolbar = findViewById(R.id.ToolbarArticle);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Articles");

        listView = findViewById(R.id.LvArticles);
        articles = new ArrayList<>();
        adapter = new ArticleAdapter(this, articles);

        // Добавление статей с локальными изображениями
        articles.add(new Article("The Impact of Artificial Intelligence", "Artificial Intelligence (AI) is revolutionizing multiple sectors, reshaping the way we interact with technology and each other. From self-driving cars to personalized healthcare, AI's implications are profound. However, as AI continues to evolve, it also raises significant ethical and privacy concerns. This article explores how AI is transforming -industries and the challenges that lie ahead.", R.drawable.ai));
        articles.add(new Article("The Future of Renewable Energy", "Renewable energy sources such as solar and wind are becoming increasingly important in the global energy landscape. With climate change driving the urgent need for cleaner energy solutions, this article examines the latest advancements in renewable technologies, their economic impact, and the potential they hold for achieving a sustainable future.", R.drawable.energy));
        articles.add(new Article("Exploring the Depths of the Ocean", "The ocean covers more than 70% of the Earth's surface, yet remains one of the least explored areas. This article delves into recent discoveries in marine biology and the technology enabling these breakthroughs. From unknown species to underwater drones, we explore the mysteries of the deep sea and its importance to biodiversity conservation.", R.drawable.ocean));
        articles.add(new Article("Modern Database Technologies", "In the digital age, databases are more crucial than ever. They not only store information but also provide crucial insights that can drive business strategy. This article explores modern database technologies including NoSQL, NewSQL, and cloud databases, explaining their advantages over traditional relational database systems. Learn about the use cases for each type and how they are transforming the data management landscape.", R.drawable.data));
        articles.add(new Article("Innovations in Android Development", "Android development has evolved significantly since its inception. This article delves into the latest innovations in Android development, including Kotlin and Jetpack, Google's suite of tools and libraries that help developers write high-quality apps faster. Explore how Android developers can leverage these advancements to enhance application performance and user experience.", R.drawable.droid));
        articles.add(new Article("Trends in iOS Development", "As Apple's iOS continues to dominate the market, staying abreast of the latest trends is crucial for developers. This article covers the new features of iOS 15, the importance of Swift in modern iOS development, and the impact of Apple's privacy policies on app development. Discover how these trends are shaping the future of app development for Apple devices.", R.drawable.ios));
        listView.setAdapter(adapter);
    }

    private static class Article {
        private String title;
        private String content;
        private int imageResId;

        public Article(String title, String content, int imageResId) {
            this.title = title;
            this.content = content;
            this.imageResId = imageResId;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }

        public int getImageResId() {
            return imageResId;
        }
    }

    private class ArticleAdapter extends ArrayAdapter<Article> {
        public ArticleAdapter(Context context, List<Article> articles) {
            super(context, 0, articles);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_article_card, parent, false);
            }

            Article article = getItem(position);
            TextView titleView = convertView.findViewById(R.id.articleTitle);
            TextView contentView = convertView.findViewById(R.id.articleContent);
            ImageView imageView = convertView.findViewById(R.id.articleImage);

            titleView.setText(article.getTitle());
            contentView.setText(article.getContent());
            imageView.setImageResource(article.getImageResId());

            return convertView;
        }
    }
}