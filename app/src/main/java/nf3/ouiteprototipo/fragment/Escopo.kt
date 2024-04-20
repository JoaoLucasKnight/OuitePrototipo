package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.EscopoBinding
import nf3.ouiteprototipo.databinding.SpacesBinding
import nf3.ouiteprototipo.recycler.AdapterEscopo
import nf3.ouiteprototipo.room.AppDatabase

class Escopo: Fragment(R.layout.escopo){

    private val adaptado by lazy {
        context?.let {
            val db = AppDatabase.instancia(it)
            AdapterEscopo(it, lista = db.spaceDao().getAll())
        }?: throw IllegalArgumentException("Contexto Invalido ")
    }
    private lateinit var binding: EscopoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EscopoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewEscopo.run {
            this.adapter = adaptado
            layoutManager = GridLayoutManager(context, 2)
        }
    }
}