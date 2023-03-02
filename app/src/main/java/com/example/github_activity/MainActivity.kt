package com.example.github_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        //Anas
        button.setOnClickListener {
            var name = editTextTextPersonName.text.toString()
            var id = editTextTextPersonName2.text.toString()
            var password = editTextTextPersonName3.text.toString()
            val user = hashMapOf(
                "name" to name,
                "id" to id,
                "password" to password
            )
            db.collection("users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d("TAG", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("TAG", "Error adding document", e)
                }
        }
    }
}