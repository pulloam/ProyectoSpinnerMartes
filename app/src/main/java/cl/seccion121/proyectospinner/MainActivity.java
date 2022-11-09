package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    private TextInputLayout tilNombre;
    private Button btnAceptar, btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        referenciasWidget();
        eventos();
    }

    private void obtenerDatos(){
        String nombre = tilNombre.getEditText().getText().toString();
        Intent mostrarInfo = new Intent(this, DesplegarInfoActivity.class);
        mostrarInfo.putExtra("datoNombre", nombre);
        startActivity(mostrarInfo);
    }


    //region Referencias y Eventos
    private void referenciasWidget(){
        tilNombre = findViewById(R.id.tilNombre);
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