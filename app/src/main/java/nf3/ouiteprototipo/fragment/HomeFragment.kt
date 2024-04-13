package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.HomeBinding

class HomeFragment: Fragment(R.layout.home) {

    private lateinit var binding: HomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeBinding.inflate(inflater,container,false)

        parentFragmentManager.commit {
            add<Spaces>(binding.fragSpace.id)
            add<History>(binding.fragHistory.id)
            add<Add>(binding.fragAdd.id)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.welcome.text = "Seja Bem vindo a Ouitê, ${Pesso.nome}"
    }
}