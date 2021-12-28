package com.rdc.paises;

import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.navigation.Navigation;

import com.rdc.paises.placeholder.PlaceholderContent.Pais;
import com.rdc.paises.databinding.FragmentPaisBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Pais}.
 * TODO: Replace the implementation with code for your data type.
 */
public class PaisRecyclerViewAdapter extends RecyclerView.Adapter<PaisRecyclerViewAdapter.ViewHolder> {

    private final List<Pais> mValues;
    ArrayList<Bandera> banderas; /* Creamos un arraylist donde insertaremos tanto las banderas como su nombre
                                    en forma de objeto con su clase Bandera*/

    // Colocamos el arraylist en su constructor
    public PaisRecyclerViewAdapter(List<Pais> items, ArrayList<Bandera> banderas) {
        mValues = items;
        this.banderas = banderas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentPaisBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mContentView.setText(mValues.get(position).nombre);

        /* Le decimos que en este id correspondiente tanto al imageview como al textview
        modifique lo que hay por la imagen y texto cogido del arraylist banderas en la posición que le toca*/
        holder.imgbandera.setImageResource(banderas.get(position).getImage());
        holder.nombre.setText(banderas.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        //return mValues.size();
        return banderas.size(); /* retornamos el tamaño del arraylist para saber cuantas cardview
        han de crearse */
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView mContentView;
        public Pais mItem;
        // Instanciamos las vistas que se encuentran en fragment_pais, que corresponde a donde tenemos el cardview
        ImageView imgbandera;
        TextView nombre;

        public ViewHolder(FragmentPaisBinding binding) {
            super(binding.getRoot());
            mContentView = binding.content;
            binding.getRoot().setOnClickListener(this);
            // Las igualamos a sus correspondientes ids
            imgbandera = binding.imgBandera;
            nombre = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }

        @Override
        public void onClick(View v) {

            Bundle args = new Bundle();
            args.putParcelable("pais", mItem);
            args.putString("title", mItem.nombre);

            Navigation.findNavController(v).navigate(R.id.action_paisesFragment_to_detallePaisFragment, args);
        }
    }
}