package vcmsa.ci.quizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class ReviewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.review)
        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 30

        val reviewTxt = findViewById<TextView>(R.id.reviewTxt)
        val refreshBtn = findViewById<Button>(R.id.refreshBtn)
        val exitBtn = findViewById<Button>(R.id.exitBtn)

        val questions = intent.getStringArrayExtra("questions")
        val answers = intent.getBooleanArrayExtra("answers")

        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 99

        val resultTxt = StringBuilder()
        if (questions !=null && answers != null && questions.size == answers.size) {
            for (i in questions.indices) {
                reviewTxt.append("${i + 1}. ${questions[i]}\n")
                reviewTxt.append("  Answer: ${if (answers[i]) "True" else "False"}\n\n")
            }
            reviewTxt.text = resultTxt.toString()
        } else {
            reviewTxt.text = "Error while loading the review data."
        }
        refreshBtn.setOnClickListener {
            startActivity(Intent(this, FlashcardActivity::class.java))
        }
        exitBtn.setOnClickListener {
            finishAffinity()
            exitProcess(0)
        }
    }
}