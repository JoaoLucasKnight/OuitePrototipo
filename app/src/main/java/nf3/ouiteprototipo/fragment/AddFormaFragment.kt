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
import nf3.ouiteprototipo.model.Generico
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
        val volta = findNavController().navigateUp()
        val db = AppDatabase
            .instancia(context ?: throw IllegalArgumentException("Contexto Invalido "))

        binding.adcionarBttSalvar.setOnClickListener {
            val nomeId = binding.adcionarInputNome.text.toString()
            val paiNameId = binding.adcionarInputPai.text.toString()
            val descricao = binding.adcionarInputDescricao.text.toString()
            val caminho = caminhos(paiNameId,db)




            var item: Any?

            when {
                binding.artifactRadioBtt.isChecked -> {
                    item = Generico(db.artifactDao().getId(nomeId))
                    val trem = Artifact(
                        nomeId = nomeId,
                        paiNameId = paiNameId,
                        descricao = descricao,
                        caminho = caminho
                    )
                    trem.validaNome(trem.nomeId,item)
                    trem.validaPai(trem.paiNameId, caminho)

                    if (validar(binding, item, caminho)){

                        db.artifactDao().salvar(Artifact(
                            nomeId = nomeId,
                            paiNameId = paiNameId,
                            descricao = descricao,
                            caminho = caminho
                            )
                        )
                       volta
                    }

                }

                binding.boxRadioBtt.isChecked -> {
                    item = db.boxDao().getId(generico.nomeId)
                    if (validar(binding, item, caminho, generico)){
                        db.boxDao().salvar(Box(
                            nomeId = generico.nomeId,
                            paiNameId = generico.paiNameId,
                            descricao = generico.descricao,
                            caminho = generico.caminho
                        ))
                        volta
                    }

                }

                binding.spaceRadioBtt.isChecked -> {
                    item = db.spaceDao().getId(generico.nomeId)
                    if (validar(binding, item, caminho, generico)){
                        db.spaceDao().salvar(Space( nomeId = generico.nomeId,
                            paiNameId = generico.paiNameId,
                            descricao = generico.descricao,
                            caminho = generico.caminho
                        ))
                        volta
                    }
                }
            }



        }

    }
    fun caminhos(pai: String, db: AppDatabase): String{
        var ca =
        db.spaceDao().getId(pai)?.let {
             it.caminho
        }?: db.boxDao().getId(pai)?.let {
             it.caminho
        }
        return ""
    }

    fun validar(
        binding: AdicionarFormBinding, item: Any?, way: String?, generico: Generico
    ): Boolean {
        binding.adcionarLayoutNome.error = generico.validaNome(item)
        binding.adcionarLayoutPai.error = generico.validaPai(way)
        if ((binding.adcionarLayoutNome == null) or (binding.adcionarLayoutPai == null))
        {
            return false
        } else {
            return true
        }
    }

    fun validaArtifact(binding: AdicionarFormBinding, db: AppDatabase): Artifact? {
        val nome = binding.adcionarInputNome.text.toString()
        val pai = binding.adcionarInputPai.text.toString()
        val desc = binding.adcionarInputDescricao.text.toString()
        var caminho: String = ""

        // nome vazio?
        if (nome.isEmpty()) {
            binding.adcionarLayoutNome.error = "Campo Vazio"
            // tem outro igual?
        } else if (db.artifactDao().getId(nome) != null) {
            binding.adcionarLayoutNome.error = "Artifact ja existe"
        } else {
            binding.adcionarLayoutNome.error = null
        }
        // pai vazio?
        if (pai.isEmpty()) {
            binding.adcionarLayoutPai.error = "Campo Vazio"
            return null
            //então
        } else {
            //o pai é um Box
            if (db.boxDao().getId(pai) != null) {
                caminho = "${db.boxDao().getCaminho(pai)}>$nome"
                // o pai é um space
            } else if (db.spaceDao().getId(pai) != null) {
                caminho = "${db.spaceDao().getCaminho(pai)}>$nome"
                // pai não existe
            } else {
                binding.adcionarLayoutPai.error = "Space ou Box não existe"
                return null
            }
            binding.adcionarLayoutPai.error = null
        }

        return Artifact(
            nomeId = nome,
            descricao = desc,
            paiNameId = pai,
            caminho = caminho
        )
    }

    fun validaBox(binding: AdicionarFormBinding, db: AppDatabase): Box? {
        val nome = binding.adcionarInputNome.text.toString()
        val pai = binding.adcionarInputPai.text.toString()
        val desc = binding.adcionarInputDescricao.text.toString()
        var caminho: String = ""

        // nome vazio?
        if (nome.isEmpty()) {
            binding.adcionarLayoutNome.error = "Campo Vazio"
            return null
            // tem outro igual?
        } else if (db.boxDao().getId(nome) != null) {
            binding.adcionarLayoutNome.error = "Box ja existe"
            return null
        } else {
            binding.adcionarLayoutNome.error = null
        }
        // pai vazio?
        if (pai.isEmpty()) {
            binding.adcionarLayoutPai.error = "Campo Vazio"
            return null
            //então
        } else {
            //o pai é um Box
            if (db.boxDao().getId(pai) != null) {
                caminho = "${db.boxDao().getCaminho(pai)}>$nome"
                // o pai é um space
            } else if (db.spaceDao().getId(pai) != null) {
                caminho = "${db.spaceDao().getCaminho(pai)}>$nome"
                // pai não existe
            } else {
                binding.adcionarLayoutPai.error = "Space ou Box não existe"
                return null
            }
            binding.adcionarLayoutPai.error = null
        }

        return Box(
            nomeId = nome,
            descricao = desc,
            paiNameId = pai,
            caminho = caminho
        )
    }

    fun validaSpace(binding: AdicionarFormBinding, db: AppDatabase): Space? {
        val nome = binding.adcionarInputNome.text.toString()
        val pai = binding.adcionarInputPai.text.toString()
        val desc = binding.adcionarInputDescricao.text.toString()
        var caminho: String = ""

        // nome vazio?
        if (nome.isEmpty()) {
            binding.adcionarLayoutNome.error = "Campo Vazio"
            return null
            // tem outro igual?
        } else if (db.spaceDao().getId(nome) != null) {
            binding.adcionarLayoutNome.error = "Space ja existe"
            return null
        } else {
            binding.adcionarLayoutNome.error = null
        }

        // pai vazio?
        if (!pai.isEmpty()) {
            if (db.spaceDao().getId(pai) != null) {
                caminho = "${db.spaceDao().getCaminho(pai)}>$nome"
                // pai não existe
            } else {
                binding.adcionarLayoutPai.error = "Space não existe"
                return null
            }
        } else {
            caminho = nome
            binding.adcionarLayoutPai.error = null
        }
        return Space(
            nomeId = nome,
            descricao = desc,
            paiNameId = pai,
            caminho = caminho
        )
    }
}
