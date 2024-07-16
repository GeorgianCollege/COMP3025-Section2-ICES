package ca.georgiancollege.section2_ice9

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ca.georgiancollege.section2_ice9.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}