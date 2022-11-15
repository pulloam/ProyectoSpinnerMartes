package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DesplegarInfoActivity extends AppCompatActivity {
    private TextView tvNombre;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegar_info);

        referencias();
        eventos();

        Usuario usr = (Usuario) getIntent().getExtras().getSerializable("el_usuario");
        tvNombre.setText(usr.getNombre());
    }


    //region Eventos y Referencias
    private void eventos() {
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void referencias() {
        tvNombre = findViewById(R.id.tvNombre);
        btnVolver = findViewById(R.id.btnVolver);
    }
    //endregion
}