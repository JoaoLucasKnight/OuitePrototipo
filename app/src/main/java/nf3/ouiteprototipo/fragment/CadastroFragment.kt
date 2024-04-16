package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.CadastroBinding
import nf3.ouiteprototipo.model.User


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

        binding.cadastroInputImg.setImageResource(R.drawable.perfil)

        binding.cadastroInputNome.setText(User.nome)
        binding.cadastroInputEmail.setText(User.email)
        binding.cadastroInputSenha.setText(User.senha)
        binding.cadastroInputNumero.setText(User.telefone)

        binding.cadastroBttSalvar.setOnClickListener{
            User.apply {
                email = binding.cadastroInputEmail.text.toString()
                senha = binding.cadastroInputSenha.text.toString()
                nome = binding.cadastroInputNome.text.toString()
                telefone = binding.cadastroInputNumero.text.toString()
            }
            findNavController().navigate(R.id.cont_home_fragment)
        }
    }

}

