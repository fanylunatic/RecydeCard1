package mx.edu.utng.recydecard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.AbsListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //declara Recycler y el Adapter
    RecyclerView recyclerUsuarios;
    UsuarioAdaptador usuarioAdaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarElementos();
    }

    private void inicializarElementos() {
        //se enlaza con la vista
        recyclerUsuarios = findViewById(R.id.recycler);
        recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));
        List<Usuario> usuarioList = new ArrayList<>(); //estructura para los datos

        //cargar datos con un ciclo For
        for (int i=0; i<20;i++) {
            usuarioList.add(new Usuario(i,("Nombre.... "+i),"Apellido","alguncorreo@gmail.com", "https://img.freepik.com/vector-gratis/icono-usuario_6091-78.jpg?size=338&ext=jpg"));
            Log.d("msg","se a creado un nuevo usuario "+i);

        }
        usuarioAdaptador = new UsuarioAdaptador(usuarioList,this);
        recyclerUsuarios.setAdapter(usuarioAdaptador);
        Log.d("msg", "El tamaño de la lista es: "+usuarioList.size());
    }

}