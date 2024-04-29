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

    var event: Events =
        object :Events{
            override fun spacePressiona(space: Space){}
            override fun spaceClica(space: Space){}
            override fun boxPressiona(box: Box){}
            override fun boxClica(box: Box){}
            override fun artifactPressiona(artifact: Artifact){}
            override fun artifactClica(artifact: Artifact){}
        }
): RecyclerView.Adapter<AdapterEscopo.ViewHolder>() {

    private val spaces = spaces.toMutableList()
    private val boxes = boxes.toMutableList()
    private val artifacts = artifacts.toMutableList()

    interface Events{
        fun spacePressiona(space: Space)
        fun spaceClica(space: Space)
        fun boxPressiona(box: Box)
        fun boxClica(box: Box)
        fun artifactPressiona(artifact: Artifact)
        fun artifactClica(artifact: Artifact)
    }

    inner class ViewHolder(
        private val binding: CardDefautBinding
    ): RecyclerView.ViewHolder(binding.root){

        private lateinit var space: Space
        private lateinit var box: Box
        private lateinit var artifact: Artifact

        init {
            binding.root.setOnClickListener(){
                when (adapterPosition){
                    in 0 until spaces.size -> space.let { event.spaceClica(it) }
                    in spaces.size until (spaces.size + boxes.size) -> box.let { event.boxClica(it)}
                    else -> artifact.let { event.artifactClica(it) }
                }
            }
            binding.root.setOnLongClickListener {
                when (adapterPosition){
                    in 0 until spaces.size -> space.let { event.spacePressiona(it) }
                    in spaces.size until (spaces.size + boxes.size) -> box.let { event.boxPressiona(it)}
                    else -> artifact.let { event.artifactPressiona(it) }
                }
                true
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
        fun vincula(box: Box){
            binding.cardDefautIcon.setImageResource(R.drawable.icon_box)
            this.box = box
            val nome = binding.cardDefautNomeId
            nome.text = box.nomeId
            val caminho = binding.cardDefautCaminho
            caminho.text = box.caminho
        }
        fun vincula(artifact: Artifact){
            binding.cardDefautIcon.setImageResource(R.drawable.icon_artifact)
            this.artifact = artifact
            val nome = binding.cardDefautNomeId
            nome.text = artifact.nomeId
            val caminho = binding.cardDefautCaminho
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