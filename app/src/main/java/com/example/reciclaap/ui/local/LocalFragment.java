package com.example.reciclaap.ui.local;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.reciclaap.R;
import com.example.reciclaap.modelo.Local;
import com.google.android.material.textfield.TextInputEditText;

public class LocalFragment extends Fragment{

    private LocalViewModel vm;
    private  TextInputEditText etCuilCuit;
    private  TextInputEditText etNombre;
    private  TextInputEditText etTelefono;
    private  TextInputEditText etDireccion;
    private  TextInputEditText etHorarios;
    private  TextInputEditText etRubro;
    private  CheckBox cbestado;
    private  ImageView imagen;
    private Local localActual=null;

    public LocalFragment(TextInputEditText etCuilCuit, TextInputEditText etNombre, TextInputEditText etTelefono, TextInputEditText etDireccion, TextInputEditText etHorarios, TextInputEditText etRubro, CheckBox cbestado, ImageView imagen) {
        this.etCuilCuit = etCuilCuit;
        this.etNombre = etNombre;
        this.etTelefono = etTelefono;
        this.etDireccion = etDireccion;
        this.etHorarios = etHorarios;
        this.etRubro = etRubro;
        this.cbestado = cbestado;
        this.imagen = imagen;

    }


    public LocalFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View root = inflater.inflate(R.layout.fragment_local, container, false);
        inicializar(root, savedInstanceState);
        return root;
    }

    private void inicializar(View view, Bundle bundle) {

        etCuilCuit=view.findViewById(R.id.etCuilCuit);
        etNombre=view.findViewById(R.id.etNombre);
        etTelefono=view.findViewById(R.id.etTelefono);
        etDireccion=view.findViewById(R.id.etDireccion2);
        etHorarios=view.findViewById(R.id.etHorarios);
        etRubro=view.findViewById(R.id.etRubro);
        cbestado=view.findViewById(R.id.cbEstado);

        final ImageView imagen= (ImageView) view.findViewById(R.id.imagen);

        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication()).create(LocalViewModel.class);
        vm.getLocalMutable().observe(getViewLifecycleOwner(), new Observer<Local>() {
            @Override
            public void onChanged(Local local) {
                etCuilCuit.setText(local.getCuilCuil());
                etNombre.setText(local.getNombre());
                etTelefono.setText(local.getTelefono());
                etDireccion.setText(local.getDireccion());
                etHorarios.setText(local.getHorarios());
                etRubro.setText(local.getRubro());
                cbestado.setChecked(local.getEstado());
                //imagen.setImageResource(R.drawable.casa1);

                localActual=local;
            }
        });

        vm.cargarLocal(getArguments());


    }

}
