package com.edwinacubillos.firebaseapplication


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_delete.view.*

/**
 * A simple [Fragment] subclass.
 */
class DeleteFragment : Fragment() {

    val database = FirebaseDatabase.getInstance()
    val myRef = database.getReference("usuarios")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_delete, container, false)

        root.bDelete.setOnClickListener {

            var cedula = root.eCedula.text.toString()
            var msg=""
            var opt = myRef.child(cedula).removeValue()
                .addOnCanceledListener { msg="Cancelado por el usuario" }
                .addOnCompleteListener { msg="Usuario no encontrado"}
                .addOnFailureListener { msg="falló" }

            Toast.makeText(activity?.applicationContext,msg,Toast.LENGTH_SHORT).show()
        }
        return root

    }


}
