package com.android.gangplank.roomwithview


import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController

class NewWordFragment : Fragment() {

    private lateinit var editTextView: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_word, container, false)
        editTextView = view.findViewById(R.id.editText)
        val addBtn = view.findViewById<Button>(R.id.btnAdd)
        addBtn.setOnClickListener { view: View? ->
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editTextView.text)) {
                view.findNavController(). //
            }
        }

        return view
    }


}
