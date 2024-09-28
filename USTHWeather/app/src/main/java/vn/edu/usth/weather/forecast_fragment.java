package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class forecast_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        String[] conditions = {"Rain", "Scattered Showers", "Partly Cloudy", "Partly Cloudy", "Sunny"};
        String[] temperatures = {"12°C - 17°C", "8°C - 16°C", "7°C - 13°C", "7°C - 13°C", "7°C - 12°C"};
        int[] icons = {
                R.drawable.cloudy_icon,
                R.drawable.weather_icon,
                R.drawable.sunny_icon,
                R.drawable.weather_icon,
                R.drawable.sunny_icon
        };

        for (int i = 0; i < days.length; i++) {
            LinearLayout entryLayout = new LinearLayout(getActivity());
            entryLayout.setOrientation(LinearLayout.HORIZONTAL);
            entryLayout.setGravity(Gravity.CENTER_VERTICAL);
            entryLayout.setPadding(8, 8, 8, 8);

            TextView dayTextView = new TextView(getActivity());
            dayTextView.setText(days[i]);
            dayTextView.setTextSize(16);
            dayTextView.setTextColor(Color.BLACK);

            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(icons[i]);
            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(100, 100);
            imageParams.setMargins(16, 0, 16, 0);
            imageView.setLayoutParams(imageParams);

            TextView conditionTextView = new TextView(getActivity());
            conditionTextView.setText(conditions[i]);
            conditionTextView.setTextSize(16);
            conditionTextView.setTextColor(Color.BLACK);

            TextView tempTextView = new TextView(getActivity());
            tempTextView.setText(temperatures[i]);
            tempTextView.setTextSize(16);
            tempTextView.setTextColor(Color.BLACK);

            entryLayout.addView(dayTextView);
            entryLayout.addView(imageView);
            entryLayout.addView(conditionTextView);
            entryLayout.addView(tempTextView);

            layout.addView(entryLayout);
        }

        return layout;
    }
}