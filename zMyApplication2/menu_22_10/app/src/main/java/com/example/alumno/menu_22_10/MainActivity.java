package com.example.alumno.menu_22_10;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getSupportActionBar();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Titulo!");
        actionBar.setDisplayHomeAsUpEnabled(true);

        WebView wv=(WebView)findViewById(R.id.webView); //obtengo el ID del q esta en la pantalla
        WebSettings ws = wv.getSettings();
        ws.setJavaScriptEnabled(true); //le habilito usar JavaScript
        //wv.loadUrl("http://www.google.com.ar"); //le indico la url para cargar
        wv.loadUrl("file:///android_asset/index.html");

        //WebView wv=(WebView)findViewById(R.id.webView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu); //transforma el xml   representa el menu en un objeto Menu

        SearchView sv = (SearchView)menu.findItem(R.id.campo_buscar).getActionView();
        sv.setOnQueryTextListener(this); //le digo quien va a escuchar el evento


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId(); //obtengo el id del item seleccionado del menu

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) { //si el item clickeado es XXX
            Toast t = Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_LONG); //LENGTH_LONG= duracion,
            t.show(); //muestro el mensaje : "Settings"
            return true;
        }
        else if(android.R.id.home == id) {
            this.finish(); //si es el boton de la derecha el q dice Home q haga...
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //cuando se apreto buscar
        Log.d("Submit: ", query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //este metodo se llama x cada caracter q se precione en el buscar
        Log.d("Change: ", newText);
        return false;
    }
}
