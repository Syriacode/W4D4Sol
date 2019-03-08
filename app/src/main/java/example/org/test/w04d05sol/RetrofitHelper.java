package example.org.test.w04d05sol;

import example.org.test.w04d05sol.model.photo.PhotoResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitHelper {
private static OkHttpClient getOkHttpClientWithInterceptor(){
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

    }

    private static Retrofit getRetrofit(){
    return new Retrofit
            .Builder()
            .baseUrl(UrlConstants.BASE_URL)
            .client(getOkHttpClientWithInterceptor())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();
    }

    private ObservableInterface createPhotoResponseInterface(){
    return getRetrofit().create(ObservableInterface.class);
    }

    public interface ObservableInterface {
        @GET(UrlConstants.PATH_API)
        Observable<PhotoResponse> getUserResponseObservable(
                @Query(UrlConstants.QUERY_RESULTS) String numOfResultsDesired,
                @Query(UrlConstants.QUERY_GENDER) String requestedGender);
    }
}
