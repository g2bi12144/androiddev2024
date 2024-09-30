package vn.edu.usth.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import java.util.List;

public class weather_and_forecast_fragment extends Fragment {

    public weather_and_forecast_fragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.weather_and_forecast_fragment, container, false);

        if (savedInstanceState == null) {
            getChildFragmentManager().beginTransaction()
                    .add(R.id.weather_container, new weather_fragment())
                    .add(R.id.forecast_container, new forecast_fragment())
                    .commit();
        }

        return view;
    }
}