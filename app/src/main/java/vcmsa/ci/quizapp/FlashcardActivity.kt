package vcmsa.ci.quizapp


import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class FlashcardActivity : AppCompatActivity() {

    private lateinit var questionTxt: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button
    private lateinit var feedbackTxt: TextView

    // Code attribution
    // This method was taken from
    // https://developer.android.com/kotlin/common-patterns
    // Android Studio

    companion object {
        val questions = arrayOf(
            "Nelson Mandela spent 27 years in prison",
            "Pretoria is the capital city of South Africa",
            "The Freedom Charter was adopted in 1955",
            "Chris Hani was assassinated by an ANC member",
            "Apartheid laws officially began in 1948"
        )
        val answers = booleanArrayOf(true, true, false, false, true)
    }
    // Code attribution
    // This method was taken from
    // IMAD5112 Module Manual
    // Page 76

    private var existingQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.flashcard)
        // Code attribution
        // This method was taken from
        // IMAD5112 Module Manual
        // Page 30

        // Declare the user interface elements
        questionTxt = findViewById(R.id.questionTxt)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)
        feedbackTxt = findViewById(R.id.feedbackTxt)


        // Show starting question
        printQuestion()

        // Set a Click Listener for the true button
        btnTrue.setOnClickListener { checkAnswer(true) }

        // Set a Click Listener for the false button
        btnFalse.setOnClickListener { checkAnswer(false) }

        // Set a Click Listener for the next button
        btnNext.setOnClickListener {
            existingQuestionIndex++
            if (existingQuestionIndex < questions.size) {
                printQuestion()
                feedbackTxt.text = ""
                btnTrue.isEnabled = true
                btnFalse.isEnabled = true
            } else {

                // Go to ScoreActivity
                val intent = Intent(this, ScoreActivity::class.java)
                // Code attribution
                // This method was taken from
                // IMAD5112 Module Manual
                // Page 96

                intent.putExtra("score", score)
                startActivity(intent)
                finish()
                // Finish FlashcardActivity so user is prohibited from going back
            }
        }
        btnNext.isEnabled = false
        // Disable btnNext

    }

    // creating a function to display an output text when daytime is entered
    private fun printQuestion() {
        questionTxt.text = questions[existingQuestionIndex]

    }
    // creating a function to display an output text when daytime is entered
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = answers[existingQuestionIndex]

        if (userAnswer == correctAnswer) {
            feedbackTxt.text = "You guessed right!"
            feedbackTxt.setTextColor(Color.GREEN)
            score++
        } else {
            feedbackTxt.text = "You guessed incorrectly!"
            feedbackTxt.setTextColor(Color.RED)
        }
        btnTrue.isEnabled = false
        btnFalse.isEnabled = false
        btnNext.isEnabled = true
    }
    // Code attribution
    // This method was taken from
    // IMAD5112 Module Manual
    // Page 56

    // Code attribution
    // This method was taken from
    // IMAD5112 Module Manual
    // Page 49
}



