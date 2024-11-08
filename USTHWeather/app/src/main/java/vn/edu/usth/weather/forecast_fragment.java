package vn.edu.usth.weather;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class forecast_fragment extends Fragment {

    private ImageView logoImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        LinearLayout layout = new LinearLayout(getActivity());
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(16, 16, 16, 16);

        logoImageView = new ImageView(getActivity());
        layout.addView(logoImageView);

        new DownloadImageTask().execute("https://www.usth.edu.vn/uploads/logo.png");

        return layout;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {
            String urlDisplay = urls[0];
            Bitmap logo = null;
            try {
                InputStream in = new java.net.URL(urlDisplay).openStream();
                logo = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return logo;
        }

        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                logoImageView.setImageBitmap(result);
                Toast.makeText(getActivity(), "Logo downloaded", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), "Failed to download logo", Toast.LENGTH_SHORT).show();
            }
        }
    }
}