package vcmsa.ci.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.score)
        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 30

        // Declare the user interface elements
        val scoreTxt = findViewById<TextView>(R.id.scoreTxt)
        val feedbackTxt = findViewById<TextView>(R.id.feedbackTxt)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("score", 0)
        scoreTxt.text = "Your score is: $score/5"

        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 80

        val feedback = if (score >= 3) {
            "Awesome job!"
        } else {
            "Keep trying!"
        }
        feedbackTxt.text = feedback

        // Set a Click listener for the Review button
        btnReview.setOnClickListener{

            // Pass Questions and Answers to ReviewActivity
            val intent = Intent(this, ReviewActivity::class.java)
            intent.putExtra("questions", FlashcardActivity.questions)
            intent.putExtra("answers", FlashcardActivity.answers)
            startActivity(intent)
        }
        // Set a Click listener for the Review button
        btnExit.setOnClickListener{
            finishAffinity()
            exitProcess(0)
        }

    }
}