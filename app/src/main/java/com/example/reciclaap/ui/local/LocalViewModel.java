package com.example.reciclaap.ui.local;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.reciclaap.modelo.Local;
import com.example.reciclaap.request.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class LocalViewModel extends AndroidViewModel {
    private MutableLiveData<Local> localMutable;
    private Context context;
    private MutableLiveData<String> error;

    public LocalViewModel(@NonNull Application application) {
        super(application);
        context=application.getApplicationContext();
    }

    public LiveData<Local> getLocalMutable() {

        if(localMutable== null)
        {
            localMutable= new MutableLiveData<>();
        }
        return localMutable;
    }
    public LiveData<String> getError() {
        if(error == null)
        {
            error = new MutableLiveData<>();
        }
        return error;
    }
    public void cargarLocal(Bundle bundle)
    {
        Local local= (Local) bundle.getSerializable("local");
        this.localMutable.setValue(local);

    }

    public void editarLocal(Local inmu)
    {
        Call<Local> inmueble= ApiClient.getMyApiInterface().EditarLocal(inmu.getId(),ApiClient.obtenerToken(context));
        inmueble.enqueue(new Callback<Local>() {
            @Override
            public void onResponse(Call<Local> call, Response<Local> response) {

                if(response.isSuccessful()){
                    localMutable.setValue(response.body());
                }
                else {
                    error.setValue("No existen inmuebles");
                }
            }

            @Override
            public void onFailure(Call<Local> call, Throwable t) {

                Toast.makeText(context,"Ha ocurrido un error",Toast.LENGTH_LONG).show();
            }
        });


    }

}
