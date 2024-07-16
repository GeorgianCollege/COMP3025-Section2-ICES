package ca.georgiancollege.section2_ice9

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ca.georgiancollege.section2_ice9.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var viewModel: TVShowViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()
        viewModel = ViewModelProvider(this).get(TVShowViewModel::class.java)

        binding.RegisterButton.setOnClickListener {
            val firstName = binding.FirstNameEditText.text.toString()
            val lastName = binding.LastNameEditText.text.toString()
            val email = binding.EmailEditText.text.toString()
            val password = binding.PasswordText.text.toString()
            val confirmPassword = binding.ConfirmPassword.text.toString()

            if(firstName.isNotEmpty() &&
                lastName.isNotEmpty() &&
                email.isNotEmpty() &&
                password.isNotEmpty() &&
                confirmPassword.isNotEmpty())
            {
                if(password == confirmPassword)
                {
                    auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this) { task->
                            if(task.isSuccessful)
                            {
                                val user = auth.currentUser
                                user?.let {
                                    val newUser = User(id = it.uid, firstName = firstName, lastName = lastName, email = email)
                                    viewModel.insertUser(newUser)
                                }

                                // Sign in
                                startActivity(Intent(this, LoginActivity::class.java))
                                finish()
                            }
                            else
                            {
                                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
                            }
                        }
                }
                else
                {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.CancelButton.setOnClickListener {
            finish()
        }
    }
}