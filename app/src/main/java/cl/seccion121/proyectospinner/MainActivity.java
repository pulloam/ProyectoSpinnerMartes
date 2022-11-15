package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilNombre, tilCorreo, tilClave;
    private Button btnAceptar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referenciasWidget();
        eventos();
    }

    private void obtenerDatos(){
        String nombre, correo, clave;
        int edad;

        nombre = tilNombre.getEditText().getText().toString();
        correo = tilCorreo.getEditText().getText().toString();
        clave = tilClave.getEditText().getText().toString();
        //TODO: hacer la parte de la edad, parsear y asignar al usuario
        Usuario usuario = new Usuario(nombre, correo, clave);
        Intent mostrarInfo = new Intent(this, DesplegarInfoActivity.class);
        mostrarInfo.putExtra("el_usuario", usuario);
        startActivity(mostrarInfo);
    }


    //region Referencias y Eventos
    private void referenciasWidget(){
        tilNombre = findViewById(R.id.tilNombre);
        tilCorreo = findViewById(R.id.tilCorreo);
        tilClave = findViewById(R.id.tilClave);
        btnAceptar = findViewById(R.id.btnAceptar);
        btnCancelar = findViewById(R.id.btnCancelar);
    }

    private void eventos(){
        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
    //endregion

}