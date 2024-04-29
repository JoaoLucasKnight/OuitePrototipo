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
        val tipo = arguments?.getString("tipo")?:""

        when(tipo){
            "Space" -> {
                val space = db.spaceDao().getId(name)
                if(space != null) {
                    val titulo = binding.cardDetalhesTitulo
                    titulo.text = space.nomeId
                    val caminho = binding.cardDetalhesInputCaminho
                    caminho.text = space.caminho
                    val notas = binding.cardDetalhesNota
                    notas.text = space.descricao

                    binding.cardDetalhesBttEditar.setOnClickListener{
                        val args = Bundle().apply {
                            putString("name", space.nomeId )
                            putString("tipo", "Space")
                        }
                        findNavController().navigate(R.id.cont_editar_fragment,args)
                    }

                    binding.cardDetalhesBttDeletar.setOnClickListener {
                        db.spaceDao().delete(space)
                    }

                }
            }
            "Box" -> {
               val box = db.boxDao().getId(name)
               if (box != null){
                   val titulo = binding.cardDetalhesTitulo
                   titulo.text = box.nomeId
                   val caminho = binding.cardDetalhesInputCaminho
                   caminho.text = box.caminho
                   val notas = binding.cardDetalhesNota
                   notas.text = box.descricao

                   binding.cardDetalhesBttEditar.setOnClickListener{
                       val args = Bundle().apply {
                           putString("name", box.nomeId )
                           putString("tipo", "Box")
                       }
                       findNavController().navigate(R.id.cont_editar_fragment,args)
                   }

                   binding.cardDetalhesBttDeletar.setOnClickListener {
                       db.boxDao().delete(box)
                       findNavController().navigateUp()
                   }
               }
            }
        }
    }
}

