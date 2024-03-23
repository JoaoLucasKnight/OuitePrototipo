package nf3.ouiteprototipo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro){

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}