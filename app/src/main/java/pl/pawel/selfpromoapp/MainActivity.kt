package pl.pawel.selfpromoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
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

        val spinnerValues: Array<String> = arrayOf("Android Developer", "Android Engineer")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerValues)
        binding.spinnerJobTitle.adapter = adapter
    }

    private fun onPreviewClicked() {

        val message = Message(
            contactName = binding.editTextContactName.text.toString(),
            contactNumber = binding.editTextContactNumber.text.toString(),
            myDisplayName = binding.editTextMyDisplayName.text.toString(),
            includeJunior = binding.checkBoxJunior.isChecked,
            jobTitle = binding.spinnerJobTitle.selectedItem.toString(),
            immediateStart = binding.checkBoxImmediateStart.isChecked,
            startDate = binding.editTextStartDate.text.toString()
        )

        val previewIntent = Intent(this, PreviewActivity::class.java)
        previewIntent.putExtra("Message", message)
        startActivity(previewIntent)
    }
}
