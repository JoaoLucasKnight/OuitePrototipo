package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.LoginBinding

class LoginFragment: Fragment(R.layout.login) {

    private lateinit var binding: LoginBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginBinding.inflate(inflater,container ,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = view.findNavController()
        binding.LoginBttCadastrar.setOnClickListener{
            controller.navigate(R.id.cont_cadastro_fragment)
        }

        binding.LoginBttEntrar.setOnClickListener{
            controller.navigate(R.id.cont_home_fragment)
        }
    }
}