package nf3.ouiteprototipo.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.AdicionarFormBinding
import nf3.ouiteprototipo.model.Space
import nf3.ouiteprototipo.room.AppDatabase

class AddFormaFragment: Fragment(R.layout.adicionar_form) {

    private lateinit var binding: AdicionarFormBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AdicionarFormBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = AppDatabase.instancia(context?.let {
            it
        }?:throw IllegalArgumentException("Contexto Invalido ")
        )
        binding.addSalvarBtt.setOnClickListener {
            db.spaceDao().salvar(
                Space(
                    nomeId = binding.inputNome.text.toString(),
                    descricao = binding.inputDescricao.text.toString(),
                    caminho = ">${binding.inputNome.text.toString()}",
                    paiNameId = binding.inputPai.text.toString()

                )
            )
        }

    }



    }
