package nf3.ouiteprototipo.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.ActivityCadastroBinding
import nf3.ouiteprototipo.databinding.ActivityHomeBinding
import nf3.ouiteprototipo.databinding.ActivityLoginBinding

class MainActivity : AppCompatActivity(R.layout.activity_login) {

    private val binding by lazy {
        ActivityLoginBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.LoginBttCadastrar.setOnClickListener{
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        binding.LoginBttEntrar.setOnClickListener{
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }



    }
}