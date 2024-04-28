package nf3.ouiteprototipo.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nf3.ouiteprototipo.databinding.ItenSearchBinding
import nf3.ouiteprototipo.model.Artifact

class AdapterArtifact(
    private val context: Context,
    lista: List<Artifact>

): RecyclerView.Adapter<AdapterArtifact.ViewHolder>() {
    private val lista = lista.toMutableList()

    class ViewHolder(
        private val binding: ItenSearchBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun vincula(artifact: Artifact){
            val nome = binding.itemSearchNome
            nome.text = artifact.nomeId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItenSearchBinding.inflate(inflater,parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artifact = lista[position]
        holder.vincula(artifact)
    }

    override fun getItemCount(): Int = lista.size

    fun atualiza(lista: MutableList<Artifact>){
        this.lista.clear()
        this.lista.addAll(lista)
        notifyDataSetChanged()
    }
}