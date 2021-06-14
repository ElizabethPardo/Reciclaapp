package com.example.reciclaap.request;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.reciclaap.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public class ApiClient {
    private static final String PATH="http://192.168.0.15:45455/Api/";

    public  static  MyApiInterface myApiInterface;

    public static MyApiInterface getMyApiInterface() {

        Gson gson= new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        myApiInterface= retrofit.create(MyApiInterface.class);
        Log.d("salida",retrofit.baseUrl().toString());
        return myApiInterface;

    }

    public interface MyApiInterface {
        @FormUrlEncoded
        @POST("Usuario/login")
        Call<String> Login(@Field("Usuario") String usuario, @Field("Clave") String clave);

        @GET("Usuario")
        Call<Usuario> MiPerfil(@Header("Authorization") String token);
    }

    public  static String obtenerToken(Context context)
    {
        String token;
        SharedPreferences sp=context.getSharedPreferences("datos.dat",0);
        return  sp.getString("Token", "Token no encontrado");


    }

}
