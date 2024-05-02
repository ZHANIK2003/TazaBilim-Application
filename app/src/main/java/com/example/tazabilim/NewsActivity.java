package com.example.tazabilim;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

public class NewsActivity extends AppCompatActivity {
    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(new NewsPagerAdapter(this));
    }

    private static class NewsItem {
        private String title;
        private String description;
        private int imageResId;

        NewsItem(String title, String description, int imageResId) {
            this.title = title;
            this.description = description;
            this.imageResId = imageResId;
        }

        String getTitle() {
            return title;
        }

        String getDescription() {
            return description;
        }

        int getImageResId() {
            return imageResId;
        }
    }

    private class NewsPagerAdapter extends FragmentStateAdapter {
        private final NewsItem[] items = new NewsItem[]{
                new NewsItem("Technological Innovations in Medicine", "Modern medical technology is leaping boundaries, transforming healthcare delivery across the globe. From robotic surgical systems to advanced biotechnology, these innovations are enhancing precision in diagnostics and treatments. This article explores how cutting-edge technology not only streamlines healthcare operations but also significantly improves patient outcomes by minimizing errors and recovery times.", R.drawable.medicine),
                new NewsItem("The Future of Power: Renewable Energy's Rapid Rise", "As the world shifts towards sustainable living, renewable energy sources like solar and wind power are playing pivotal roles. This shift is driven by the urgent need to reduce carbon footprints and mitigate climate change impacts. This article delves into the latest advancements in renewable energy technologies, highlighting how they are reshaping the global energy landscape and what this means for future generations", R.drawable.renewable),
                new NewsItem("Beyond the Horizon: The Next Frontier in Space Exploration", "Space exploration is entering a new era as private companies join governmental agencies in pushing the boundaries of human potential and technology. From missions to Mars to the commercialization of space flights, this article examines the thrilling prospects of upcoming space ventures. Discover how these bold initiatives are set to redefine our understanding of the universe and what it means to be a multi-planetary species.", R.drawable.cosmos)
        };

        NewsPagerAdapter(AppCompatActivity activity) {
            super(activity);
        }

        @Override
        public Fragment createFragment(int position) {
            NewsItem item = items[position];
            return NewsFragment.newInstance(item.getTitle(), item.getDescription(), item.getImageResId());
        }

        @Override
        public int getItemCount() {
            return items.length;
        }
    }

    public static class NewsFragment extends Fragment {
        private static final String ARG_TITLE = "title";
        private static final String ARG_DESCRIPTION = "description";
        private static final String ARG_IMAGE_RES_ID = "imageResId";

        static NewsFragment newInstance(String title, String description, int imageResId) {
            NewsFragment fragment = new NewsFragment();
            Bundle args = new Bundle();
            args.putString(ARG_TITLE, title);
            args.putString(ARG_DESCRIPTION, description);
            args.putInt(ARG_IMAGE_RES_ID, imageResId);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.item_news, container, false);
            TextView title = view.findViewById(R.id.textViewTitle);
            TextView description = view.findViewById(R.id.textViewDescription);
            ImageView image = view.findViewById(R.id.imageViewNews);

            Bundle args = getArguments();
            if (args != null) {
                title.setText(args.getString(ARG_TITLE));
                description.setText(args.getString(ARG_DESCRIPTION));
                image.setImageResource(args.getInt(ARG_IMAGE_RES_ID));
            }
            return view;
        }
    }
}