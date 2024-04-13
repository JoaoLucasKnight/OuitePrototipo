package nf3.ouiteprototipo.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nf3.ouiteprototipo.databinding.CardDefautBinding

import nf3.ouiteprototipo.model.Space

class AdapterSpace(
    private val context: Context,
    lista: List<Space>
): RecyclerView.Adapter<AdapterSpace.ViewHolder>() {

    private val lista = lista.toMutableList()

    class ViewHolder(
        private val binding: CardDefautBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun vincula(space: Space){
            val nome = binding.cardDefaultNome
            nome.text = space.nome
            val caminho = binding.cardDefaultCaminho
            caminho.text = space.caminho
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = CardDefautBinding.inflate(inflater, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lugares = lista[position]
        holder.vincula(lugares)

    }

    override fun getItemCount(): Int = lista.size
}