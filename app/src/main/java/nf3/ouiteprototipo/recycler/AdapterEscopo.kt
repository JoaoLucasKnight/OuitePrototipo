package nf3.ouiteprototipo.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nf3.ouiteprototipo.databinding.CardDefautBinding
import nf3.ouiteprototipo.model.Space

class AdapterEscopo(
    private val context: Context,
    lista: List<Space>,
    var quandoclica: Quandoclica =
        object :Quandoclica{
            override fun click(space: Space){
            }
        }
): RecyclerView.Adapter<AdapterEscopo.ViewHolder>() {

    private val lista = lista.toMutableList()
    interface Quandoclica{
        fun click(space: Space)
    }
    inner class ViewHolder(
        private val binding: CardDefautBinding
    ): RecyclerView.ViewHolder(binding.root){

        private lateinit var space: Space
        init {
            binding.root.setOnLongClickListener {
                space.let { quandoclica.click(it) }
                true
            }
        }
        fun vincula(space: Space){
            this.space = space
            val nome = binding.cardDefaultNome
            nome.text = space.nomeId
            val caminho = binding.cardDefaultCaminho
            caminho.text = space.caminho
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CardDefautBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val space = lista[position]
        holder.vincula(space)
    }
    override fun getItemCount(): Int = lista.size
}