package nf3.ouiteprototipo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.ActivityHomeBinding
import nf3.ouiteprototipo.fragment.AddFragmennt
import nf3.ouiteprototipo.fragment.HeadFragment
import nf3.ouiteprototipo.fragment.HistoryFragment

import nf3.ouiteprototipo.fragment.PesquisaFragment
import nf3.ouiteprototipo.fragment.SpaceFragment


class HomeActivity: AppCompatActivity(R.layout.activity_home) {

        private val binding by lazy {
            ActivityHomeBinding.inflate(layoutInflater)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
            if (savedInstanceState == null) {

                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<HeadFragment>(binding.fragHead.id)
                    add<PesquisaFragment>(binding.fragPesquisa.id)
                    add<SpaceFragment>(binding.fragSpace.id)
                    add<HistoryFragment>(binding.fragHistory.id)
                    add<AddFragmennt>(binding.fragAdd.id)
                }
            }
        }
    }

//override fun onCreate(savedInstanceState: Bundle?) {
//    super.onCreate(savedInstanceState)
//    setContentView(binding.root)
//    val fragmento = PesquisaFragment()
//    val trans = supportFragmentManager.beginTransaction()
//    trans.add(R.id.pesquisa, fragmento)
//    trans.commit()
//}