package com.chacach.dbandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class Buscar_Eliminar_Actualizar extends AppCompatActivity {
    EditText Ebuscar,nnombre,napellido;
    TextView nombre, apellido, aleron, motor, frenos, caja, suspension;
    Button Bbuscar,BEliminar,BActualizar,BLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_eliminar_actualizar);
        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        aleron=(TextView)findViewById(R.id.aleron);
        motor=(TextView)findViewById(R.id.motor);
        frenos = (TextView) findViewById(R.id.frenos);
        caja = (TextView) findViewById(R.id.caja);
        suspension = (TextView) findViewById(R.id.suspension);


        Ebuscar = (EditText) findViewById(R.id.Ebuscar);
        Bbuscar = (Button) findViewById(R.id.Bbuscar);




        Bbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DB db = new DB(getApplicationContext(), null, null, 1);
                String buscar = Ebuscar.getText().toString();
                String[] datos;
                datos = db.buscar_reg(buscar);
                nombre.setText(datos[0]);
               apellido.setText(datos[1]);
                aleron.setText(datos[2]);
                motor.setText(datos[3]);
                frenos.setText(datos[4]);
                caja.setText(datos[5]);
                suspension.setText(datos[6]);


                Toast.makeText(getApplicationContext(), datos[7], Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
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
