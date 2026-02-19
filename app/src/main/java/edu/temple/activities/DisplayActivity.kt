package edu.temple.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

 const val Result_Key = "message"
class DisplayActivity : AppCompatActivity() {

    lateinit var resultSize : TextView
    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value
    val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
       if( it.resultCode == Activity.RESULT_OK ) {
       it.data?.run{
        lyricsDisplayTextView.textSize = getIntExtra(Result_Key,22 ).toFloat()
       }
       }
    }
    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {

    val launchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
        launcher.launch(launchIntent)

        }

    }
}