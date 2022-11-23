package cl.seccion121.proyectospinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DesplegarInfoActivity extends AppCompatActivity {
    private TextView tvNombre;
    private Button btnVolver;
    private Switch swtHabilitar;
    private Spinner spnNombres;
    private ListView lstUsuarios;

    private String[] losNombres;
    private ArrayList<Usuario> losUsuarios;

    private ArrayAdapter<String> adaptadorNombres;
    private ArrayAdapter<Usuario> adaptadorUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desplegar_info);

        poblarArregloArrayList();
        referencias();
        eventos();

        Usuario usr = (Usuario) getIntent().getExtras().getSerializable("el_usuario");
        String datos = usr.getNombre() + " -> " + usr.getCorreo();

        tvNombre.setText(datos);
    }


    //region Eventos y Referencias
    private void eventos() {
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        spnNombres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DesplegarInfoActivity.this, "Seleccionó " + losNombres[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        lstUsuarios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int indice, long id) {
                Usuario u = losUsuarios.get(indice);
                Log.d("TAG_", "Seleccioón en la lista de usuarios:");
                Log.d("TAG_", "Correo :" + u.getCorreo());
                Log.d("TAG_", "Clave :" + u.getClave());
            }
        });

        lstUsuarios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DesplegarInfoActivity.this, "Desea eliminar a " + losUsuarios.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        swtHabilitar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //btnVolver.setEnabled(isChecked);
                if(isChecked)
                    lstUsuarios.setVisibility(View.VISIBLE);
                else
                    lstUsuarios.setVisibility(View.INVISIBLE);
            }
        });
    }

    private void referencias() {
        tvNombre = findViewById(R.id.tvNombre);
        btnVolver = findViewById(R.id.btnVolver);

        swtHabilitar = findViewById(R.id.swtHabilitar);
        spnNombres = findViewById(R.id.spnNombres);
        lstUsuarios = findViewById(R.id.lstUsuarios);

        swtHabilitar.setChecked(true);

        adaptadorNombres = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, losNombres);
        spnNombres.setAdapter(adaptadorNombres);

        adaptadorUsuarios = new ArrayAdapter<Usuario>(this, android.R.layout.simple_list_item_1, losUsuarios);
        lstUsuarios.setAdapter(adaptadorUsuarios);
    }

    private void poblarArregloArrayList() {
        losNombres = new String[5];
        losUsuarios = new ArrayList<Usuario>();


        losNombres[0] = "Juanito";
        losNombres[1] = "Maria";
        losNombres[2] = "Emilia";
        losNombres[3] = "Valentina";
        losNombres[4] = "Paula";

        for(int x = 0; x <= 10000; ++x){
            Usuario c = new Usuario();
            c.setNombre("Nombre " + x);
            c.setCorreo("correo@" + x + ".cl");
            c.setClave("Clave " + x);
            losUsuarios.add(c);
        }
    }
    //endregion
}