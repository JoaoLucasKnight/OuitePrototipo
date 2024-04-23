package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.EscopoBinding
import nf3.ouiteprototipo.model.Space
import nf3.ouiteprototipo.recycler.AdapterEscopo

import nf3.ouiteprototipo.room.AppDatabase

class Escopo: Fragment(R.layout.escopo){



    private val adaptado by lazy {
        context?.let {
            val db = AppDatabase.instancia(it)
            val id: String = arguments?.getString("id")?: ""
            AdapterEscopo(it,
                spaces = db.spaceDao().getPai(id),
                boxes = db.boxDao().getPai(id),
                artifacts = db.artifactDao().getPai(id))
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
        val controller = findNavController()
        val caminho: String = arguments?.getString("caminho")?: ""
        val caminhoPesquisa = "$caminho>"
        binding.titleCaminho.text = caminhoPesquisa


        binding.recyclerViewEscopo.run {
            this.adapter = adaptado
            adaptado.quandoPressiona = object : AdapterEscopo.QuandoPressiona{
                override fun pressiona(space: Space) {
                    val args = Bundle().apply {
                        putString("name", space.nomeId)
                    }
                    controller.navigate(R.id.cont_cardDetalhes_frament,args)
                }
            }
            adaptado.quandoClica = object :AdapterEscopo.QuandoClica {
                override fun clica(space: Space) {
                    val args = Bundle().apply {
                        putString("id", space.nomeId)
                        putString("caminho", space.caminho)
                    }
                    controller.navigate(R.id.cont_pesquisaEscopo_fragment, args)
                }
            }
            layoutManager = GridLayoutManager(context, 2)
        }
    }
}