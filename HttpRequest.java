import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;

public class HttpRequest{
    public static final String POST_CONTENT_TYPE_FORM_URLENCODED = "application/x-www-form-urlencoded";
    public static final String POST_CONTENT_TYPE_JSON = "application/json";
    private HttpConnectionProvider mConnectionProvider;

    public HttpRequest(HttpConnectionProvider httpconnectionprovider){
        mConnectionProvider = httpconnectionprovider;
    }

    public void sendPost(URL url, String s, ACRAResponse acraresponse){
        sendPost(url, s, acraresponse, "application/x-www-form-urlencoded");
    }

    public void sendPost(URL url, String s, ACRAResponse acraresponse, String s1){
        HttpURLConnection httpurlconnection;
        httpurlconnection = mConnectionProvider.getConnection(url);
        httpurlconnection.setRequestMethod("POST");
        httpurlconnection.setRequestProperty("User-Agent", "Android");
        httpurlconnection.setRequestProperty("Content-Type", s1);
        httpurlconnection.setRequestProperty("Content-Encoding", "gzip");
        httpurlconnection.setDoOutput(true);
        GZIPOutputStream gzipoutputstream = new GZIPOutputStream(httpurlconnection.getOutputStream());
        gzipoutputstream.write(s.getBytes());
        gzipoutputstream.close();
        acraresponse.setStatusCode(httpurlconnection.getResponseCode());
        httpurlconnection.getInputStream().close();
        httpurlconnection.disconnect();
        return;
        Exception exception;
        httpurlconnection.disconnect();
        throw exception;
    }
}
