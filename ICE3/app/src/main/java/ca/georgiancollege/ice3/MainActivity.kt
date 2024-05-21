package ca.georgiancollege.ice3

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ca.georgiancollege.ice3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        // create a reference to the ActivityMainBinding Class object
        binding = ActivityMainBinding.inflate(layoutInflater)

        enableEdgeToEdge()

        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val helloWorldString = binding.helloWorldTextView
        helloWorldString.text = getString(R.string.hello_tom)

        val clickMeButton = binding.clickMeButton

        clickMeButton.setOnClickListener{
            Log.i("onCreate", "Click Me Button clicked!")

            binding.helloWorldTextView.text = getString(R.string.good_bye_tom)
        }

        val anotherButton = binding.anotherButton

        anotherButton.setOnClickListener{
            Log.i("onCreate", "another Button Clicked")

            binding.helloWorldTextView.text = getString(R.string.hello_tom)
        }
    }


    fun sharedButtonHandler(view: View)
    {

    }

}