package ramirez.eduardo.peliculas

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.peliculas_view.view.*

class MainActivity : AppCompatActivity() {
var listaPeliculas = ArrayList<Pelicula>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        crearPelicula()
        var adaptador = AdaptadorPelicula(this, listaPeliculas)
        listView.adapter = adaptador
    }
    fun crearPelicula(){
        var peli = Pelicula("Spider-man: into the Spiderverse.", imagen = R.drawable.spiderman)
        var peli2 = Pelicula("Avengers: Endgame", imagen = R.drawable.endgame)
        var peli3 = Pelicula("IT", imagen = R.drawable.it)
        var peli4 = Pelicula("Glass", imagen = R.drawable.glass)
        var peli5 = Pelicula("Pet Sematary.", imagen = R.drawable.pet_sematary)

        // Agrega las pelìculas a la lista
        listaPeliculas?.add(peli)
        listaPeliculas?.add(peli2)
        listaPeliculas?.add(peli3)
        listaPeliculas?.add(peli4)
        listaPeliculas?.add(peli5)
    }
private class AdaptadorPelicula:BaseAdapter{
    var context : Context? = null
    var peliculas : ArrayList<Pelicula>? = null
    constructor(context:Context, peliculas: ArrayList<Pelicula>){
        this.context = context
        this.peliculas = peliculas
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var layout = LayoutInflater.from(context)
        var vista = layout?.inflate(R.layout.peliculas_view, null)!!
        var pel = peliculas!![position]
        if(vista != null){
            vista.tv_nombre.text = pel.nombre
            vista.imageView.setImageResource(pel.imagen)
        }
        return vista
    }

    override fun getItem(position: Int): Any {
        return peliculas?.get(position) ?: "Error"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return peliculas?.size ?:0
    }

}

}
