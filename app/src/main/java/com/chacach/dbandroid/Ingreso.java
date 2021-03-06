package com.chacach.dbandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Ingreso extends AppCompatActivity {
    EditText Enombre, Eapellido, Eapellido2, Eapellido3, Efrenos, Ecaja, Esuspension;
    Button guardar,buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        Enombre=(EditText)findViewById(R.id.nombre);
        Eapellido=(EditText)findViewById(R.id.apellido);
        Eapellido2=(EditText)findViewById(R.id.apellido2);
        Eapellido3=(EditText)findViewById(R.id.apellido3);
        Efrenos = (EditText) findViewById(R.id.frenos);
        Ecaja = (EditText) findViewById(R.id.caja);
        Esuspension = (EditText) findViewById(R.id.suspension);

        guardar=(Button)findViewById(R.id.guardar);
        buscar=(Button)findViewById(R.id.buscar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db= new DB(getApplicationContext(),null,null,1);
                String nombre = Enombre.getText().toString();
                String apellido = Eapellido.getText().toString();
                String apellido2 = Eapellido2.getText().toString();
                String apellido3= Eapellido3.getText().toString();
                String frenos = Efrenos.getText().toString();
                String caja = Ecaja.getText().toString();
                String suspension = Esuspension.getText().toString();
                String mensaje = db.guardar(nombre, apellido, apellido2, apellido3, frenos, caja, suspension);
                Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_SHORT).show();
            }
        });
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento = new Intent(getApplicationContext(),Buscar_Eliminar_Actualizar.class);
                startActivity(intento);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
