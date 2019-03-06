package ramirez.eduardo.peliculas

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detalle_pelicula.view.*
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
        var peli = Pelicula("Spider-man: into the Spiderverse.",
            "Teen Miles Morales becomes Spider-Man of his reality, crossing his path with five counterparts from other dimensions to stop a threat for all realities.",
            imagen = R.drawable.spiderman)
        var peli2 = Pelicula("Avengers: Endgame",
            "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to undo Thanos' actions and restore order to the universe.",
            imagen = R.drawable.endgame)
        var peli3 = Pelicula("IT",
            "In the summer of 1989, a group of bullied kids band together to destroy a shape-shifting monster, which disguises itself as a clown and preys on the children of Derry, their small Maine town.",
            imagen = R.drawable.it)
        var peli4 = Pelicula("Glass",
            "Security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities.",
            imagen = R.drawable.glass)
        var peli5 = Pelicula("Pet Sematary.",
            "Louis Creed, his wife Rachel and their two children Gage and Ellie move to a rural home where they are welcomed and enlightened about the eerie 'Pet Sematary' located nearby. After the tragedy of their cat being killed by a truck, Louis resorts to burying it in the mysterious pet cemetery, which is definitely not as it seems, as it proves to the Creeds that sometimes, dead is better.",
            imagen = R.drawable.pet_sematary)

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
            vista.tv_desc.text =pel.descripcion
        }
        vista.setOnClickListener {
            val intent = Intent(this.context, DetallePelicula::class.java)
            intent.putExtra("nombreP", pel.nombre)
            intent.putExtra("descripcionP", pel.descripcion)
            intent.putExtra("imagenP", pel.imagen)
            context!!.startActivity(intent)
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
