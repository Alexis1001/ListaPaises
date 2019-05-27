package app.listapaises;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    Button accion;
    Button borrar,actualizar;
    ListView simpleList;
    EditText texto;
    TextView textoview;
    String countryList[] = {"India","mexico","peru","brazil"};
    int pocicion[]=new int[1];
    String actualiza="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accion=(Button) findViewById(R.id.Accion);
        borrar=(Button)findViewById(R.id.btn_delate);
        actualizar=(Button)findViewById(R.id.btn_update);
        simpleList= findViewById(R.id.SimpleListView);
        texto=(EditText)findViewById(R.id.Texto);


        final ArrayList<String> lista=new ArrayList <String> (Arrays.asList(countryList));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.acivity_listview, R.id.textoView, lista);

        simpleList.setAdapter(arrayAdapter);
        accion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String perro=String.valueOf(texto.getText());
                simpleList.setAdapter(arrayAdapter);
                lista.add(perro);
                arrayAdapter.notifyDataSetChanged();
                texto.setText(null);
            }
        });


        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                pocicion[0]=position;
                texto.setText(lista.get(pocicion[0]));
                simpleList.getChildAt(pocicion[0]).setBackgroundColor(Color.GRAY);//
                borrar.setVisibility(View.VISIBLE);
                actualizar.setVisibility(View.VISIBLE);
               // simpleList.setVisibility(View.INVISIBLE);
                accion.setVisibility(View.INVISIBLE);

            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualiza=texto.getText().toString();
                lista.remove(pocicion[0]);
                lista.add(pocicion[0],actualiza);
                arrayAdapter.notifyDataSetChanged();
                simpleList.getChildAt(pocicion[0]).setBackgroundColor(Color.TRANSPARENT);//
                //simpleList.setVisibility(View.VISIBLE);
                accion.setVisibility(View.VISIBLE);
                borrar.setVisibility(View.INVISIBLE);
                actualizar.setVisibility(View.INVISIBLE);
                texto.setText("");
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lista.remove(pocicion[0]);
                arrayAdapter.notifyDataSetChanged();
                simpleList.getChildAt(pocicion[0]).setBackgroundColor(Color.TRANSPARENT);//
                //simpleList.setVisibility(View.VISIBLE);
                accion.setVisibility(View.VISIBLE);
                borrar.setVisibility(View.INVISIBLE);
                actualizar.setVisibility(View.INVISIBLE);
                texto.setText("");
            }
        });
    }
}
