package nf3.ouiteprototipo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import nf3.ouiteprototipo.R
import nf3.ouiteprototipo.databinding.ActivityHomeBinding

class HomeActivity: AppCompatActivity(R.layout.activity_home) {

    private val binding by lazy {
        ActivityHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}