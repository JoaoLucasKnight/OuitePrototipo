package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.fragment.findNavController
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.HomeBinding
import android.widget.SearchView
import nf3.ouiteprototipo.model.User


class HomeFragment: Fragment(R.layout.home) {

    private lateinit var binding: HomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = HomeBinding.inflate(inflater,container,false)


        parentFragmentManager.commit {
            add<Pesquisar>(binding.fragPesquisa.id)
            add<ListSpaces>(binding.fragSpace.id)
            add<ListHistory>(binding.fragHistory.id)
            add<AddBtt>(binding.fragAdd.id)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcome.text = "Seja Bem vindo a Ouitê, ${User.nome}"

        binding.homeImgPerfil.run {
            this.setImageResource(R.drawable.perfil)
            this.setOnClickListener{
                findNavController().navigate(R.id.cont_cadastro_fragment)
            }
        }

    }
}