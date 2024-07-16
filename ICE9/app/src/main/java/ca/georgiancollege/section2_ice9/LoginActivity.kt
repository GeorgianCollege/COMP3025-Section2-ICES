package ca.georgiancollege.section2_ice9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.georgiancollege.section2_ice9.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}