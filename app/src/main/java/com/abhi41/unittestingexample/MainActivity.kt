package com.abhi41.unittestingexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelProvider
import com.abhi41.unittestingexample.databinding.ActivityMainBinding
import com.abhi41.unittestingexample.model.Quote
import com.abhi41.unittestingexample.view_model.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val mainViewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setQuote(mainViewModel.getQuote())
        binding.txtNext.setOnClickListener { onNext() }
        binding.txtPrevious.setOnClickListener { onPrevious() }
        binding.floatingActionButton.setOnClickListener { onShare() }

    }
    private fun setQuote(quote: Quote){
        binding.quoteText.text = quote.text
        binding.quoteAuthor.text = quote.author
    }

    private fun onPrevious(){
        setQuote(mainViewModel.previousQuote())
    }

    private fun onNext(){
        setQuote(mainViewModel.nextQuote())
    }
    private fun onShare(){
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT, mainViewModel.nextQuote().text)
        startActivity(intent)
    }
}