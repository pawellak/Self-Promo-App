package pl.pawel.selfpromoapp

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val previewButton: Button = findViewById<Button>(R.id.preview_button)

        previewButton.setOnClickListener {
            onPreviewClicked()

        }


    }

    private fun onPreviewClicked() {
        val contactNameEditText: TextInputEditText = findViewById(R.id.edit_text_contact_name)
        val contactNumberEditText: TextInputEditText = findViewById(R.id.edit_text_contact_number)
        val testString = contactNameEditText.text.toString() + ", " + contactNumberEditText.text.toString()
        Toast.makeText(this, testString, Toast.LENGTH_LONG).show()
    }
}