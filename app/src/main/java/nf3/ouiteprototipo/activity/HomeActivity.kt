package nf3.ouiteprototipo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.ActivityHomeBinding

import nf3.ouiteprototipo.fragment.PesquisaFragment


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
                    add<PesquisaFragment>(binding.pesquisa.id)
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