package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;
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

        TextView textView = new TextView(getActivity());
        textView.setText("Thursday");
        textView.setTextSize(24);
        textView.setTextColor(Color.BLACK);

        ImageView imageView = new ImageView(getActivity());
        imageView.setImageResource(R.drawable.weather_icon); // Replace with your icon name

        layout.addView(textView);
        layout.addView(imageView);

        return layout;
    }
}