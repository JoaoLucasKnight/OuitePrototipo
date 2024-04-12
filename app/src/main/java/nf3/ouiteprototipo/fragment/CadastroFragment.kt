package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.CadastroBinding
import nf3.ouiteprototipo.databinding.LoginBinding
import nf3.ouiteprototipo.model.Pessoa
import kotlin.concurrent.fixedRateTimer


class CadastroFragment: Fragment (R.layout.cadastro) {

    private lateinit var binding: CadastroBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CadastroBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cadastroBttSalvar.setOnClickListener{
          Pesso.apply {
              email = binding.cadastroInputEmail.text.toString()
              senha = binding.cadastroInputSenha.text.toString()
              nome = binding.cadastroInputNome.text.toString()
              telefone = binding.cadastroInputNumero.text.toString()
          }

            findNavController().navigate(R.id.cont_home_fragment)
        }
    }

}
object Pesso  {
    var email: String? = null
    var senha: String? = null
    var nome: String? = null
    var telefone: String? = null
}
