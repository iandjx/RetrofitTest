package com.feyzian.mohammad.retrofittest.api;

import com.feyzian.mohammad.retrofittest.model.Basic;
import com.feyzian.mohammad.retrofittest.model.Image;

import java.util.ArrayList;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface Imgur {

    String IMGUR_BASE_URL = "https://api.imgur.com";
    String IMGUR_CLIENT_ID = "ba2885da578e8b9";
    String AUTHORIZATION_URL = "https://api.imgur.com/oauth2/authorize?client_id=" +
            IMGUR_CLIENT_ID + "&response_type=token";
    String REDIRECT_URI = "https://mohammadretrofittest:99";

    interface Auth {
        @GET("3/account/{username}/images/{page}")
        Call<Basic<ArrayList<Image>>> images(@Path("username") String username,
                                             @Path("page") int page);

        // binary data
        @Multipart
        @POST("3/upload")
        Call<Basic<Image>> uploadImage(@Part("image") RequestBody image);
    }

    interface Anon {
        @Multipart
        @POST("3/upload")
        Call<Basic<Image>> uploadImage(@Part("image") RequestBody image);
    }
}
