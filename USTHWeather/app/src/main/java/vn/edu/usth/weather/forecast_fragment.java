package vn.edu.usth.weather;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class forecast_fragment extends Fragment {

    private ImageView logoImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        logoImageView = new ImageView(getActivity());
        layout.addView(logoImageView);

        RequestQueue queue = Volley.newRequestQueue(getActivity());
        String url = "https://www.usth.edu.vn/uploads/logo.png";

        ImageRequest imageRequest = new ImageRequest(url,
                response -> {
                    logoImageView.setImageBitmap(response);
                    Toast.makeText(getActivity(), "Logo downloaded", Toast.LENGTH_SHORT).show();
                },
                0, 0, ImageView.ScaleType.CENTER_CROP, Bitmap.Config.RGB_565,
                error -> Toast.makeText(getActivity(), "Failed to download logo", Toast.LENGTH_SHORT).show());

        queue.add(imageRequest);

        return layout;
    }
}