package pl.pawel.selfpromoapp

import android.R.attr.data
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pl.pawel.selfpromoapp.databinding.ActivityPreviewBinding
import androidx.core.net.toUri


class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPreviewBinding.inflate(layoutInflater);
        setContentView(binding.root)
        displayMessage()
        setupButton()
    }

    private fun displayMessage() {
        message = intent.getSerializableExtra("Message") as Message

        messagePreviewText = """
                Hi ${message.contactName}
                
                My name is ${message.myDisplayName} and I am ${message.getFullJobDescription()}
                
                I am able to start a new position ${message.getAvailability()}.
               
                Thanks and best regards.
            """.trimIndent()

        binding.textViewMessage.text = messagePreviewText
    }

    private fun setupButton() {
        binding.buttonSend.setOnClickListener {

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                val uritest = "smsto: ${message.contactNumber}".toUri()
                data = uritest
                putExtra("sms_body", "test123")
            }

            startActivity(intent)


        }
    }
}
