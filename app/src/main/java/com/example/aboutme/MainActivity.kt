package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

// https://developer.android.com/courses/kotlin-android-fundamentals/toc

class MainActivity : AppCompatActivity() {

    lateinit var doneButton: Button
    lateinit var nicknameTextView: TextView
    lateinit var editText: EditText

    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName("ANIMESH ROY")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName
        nicknameTextView = binding.nicknameText
        doneButton = binding.doneButton // doneButton = findViewById<Button>(R.id.done_button)
        editText = binding.nicknameEdit

        doneButton.setOnClickListener {
            addNickname(it)
        }

        nicknameTextView.setOnClickListener {
            updateNickname(it)
        }

    }

    private fun addNickname(view: View) {
        nicknameTextView.text = editText.text
        editText.visibility = View.GONE
        nicknameTextView.visibility = View.VISIBLE
        doneButton.visibility = View.GONE
        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname (view: View) {
        nicknameTextView.visibility = View.GONE
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        // Set the focus to the edit text.
        editText.requestFocus()
    }
}