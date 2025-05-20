package vcmsa.ci.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 30

        // Declare the user interface elements
        val appName = findViewById<TextView>(R.id.appNameTxt)
        val editTxtDesc = findViewById<EditText>(R.id.editTxtDesc)
        val btnStart = findViewById<Button>(R.id.btnStart)
        val btnExit = findViewById<Button>(R.id.btnExit)

        appName.text = "History Flashcards"
        editTxtDesc.hint = "In this app you will be given 5 history questions"

        // Set a Click listener for the start button
        btnStart.setOnClickListener{
            val intent = Intent(this, FlashcardActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Clicked!", Toast.LENGTH_LONG).show()
        }

        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 96 - 99


        // Set a Click listener for the exit button
        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess( 0)
        }
        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 45
    }

}

