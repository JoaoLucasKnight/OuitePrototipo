package nf3.ouiteprototipo.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.ActivityCadastroBinding
import nf3.ouiteprototipo.model.Pessoa

class CadastroActivity : AppCompatActivity(R.layout.activity_cadastro){

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.cadastroBttSalvar.setOnClickListener(){
            val intent = Intent(this, HomeActivity::class.java)
            val user = criarUser()
            intent.putExtra("user", user.nome)
            startActivity(intent)
        }

    }

    private fun criarUser():Pessoa{
        val email = binding.cadastroInputEmail.text.toString()
        val senha = binding.cadastroInputSenha.text.toString()
        val nome = binding.cadastroInputNome.text.toString()
        val telefone = binding.cadastroInputNumero.text.toString()

        return Pessoa(
            email = email,
            senha = senha,
            nome = nome,
            telefone = telefone
        )
    }
}