package vn.edu.usth.weather;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;
import java.util.List;


public class weather_activity extends AppCompatActivity {

    private ViewPager viewPager;
    private weather_adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather_activity);

        viewPager = findViewById(R.id.view_pager);
        adapter = new weather_adapter(getSupportFragmentManager(), createFragments());
        viewPager.setAdapter(adapter);
    }

    private List<Fragment> createFragments() {
        List<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            fragments.add(new weather_and_forecast_fragment());
        }
        return fragments;
    }
}