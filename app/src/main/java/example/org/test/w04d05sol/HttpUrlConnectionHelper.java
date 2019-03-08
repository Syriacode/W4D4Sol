package example.org.test.w04d05sol;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static example.org.test.w04d05sol.UrlConstants.ACTUAL_URL;

public class HttpUrlConnectionHelper {
    public static String getJsonUsingHttpURLConn() throws IOException {
        String jsonReturnString = "";

        URL url= new URL(ACTUAL_URL);
        HttpURLConnection httpURLConnection = null;
        httpURLConnection = (HttpURLConnection)url.openConnection();
        InputStream inputStream = httpURLConnection.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);



    }
}
