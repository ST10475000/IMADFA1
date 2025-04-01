package za.ac.iie.myassignment

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Declare UI components locally using 'val'
        val timeOfDayEditText = findViewById<EditText>(R.id.timeOfDay)
        val suggestionTextView = findViewById<TextView>(R.id.suggestion)
        val suggest = findViewById<Button>(R.id.suggest)
        val reset = findViewById<Button>(R.id.reset)

        //OnClickListener for the suggest button if statements
        suggest.setOnClickListener {
            val input = timeOfDayEditText.text.toString().trim().lowercase()
            var suggestion = ""


            if (input == "morning") {
                suggestion = "eggs (breakfast)"
            } else if (input == "mid morning") {
                suggestion = "FRUIT (SNACK)"
            } else if (input == "afternoon") {
                suggestion = "sandwich (lunch)"
            } else if (input == "mid afternoon") {
                suggestion = "cake (Quick Bite)"
            } else if (input == "dinner") {
                suggestion = "pasta (Main Course)"
            } else if (input == "after dinner snack") {
                suggestion = "ice cream (Dessert)"

            } else {
                suggestion = "No suggestion available for '$input'."

            }
            suggestionTextView.text = suggestion

        }
        // OnClickListener for the Reset button
        reset.setOnClickListener {
            timeOfDayEditText.text.clear()
            suggestionTextView.text = ""
        }





















        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}