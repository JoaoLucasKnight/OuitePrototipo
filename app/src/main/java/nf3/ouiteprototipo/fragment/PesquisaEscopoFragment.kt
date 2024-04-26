package nf3.ouiteprototipo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.PesquisaEscopoBinding

class PesquisaEscopoFragment: Fragment(R.layout.pesquisa_escopo) {

    private lateinit var binding: PesquisaEscopoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PesquisaEscopoBinding.inflate(inflater,container,false)

        parentFragmentManager.commit {
            add<Escopo>(binding.fragEscopo.id, args = arguments)
            add<AddBtt>(binding.fragAdd.id)
        }
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}