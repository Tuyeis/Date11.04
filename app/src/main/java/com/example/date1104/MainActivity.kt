package com.example.date1104

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.date1104.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
  private val TAG = this.javaClass.simpleName
   private var userList: ArrayList<User> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputStream = assets.open("users.json")
        // alter java Basis wie folgt zu verwenden
        // val isr = InputStreamReader(inputStream)
        // val br = BufferedReader(isr)
        // val jsonString = br.readText()

        //so geht es aktuell
         val jsonString = inputStream.bufferedReader().use{bufferedReader ->
             bufferedReader.readText()
         }
        Log.d(TAG, "onCreate: JsonString -> $jsonString")

    }
}