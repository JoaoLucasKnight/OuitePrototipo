package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.HistoricoBinding
import nf3.ouiteprototipo.model.ManipulaHistorico
import nf3.ouiteprototipo.recycler.AdapterHistorico

class ListHistory: Fragment(R.layout.historico) {
    private val adaptado by lazy {
        context?.let {
            AdapterHistorico(it, lista = ManipulaHistorico.getHistorico())
        }?: throw IllegalArgumentException("Contexto Invalido ")
    }
    private lateinit var binding: HistoricoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = HistoricoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.listaHistorico.run {
            this.adapter = adaptado
            layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        }
    }
}