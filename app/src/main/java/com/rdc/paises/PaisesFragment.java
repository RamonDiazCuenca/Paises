package com.rdc.paises;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.rdc.paises.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

public class PaisesFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    ArrayList<Bandera> banderas; /* Hacemos referencia al arraylist banderas, donde se encuentran
                                 las imágenes y sus nombres*/
    List<PlaceholderContent.Pais> pais;

    public PaisesFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static PaisesFragment newInstance(int columnCount) {
        PaisesFragment fragment = new PaisesFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paises_list, container, false);

        // obtener preferencias en una variable llamada prefs
        SharedPreferences prefs = getActivity().getSharedPreferences("com.rdc.paises_preferences", Context.MODE_PRIVATE);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            // asignar a esta variable el valor de la propiedad tipo_visualizacion
            String tipoVisualizacion = prefs.getString("tipo_visualizacion","No hay información");

            if (tipoVisualizacion.equals("listado")) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            }

            // asignar a esta variable el valor almacenado en la propiedad linea
            boolean useDivider = prefs.getBoolean("linea",false);

            if(useDivider){

                //Dibuja una linea divisoria entre elementos
                DividerItemDecoration verticalDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayout.VERTICAL);
                recyclerView.addItemDecoration(verticalDecoration);
            }

            PlaceholderContent placeholderContent = new PlaceholderContent(getResources(),
                    getContext().getPackageName());

            // Inicializamos el arraylist y llamamos al método añadirBanderas
            banderas = new ArrayList<>();
            añadirBanderas();

            pais = new ArrayList<>();
            //PaisRecyclerViewAdapter adapter = new PaisRecyclerViewAdapter(pais,banderas);
            //recyclerView.setAdapter(adapter);

            recyclerView.setAdapter(new PaisRecyclerViewAdapter(PlaceholderContent.PAISES, banderas));
        }
        return view;
    }

    // Método para añadir en el arraylist la imágen de la bandera y su nombre
    private void añadirBanderas() {

        banderas.add(new Bandera(R.drawable.bandera_argentina,"Argentina"));
        banderas.add(new Bandera(R.drawable.bandera_australia,"Australia"));
        banderas.add(new Bandera(R.drawable.bandera_belgica,"Bélgica"));
        banderas.add(new Bandera(R.drawable.bandera_canada,"Canadá"));
        banderas.add(new Bandera(R.drawable.bandera_dinamarca, "Dinamarca"));
        banderas.add(new Bandera(R.drawable.bandera_espana, "España"));
    }
}