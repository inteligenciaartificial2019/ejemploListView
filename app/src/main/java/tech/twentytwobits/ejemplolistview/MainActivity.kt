package tech.twentytwobits.ejemplolistview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Listado de frutas
        // Data source
        val frutas = ArrayList<Fruta>()

        // Llenar la lista de frutas
        frutas.add(Fruta("Durazno", R.drawable.durazno))
        frutas.add(Fruta("Manzana", R.drawable.manzana))
        frutas.add(Fruta("Plátano", R.drawable.platano))
        frutas.add(Fruta("Sandía", R.drawable.sandia))

        // Adapter
        val adapter = CustomAdapter(this, frutas)

        // Crear la variable que se encarga de manejar el widget lista
        // Adapter View
        val laLista = findViewById<ListView>(R.id.lvLista)
        laLista.adapter = adapter

        // Obtener los datos de cada fruta cuando se hace click sobre la lista
        laLista.onItemClickListener = AdapterView.OnItemClickListener {
            parent, view, position, id ->
                Toast.makeText(this, frutas.get(position).nombre, Toast.LENGTH_SHORT).show()
        }
    }
}
