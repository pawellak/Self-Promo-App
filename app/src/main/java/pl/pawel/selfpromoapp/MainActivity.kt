package pl.pawel.selfpromoapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pl.pawel.selfpromoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.previewButton.setOnClickListener {
            onPreviewClicked()

        }
    }

    private fun onPreviewClicked() {
        val testString = binding.editTextContactName.text.toString() + ", " + binding.editTextContactNumber.text.toString()
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }
}