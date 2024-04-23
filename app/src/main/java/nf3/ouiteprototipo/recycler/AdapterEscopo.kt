package nf3.ouiteprototipo.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.CardDefautBinding
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.model.Box
import nf3.ouiteprototipo.model.Space

class AdapterEscopo(
    private val context: Context,
    spaces: List<Space>,
    boxes : List<Box>,
    artifacts: List<Artifact>,

    var quandoPressiona: QuandoPressiona =
        object :QuandoPressiona{
            override fun pressiona(space: Space){
            }
        },

    var quandoClica: QuandoClica =
        object :QuandoClica{
            override fun clica(space: Space){
            }
        }
): RecyclerView.Adapter<AdapterEscopo.ViewHolder>() {

    private val spaces = spaces.toMutableList()
    private val boxes = boxes.toMutableList()
    private val artifacts = artifacts.toMutableList()
    interface QuandoClica{
        fun clica(space: Space)
    }

    interface QuandoPressiona{
        fun pressiona(space: Space)
    }
    inner class ViewHolder(
        private val binding: CardDefautBinding
    ): RecyclerView.ViewHolder(binding.root){

        private lateinit var space: Space
        init {
            binding.root.setOnLongClickListener {
                space.let { quandoPressiona.pressiona(it) }
                true
            }
            binding.root.setOnClickListener{
                space.let { quandoClica.clica(it) }
            }
        }
        fun vincula(space: Space){
            binding.iconCard.setImageResource(R.drawable.space)
            this.space = space
            val nome = binding.cardDefaultNome
            nome.text = space.nomeId
            val caminho = binding.cardDefaultCaminho
            caminho.text = space.caminho
        }
        fun vincula(box: Box){
            binding.iconCard.setImageResource(R.drawable.box)
            val nome = binding.cardDefaultNome
            nome.text = box.nomeId
            val caminho = binding.cardDefaultCaminho
            caminho.text = box.caminho
        }
        fun vincula(artifact: Artifact){
            binding.iconCard.setImageResource(R.drawable.artifact)
            val nome = binding.cardDefaultNome
            nome.text = artifact.nomeId
            val caminho = binding.cardDefaultCaminho
            caminho.text = artifact.caminho
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = CardDefautBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val spacePosition = position
        val boxPosition = position - spaces.size
        val artifactPosition = position - spaces.size - boxes.size
        when {
            spacePosition < spaces.size -> {
                val space = spaces[spacePosition]
                holder.vincula(space)
            }
            boxPosition < boxes.size -> {
                val box = boxes[boxPosition]
                holder.vincula(box)
            }
            artifactPosition < artifacts.size -> {
                val artifact = artifacts[artifactPosition]
                holder.vincula(artifact)
            }
        }

    }
    override fun getItemCount(): Int = spaces.size + boxes.size + artifacts.size
}