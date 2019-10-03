package riflocike.co.kr.androidtesttdd.network.util;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface NetworkInterface {
    @GET("/user/login")
    public Call<NetworkModel> get_userLogin(@Query("id") String id, @Query("password") String password);

    @FormUrlEncoded
    @POST("/user/login")
    public Call<NetworkModel> post_userLogin(@Field("id") String id, @Field("password") String password);
}