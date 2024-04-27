package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.SearchBinding
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.room.AppDatabase

class Pesquisar: Fragment(R.layout.search) {


    private lateinit var binding: SearchBinding
    private lateinit var lista: List<Artifact>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchBinding.inflate(inflater, container, false)

        val search = binding.search as SearchView
        val db = AppDatabase
            .instancia(context ?: throw IllegalArgumentException("Contexto Invalido "))
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener{



            override fun onQueryTextChange(newQuery: String): Boolean {
                // Atualizar a lista de resultados com base na nova consulta
                lista = db.artifactDao().getAll()
                val filtro = lista.filter { item ->
                    item.nomeId == newQuery
                }

                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                findNavController().navigate(R.id.cont_cadastro_fragment)
                return false
            }


        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = AppDatabase
            .instancia(context ?: throw IllegalArgumentException("Contexto Invalido "))


    }

}
