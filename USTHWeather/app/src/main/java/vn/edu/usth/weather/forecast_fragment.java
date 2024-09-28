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
        layout.setBackgroundColor(Color.parseColor("#FFBBDEFB"));

        String[] days = {"Mon", "Tue", "Wed", "Thu", "Fri"};
        int[] icons = {
                R.drawable.weather_icon,
                R.drawable.sunny_icon,
                R.drawable.weather_icon,
                R.drawable.cloudy_icon,
                R.drawable.sunny_icon
        };
        for (int i = 0; i < days.length; i++) {
            LinearLayout entryLayout = new LinearLayout(getActivity());
            entryLayout.setOrientation(LinearLayout.HORIZONTAL);
            entryLayout.setGravity(Gravity.CENTER_VERTICAL);
            entryLayout.setPadding(8, 8, 8, 8);

            TextView textView = new TextView(getActivity());
            textView.setText(days[i]);
            textView.setTextSize(18);
            textView.setTextColor(Color.BLACK);

            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(icons[i]);

            LinearLayout.LayoutParams imageParams = new LinearLayout.LayoutParams(300, 300);
            imageParams.setMargins(8, 0, 0, 0);
            imageView.setLayoutParams(imageParams);

            entryLayout.addView(textView);
            entryLayout.addView(imageView);

            layout.addView(entryLayout);
        }
        return layout;
    }
}