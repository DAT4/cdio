package com.example.cdio

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.example.cdio.databinding.ActivityMainBinding

private const val REQUEST_CODE = 40

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.button.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(this.packageManager) != null) {
                startActivityForResult(intent, REQUEST_CODE)
            } else {
                Toast.makeText(this, "Kamarat virker du?", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val newImg = data?.extras?.get("data") as Bitmap
            binding.image.setImageBitmap(newImg)
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

}