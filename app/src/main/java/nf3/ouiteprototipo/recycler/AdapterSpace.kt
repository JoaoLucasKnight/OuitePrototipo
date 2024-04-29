package nf3.ouiteprototipo.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.CardDefautBinding
import nf3.ouiteprototipo.model.Space

class AdapterSpace(
    private val context: Context,
    lista: List<Space>,
    var eventSpace: Eventos<Space> =
        object :Eventos<Space>{
            override fun pressiona(space: Space){
            }
            override fun clica(space: Space){
            }
        }
): RecyclerView.Adapter<AdapterSpace.ViewHolder>() {

    private val lista = lista.toMutableList()

    inner class ViewHolder(

        private val binding: CardDefautBinding
    ): RecyclerView.ViewHolder(binding.root){

        private lateinit var space: Space
        init {
            binding.root.setOnLongClickListener {
                space.let { eventSpace.pressiona(it) }
                true
            }
            binding.root.setOnClickListener{
                space.let { eventSpace.clica(it) }
            }
        }

        fun vincula(space: Space){
            binding.cardDefautIcon.setImageResource(R.drawable.icon_space)
            this.space = space
            val nome = binding.cardDefautNomeId
            nome.text = space.nomeId
            val caminho = binding.cardDefautCaminho
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