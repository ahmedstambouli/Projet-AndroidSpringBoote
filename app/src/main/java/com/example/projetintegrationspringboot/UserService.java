package com.example.projetintegrationspringboot;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {


    @POST("login")
 Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);
    //@POST("register")
    //Call<RegisterResponse>UserRegister(@Body RegisterRequest RegisterRequest);

}
