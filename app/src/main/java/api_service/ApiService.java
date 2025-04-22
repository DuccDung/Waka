package api_service;


import com.example.waka.Model.ApiResponse;
import com.example.waka.Model.Comment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    String BASE_URL = "https://61a2-2405-4802-1844-ce20-39ba-7da0-5b32-3b6a.ngrok-free.app/";
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(SSLUtils.getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    ApiService apiWeather = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(SSLUtils.getUnsafeOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    // Static method to get the base domain
    static String getBaseDomain() {
        return BASE_URL;
    }

    @GET("api/Book/GetCommentByChapterId")
    Call<ApiResponse<Comment>> GetCommentByChapterId(@Query("chapterId") int chapterId);
    @GET("api/Book/GetCountCommentChild")
    Call<ApiResponse<Integer>> GetCountCommentChildByParentId(@Query("CommentId") int ParentId);

    @GET("api/Book/GetCommentChildOfParent")
    Call<ApiResponse<Comment>> GetCommentChildByParentId(@Query("parentId") int ParentId);
    @POST("api/Book/PostCommentChapter")
    Call<ApiResponse<Void>> PostCommentChapter(@Query("ChapterId") int chapterId, @Query("UserId") String userId, @Query("ParentId") Integer parentId, @Query("Content") String content);

}
