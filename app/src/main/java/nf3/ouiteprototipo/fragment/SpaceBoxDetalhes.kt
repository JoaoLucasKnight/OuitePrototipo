package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.CardDetalhesBinding
import nf3.ouiteprototipo.room.AppDatabase

class SpaceBoxDetalhes: Fragment (R.layout.card_detalhes) {

    private lateinit var binding: CardDetalhesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View { binding = CardDetalhesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db: AppDatabase = AppDatabase
            .instancia(context?: throw IllegalArgumentException("Contexto invalido"))

        val name = arguments?.getString("name")?:""
        val space = db.spaceDao().getId(name)

        val titulo = binding.detalhesTextViewTitle
        titulo.text = space?.nomeId
        val caminho = binding.inputCaminho
        caminho.text = space?.caminho
        val notas = binding.detalhesTextViewAnotacao
        notas.text = space?.descricao


        binding.removerBtt.setOnClickListener {
            db.spaceDao().delete(space?:throw IllegalArgumentException("Space nulo"))
            findNavController().navigateUp()
        }
    }
}