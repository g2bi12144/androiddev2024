package vn.edu.usth.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class weather_fragment extends Fragment {

    private TextView weatherTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        weatherTextView = new TextView(getActivity());
        layout.addView(weatherTextView);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://api.openweathermap.org/data/2.5/weather?q=Hanoi&appid=784dfc7ae888888888c6f838a33b3691\n";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> displayWeather(response),
                error -> weatherTextView.setText("Failed to retrieve data"));

        queue.add(jsonObjectRequest);

        return layout;
    }

    private void displayWeather(JSONObject response) {
        String weatherInfo = response.toString();
        weatherTextView.setText(weatherInfo);
    }
}