package ramirez.eduardo.peliculas

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.*

class DetallePelicula : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)
        val nombre = intent.getStringExtra("nombreP")
        val descripcion =  intent.getStringExtra("descripcionP")
        val imagen = intent.getIntExtra("imagenP", 1)
        nombrePelicula.setText(nombre)
        descripcionPelicula.setText(descripcion)
        imagenPelicula.setImageResource(imagen)
    }
}
