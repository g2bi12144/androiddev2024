package vn.edu.usth.weather;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.List;

public class weather_activity extends AppCompatActivity {

    private ViewPager viewPager;
    private weather_adapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

        adapter = new weather_adapter(getSupportFragmentManager(), createFragments());
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        setupTabTitles();
    }

    private List<Fragment> createFragments() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new weather_and_forecast_fragment());
        }
        return fragments;
    }

    private void setupTabTitles() {
        tabLayout.getTabAt(0).setText("Hanoi");
        tabLayout.getTabAt(1).setText("Paris");
        tabLayout.getTabAt(2).setText("Toulouse");
    }
}