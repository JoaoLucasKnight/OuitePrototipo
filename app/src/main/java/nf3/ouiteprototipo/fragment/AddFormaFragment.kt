package nf3.ouiteprototipo.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
    ): View{
        binding = AdicionarFormBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = AppDatabase
            .instancia(context?:throw IllegalArgumentException("Contexto Invalido "))
        binding.addSalvarBtt.setOnClickListener {
            if(binding.spaceRadioBtt.isChecked){
                db.spaceDao().salvar(
                    Space(
                        nomeId = binding.inputNome.text.toString(),
                        descricao = binding.inputDescricao.text.toString(),
                        paiNameId = binding.inputPai.text.toString(),
                        caminho = buildCaminho(
                            binding.inputPai.text.toString(),
                            binding.inputNome.text.toString(),
                            db)))
            }else
                if (binding.boxRadioBtt.isChecked){
                db.boxDao().salvar(
                    Box(
                        nomeId = binding.inputNome.text.toString(),
                        descricao = binding.inputDescricao.text.toString(),
                        paiNameId = binding.inputPai.text.toString(),
                        caminho = buildCaminho(
                            binding.inputPai.text.toString(),
                            binding.inputNome.text.toString(),
                            db)))
            }else
                    if (binding.artifactRadioBtt.isChecked){
                        db.artifactDao().salvar(
                            Artifact(
                                nomeId = binding.inputNome.text.toString(),
                                descricao = binding.inputDescricao.text.toString(),
                                paiNameId = binding.inputPai.text.toString(),
                                caminho = buildCaminho(
                                    binding.inputPai.text.toString(),
                                    binding.inputNome.text.toString(),
                                    db)))
                    }
            findNavController().navigateUp()
        }


    }
    fun buildCaminho(paiId: String?, id: String,db: AppDatabase): String{
        val caminho: String
        if(paiId == null || paiId == ""){
            caminho = "${id}"
        }else{
            caminho = "${db.spaceDao().getCaminho(paiId)}>${id}"
        }
        return caminho
    }

}
