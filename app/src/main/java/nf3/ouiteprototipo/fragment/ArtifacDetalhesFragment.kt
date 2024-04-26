package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.CardArtifactBinding
import nf3.ouiteprototipo.room.AppDatabase

class ArtifacDetalhesFragment :Fragment(R.layout.card_artifact){

    private lateinit var  binding: CardArtifactBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CardArtifactBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db: AppDatabase = AppDatabase
            .instancia(context?: throw IllegalArgumentException("Contexto invalido"))
        val id = arguments?.
            getString("id")?:
            throw IllegalArgumentException ("Artifact veio Vazio")

        val artifact = db.artifactDao().getId(id)
        binding.artifactTextViewWay.text = artifact?.caminho
        binding.detalhesTextViewTitle.text = artifact?.nomeId
        binding.textViewArtifactDetalhes.text = artifact?.descricao

    }
}