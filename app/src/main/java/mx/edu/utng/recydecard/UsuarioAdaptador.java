package mx.edu.utng.recydecard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.nio.InvalidMarkException;
import java.util.List;

public class UsuarioAdaptador extends  RecyclerView.Adapter<UsuarioAdaptador.ViewHolder>{
    //declarar una lista necesaria como estructura de datos para el conjunto de items
    private List<Usuario> UsuarioList;
    private Context context; //se decalra un contexto para las activitys necesarios


    //construcctor

    public UsuarioAdaptador(List<Usuario> usuarioList, Context context) {
        UsuarioList = usuarioList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_usuario, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            //detalle de la tarjeta (holder)
        holder.tuNombre.setText(UsuarioList.get(position).getNombre());
        holder.tuEmail.setText(UsuarioList.get(position).getEmail());

        //utilizar una libreria denominada Glide para cargar imagenes de internet
        Glide.with(context).load(UsuarioList.get(position).getFoto()).circleCrop().into(holder.imgFoto);




    }

    @Override
    public int getItemCount() {
        return UsuarioList.size();
    }


    //Clase interna para cada ViewHolder vita por tarjeta (card)
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //Dleclarar cada uno de los elemeptos visuales para enlazarlos
        private ImageView imgFoto;
        private TextView tuNombre;
        private TextView tuEmail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Enlazar con la vista xml
            imgFoto = itemView.findViewById(R.id.img_foto);
            tuNombre= itemView.findViewById(R.id.tu_nombre);
            tuEmail= itemView.findViewById(R.id.tu_email);
        }
    }
}
