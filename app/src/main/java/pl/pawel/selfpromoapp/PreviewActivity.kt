package pl.pawel.selfpromoapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import pl.pawel.selfpromoapp.databinding.ActivityPreviewBinding

class PreviewActivity : AppCompatActivity() {

    private lateinit var message: Message
    private lateinit var messagePreviewText: String

    private lateinit var binding: ActivityPreviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(ActivityPreviewBinding.inflate(layoutInflater).root)
        displayMessage()
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

    private fun setupButton()
    {
        binding.buttonSend.setOnClickListener {



        }
    }
}
