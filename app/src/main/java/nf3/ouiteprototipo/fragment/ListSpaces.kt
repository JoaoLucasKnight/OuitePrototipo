package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.SpacesBinding
import nf3.ouiteprototipo.recycler.AdapterSpace
import nf3.ouiteprototipo.room.AppDatabase
import nf3.ouiteprototipo.room.dao.SpaceDAO

class ListSpaces: Fragment(R.layout.spaces){



    private val adaptado by lazy {
        context?.let {
            it.deleteDatabase("ouite.db")
            val db = AppDatabase.instancia(it)
            AdapterSpace(it, lista = db.spaceDao().getAll())

        }?: throw IllegalArgumentException("Contexto Invalido ")
    }
    private lateinit var binding: SpacesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SpacesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listaSpace.run {
            this.adapter = adaptado
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
        }
    }

    fun pegaBancoDeDados(){
        parentFragmentManager
    }
}