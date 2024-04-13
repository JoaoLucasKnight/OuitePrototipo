package nf3.ouiteprototipo.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nf3.ouiteprototipo.databinding.CardHistoricoBinding
import nf3.ouiteprototipo.model.Historico

class AdapterHistorico(
    private val context: Context,
    lista: List<Historico>
): RecyclerView.Adapter<AdapterHistorico.ViewHolder>() {

    private val lista = lista.toMutableList()

    class ViewHolder(
        private val binding: CardHistoricoBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun vincula(historico: Historico){
            val title = binding.cardHistoricoTitle
            title.text = historico.titulo
            val caminho = binding.cardHistoricoCaminho
            caminho.text = historico.caminho
            val data = binding.cardDefaultData
            data.text = historico.data
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = CardHistoricoBinding.inflate(inflater,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val historico = lista[position]
        holder.vincula(historico)
    }

    override fun getItemCount(): Int = lista.size
}