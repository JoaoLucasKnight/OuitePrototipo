package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.EditarFormBinding
import nf3.ouiteprototipo.room.AppDatabase

class EditarFragment : Fragment(R.layout.editar_form){

    private lateinit var binding: EditarFormBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = EditarFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db: AppDatabase = AppDatabase
            .instancia(context?: throw IllegalArgumentException("Contexto invalido"))

        val name = arguments?.getString("name")?:""
        val tipo = arguments?.getString("tipo")?:""

        binding.editarHead.text = "Editar: $tipo - $name"

        var nome = binding.editarInputNome
        var pai = binding.editarInputPai
        var desc = binding.editarInputDescricao

        when(tipo){
            "Space" ->{
                val space = db.spaceDao().getId(name)
                if (space != null) {
                    nome.setText(space.nomeId)
                    pai.setText(space.paiNameId)
                    desc.setText(space.descricao)
                    binding.editarBttEditar.setOnClickListener{
                        db.spaceDao().up(space)
                        findNavController().navigateUp()
                    }
                    binding.editarBttDeletar.setOnClickListener {
                        db.spaceDao().delete(space)
                        findNavController().navigateUp()
                    }
                }

            }
            "Box" ->{
                val box = db.boxDao().getId(name)
                if (box != null) {
                    nome.setText(box.nomeId)
                    pai.setText(box.paiNameId)
                    desc.setText(box.descricao)
                    binding.editarBttEditar.setOnClickListener{
                        db.boxDao().up(box)
                        findNavController().navigateUp()
                    }
                    binding.editarBttDeletar.setOnClickListener {
                        db.boxDao().delete(box)
                        findNavController().navigateUp()
                    }
                }
            }
            "Artifact" ->{
                val artifact = db.artifactDao().getId(name)
                if (artifact != null) {
                    nome.setText(artifact.nomeId)
                    pai.setText(artifact.paiNameId)
                    desc.setText(artifact.descricao)

                    binding.editarBttEditar.setOnClickListener{
                        db.artifactDao().up(artifact)
                        findNavController().navigateUp()
                    }
                    binding.editarBttDeletar.setOnClickListener {
                        db.artifactDao().delete(artifact)
                        findNavController().navigateUp()
                    }
                }
            }
        }

    }
}