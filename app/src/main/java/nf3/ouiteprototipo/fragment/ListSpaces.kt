package nf3.ouiteprototipo.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.SpacesBinding
import nf3.ouiteprototipo.model.Space
import nf3.ouiteprototipo.recycler.AdapterSpace
import nf3.ouiteprototipo.room.AppDatabase

class ListSpaces: Fragment(R.layout.spaces) {

    private val adaptado by lazy {
        context?.let {
            val db = AppDatabase.instancia(it)
            AdapterSpace(it, lista = db.spaceDao().getAll())
        }?: throw IllegalArgumentException("Contexto Invalido ")
    }
    private lateinit var binding: SpacesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = SpacesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = view.findNavController()

        binding.listaSpace.run {

            adaptado.eventSpace = object : AdapterSpace.EventSpace{
                override fun pressiona(space: Space) {
                    val args = Bundle().apply {
                        putString("name", space.nomeId)
                        putString("tipo", "Space")
                    }
                    controller.navigate(R.id.cont_cardDetalhes_frament,args)
                }
                override fun clica(space: Space) {
                    val args = Bundle().apply {
                        putString("id", space.nomeId)
                        putString("caminho", space.caminho)
                    }
                    controller.navigate(R.id.cont_pesquisaEscopo_fragment, args)
                }
            }

            this.adapter = adaptado
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false )
        }

    }
}