package com.example.memorygameforkids

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import com.example.memorygameforkids.databinding.ActivityEasyBinding

class EasyActivity : AppCompatActivity() {
    // burada 2 array yaradiriq , biri sualdaki imageView ucun ,digeri kartlardaki imageView ucun
    // current index fruitsInQuestion arrayinin indeksini gosterir
    var fruits = listOf(R.drawable.machovka_strawberry, R.drawable.kiwi, R.drawable.spktkpkt_banana)
    var fruitsInQuestion = fruits.toList()

    var currentIndex = 0
    var click = 0
    var correctCount = 0

    lateinit var binding: ActivityEasyBinding
    lateinit var cardList: List<ImageView>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEasyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // shuffle burda olmalidi
        fruits = fruits.shuffled()
        fruitsInQuestion = fruitsInQuestion.shuffled()

        cardList = listOf(binding.ivCard1, binding.ivCard2, binding.ivCard3)




        fun callAlert() {
            val alertDialog = AlertDialog.Builder(this)
                .setTitle("Your score : $correctCount/3")
                .setMessage("Would you like to play again?")
                .setIcon(R.drawable.star)
                .setPositiveButton("Yes") { _, _ ->
                    startActivity(intent)
                }
                .setNegativeButton("No") { _, _ ->
                    Intent(this, MainActivity::class.java).also {
                        startActivity(it)
                    }
                }.create().show()
        }


        // Count down timer 10dan geriye sayir ve bitisinde kartlar baglanir
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = "Time: ${millisUntilFinished / 1000}"
                hidebutton()
                showCards()
            }

            override fun onFinish() {
                setQuestion()
                binding.tvTimer.text = ""


            }

        }.start()

        binding.btNext.setOnClickListener {
            currentIndex++
            if (currentIndex <= 2) {
                setQuestion()
                binding.tvAnswer.text = ""

            } else {
                hidebutton()
                callAlert()

            }


        }


    }

    fun setQuestion() {
        hidebutton()
        binding.textViewQuestion.text = "Where was "
        hideCards()
        binding.imageQuestion.setImageResource(fruitsInQuestion[currentIndex])

        binding.ivCard1.setOnClickListener {
            disableClicability()
            click++

            binding.btNext.visibility = View.VISIBLE
            binding.ivCard1.setImageResource(fruits[0])
            if (fruitsInQuestion[currentIndex] == fruits[0]) {
                correctCount++
                binding.tvAnswer.text = "Correct"
            } else {
                binding.tvAnswer.text = "Wrong"
            }
        }

        binding.ivCard2.setOnClickListener {
            disableClicability()
            click++

            binding.btNext.visibility = View.VISIBLE
            binding.ivCard2.setImageResource(fruits[1])

            if (fruitsInQuestion[currentIndex] == fruits[1]) {
                correctCount++
                binding.tvAnswer.text = "Correct"
            } else {
                binding.tvAnswer.text = "Wrong"
            }
        }

        binding.ivCard3.setOnClickListener {
            disableClicability()
            click++

            binding.btNext.visibility = View.VISIBLE
            binding.ivCard3.setImageResource(fruits[2])

            if (fruitsInQuestion[currentIndex] == fruits[2]) {
                correctCount++
                binding.tvAnswer.text = "Correct"
            } else {
                binding.tvAnswer.text = "Wrong"
            }
        }

    }


    fun hideCards() {
        for (i in cardList) {
            i.setImageResource(R.drawable.card)
        }

    }

    fun showCards() {
        binding.ivCard1.setImageResource(fruits[0])
        binding.ivCard2.setImageResource(fruits[1])
        binding.ivCard3.setImageResource(fruits[2])

    }

    fun disableClicability() {
        for (i in cardList) {
            i.isClickable = false
        }

    }


    fun hidebutton() {
        binding.btNext.visibility = View.INVISIBLE
    }


}




