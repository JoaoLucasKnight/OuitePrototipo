package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.SearchBinding
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.recycler.AdapterArtifact
import nf3.ouiteprototipo.recycler.AdapterSpace
import nf3.ouiteprototipo.recycler.Eventos
import nf3.ouiteprototipo.room.AppDatabase
import java.util.Locale

class Pesquisar: Fragment(R.layout.search) {


    private lateinit var binding: SearchBinding
    private lateinit var lista: List<Artifact>
    private lateinit var db: AppDatabase
    private lateinit var adaptado: AdapterArtifact


    private val Cont by lazy {
        context?.let {it}?: throw IllegalArgumentException("Contexto Invalido ")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchBinding.inflate(inflater, container, false)

        db = AppDatabase.instancia(Cont)
        confiReCyclerView()
        configSearch()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun confiReCyclerView(){
        binding.searchLista.run {
            lista = listOf()
            adaptado = AdapterArtifact(Cont, lista)
            adaptado.events = object : Eventos<Artifact>{
                override fun clica(item: Artifact) {
                    val args = Bundle().apply{
                        putString("id", item.nomeId)
                    }
                    findNavController().navigate(R.id.cont_ArtifactDetalhes_fragment, args)
                }

                override fun pressiona(item: Artifact) {

                }
            }
            adapter = adaptado
            layoutManager = LinearLayoutManager(Cont)
        }
    }

    private fun configSearch(){
        binding.searchEscopo.setOnQueryTextListener(object : SearchView.OnQueryTextListener{

            override fun onQueryTextChange(newQuery: String): Boolean {
                binding.searchLista.visibility = View.VISIBLE
                filtro(newQuery)
                return true
            }
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }
        })
        binding.searchEscopo.setOnCloseListener{
            binding.searchLista.visibility = View.GONE
            true
        }

    }

    private fun filtro(busca: String){
        val list: MutableList<Artifact> = mutableListOf()
        if (busca != null){
            lista = db.artifactDao().getAll()
            for(i in lista){
                if (i.nomeId.lowercase(Locale.ROOT).contains(busca)){
                    list.add(i)
                }
            }
            if (list.isEmpty()){
                list.clear() }
            adaptado.atualiza(list)

        }
    }

}
