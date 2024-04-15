package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.SpacesBinding
import nf3.ouiteprototipo.model.ManipulaSpace
import nf3.ouiteprototipo.recycler.AdapterSpace

class ListSpaces: Fragment(R.layout.spaces){

    private val adaptado by lazy {
        context?.let {
            AdapterSpace(it, lista = ManipulaSpace.getSpaces())
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
}