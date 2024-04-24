package nf3.ouiteprototipo.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.AdicionarFormBinding
import nf3.ouiteprototipo.model.Artifact
import nf3.ouiteprototipo.model.Box
import nf3.ouiteprototipo.model.Space
import nf3.ouiteprototipo.room.AppDatabase

class AddFormaFragment: Fragment(R.layout.adicionar_form) {

    private lateinit var binding: AdicionarFormBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AdicionarFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = AppDatabase
            .instancia(context ?: throw IllegalArgumentException("Contexto Invalido "))
        binding.addSalvarBtt.setOnClickListener {
            when {
                binding.artifactRadioBtt.isChecked -> {
                    //valida
                    val artifact = validaArtifact(binding, db)
                    //Salva
                    if (artifact != null) {
                        db.artifactDao().salvar(artifact)
                        findNavController().navigateUp()
                    }
                }
                binding.boxRadioBtt.isChecked -> {
                    val box = validaBox(binding, db)
                    if (box != null){
                        db.boxDao().salvar(box)
                        findNavController().navigateUp()
                    }
                }
                binding.spaceRadioBtt.isChecked -> {
                    val space = validaSpace(binding,db)
                    if (space != null){
                        db.spaceDao().salvar(space)
                        findNavController().navigateUp()
                    }
                }
            }
        }
    }
}

fun validaArtifact(binding: AdicionarFormBinding,  db: AppDatabase): Artifact? {
        val nome = binding.inputNome.text.toString()
        val pai = binding.inputPai.text.toString()
        val desc = binding.inputDescricao.text.toString()
        var caminho: String = ""

        // nome vazio?
        if(nome.isEmpty()){
            binding.layoutNome.error = "Campo Vazio"
            return null
            // tem outro igual?
            }else if (db.artifactDao().getId(nome) != null){
                binding.layoutNome.error = "Artifact ja existe"
                return null
            }else {
                binding.layoutNome.error = null
            }
        // pai vazio?
        if (pai.isEmpty()){
            binding.layoutPai.error = "Campo Vazio"
            return null
            //então
            }else {
                //o pai é um Box
                if (db.boxDao().getId(pai) != null) {
                    caminho = "${db.boxDao().getCaminho(pai)}>$nome"
                    // o pai é um space
                    } else if (db.spaceDao().getId(pai) != null) {
                         caminho = "${db.spaceDao().getCaminho(pai)}>$nome"
                        // pai não existe
                        } else {
                            binding.layoutPai.error = "Space ou Box não existe"
                            return null
                        }
            binding.layoutPai.error = null
            }

    return Artifact(
        nomeId = nome,
        descricao = desc,
        paiNameId = pai,
        caminho = caminho
    )
}
fun validaBox(binding: AdicionarFormBinding,  db: AppDatabase): Box?{
    val nome = binding.inputNome.text.toString()
    val pai = binding.inputPai.text.toString()
    val desc = binding.inputDescricao.text.toString()
    var caminho: String = ""

    // nome vazio?
    if(nome.isEmpty()){
        binding.layoutNome.error = "Campo Vazio"
        return null
        // tem outro igual?
    }else if (db.boxDao().getId(nome) != null){
        binding.layoutNome.error = "Box ja existe"
        return null
    }else {
        binding.layoutNome.error = null
    }
    // pai vazio?
    if (pai.isEmpty()){
        binding.layoutPai.error = "Campo Vazio"
        return null
        //então
    }else {
        //o pai é um Box
        if (db.boxDao().getId(pai) != null) {
            caminho = "${db.boxDao().getCaminho(pai)}>$nome"
            // o pai é um space
        } else if (db.spaceDao().getId(pai) != null) {
            caminho = "${db.spaceDao().getCaminho(pai)}>$nome"
            // pai não existe
        } else {
            binding.layoutPai.error = "Space ou Box não existe"
            return null
        }
        binding.layoutPai.error = null
    }

    return Box(
        nomeId = nome,
        descricao = desc,
        paiNameId = pai,
        caminho = caminho
    )
}
fun validaSpace(binding: AdicionarFormBinding,  db: AppDatabase): Space?{
    val nome = binding.inputNome.text.toString()
    val pai = binding.inputPai.text.toString()
    val desc = binding.inputDescricao.text.toString()
    var caminho: String = ""

    // nome vazio?
    if(nome.isEmpty()){
        binding.layoutNome.error = "Campo Vazio"
        return null
        // tem outro igual?
    }else if (db.spaceDao().getId(nome) != null){
        binding.layoutNome.error = "Space ja existe"
        return null
    }else {
        binding.layoutNome.error = null
    }

    // pai vazio?
    if (!pai.isEmpty()){
        if (db.spaceDao().getId(pai) != null) {
            caminho = "${db.spaceDao().getCaminho(pai)}>$nome"
        // pai não existe
        } else {
            binding.layoutPai.error = "Space não existe"
            return null
        }
    }else {
        caminho = nome
        binding.layoutPai.error = null
    }
    return Space(
        nomeId = nome,
        descricao = desc,
        paiNameId = pai,
        caminho = caminho
    )
}
