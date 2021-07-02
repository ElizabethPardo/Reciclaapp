package com.example.reciclaap.ui.local;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.reciclaap.modelo.Local;
import com.example.reciclaap.request.ApiClient;

import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class LocalesViewModel extends AndroidViewModel {

    private Context context;
    private ArrayAdapter<Local> adapter;
    private MutableLiveData<String> error;
    private MutableLiveData<ArrayList<Local>> localesMutable;

    public LocalesViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<ArrayList<Local>> getLocalesMutable() {

        if(localesMutable== null)
        {
            localesMutable= new MutableLiveData<>();
        }
        return localesMutable;
    }
    public LiveData<String> getError() {
        if(error == null)
        {
            error = new MutableLiveData<>();
        }
        return error;
    }

    public void cargarLocales(){

        Call<ArrayList<Local>>  locales= ApiClient.getMyApiInterface().ListaLocales(ApiClient.obtenerToken(context));
        Log.d("Salida", locales.toString());
        locales.enqueue(new Callback<ArrayList<Local>>() {
            @Override
            public void onResponse(Call<ArrayList<Local>> call, Response<ArrayList<Local>> response) {
                if(response.isSuccessful()){
                    localesMutable.postValue(response.body());
                }
                else {
                    error.setValue("No existen inmuebles");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Local>> call, Throwable t) {

                Toast.makeText(context,"Ha ocurrido un error",Toast.LENGTH_LONG).show();
            }
        });



    }
}
