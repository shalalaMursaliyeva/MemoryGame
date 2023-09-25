package com.example.memorygameforkids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageView
import com.example.memorygameforkids.databinding.ActivityMediumBinding

class MediumActivity : AppCompatActivity() {
    var toys = listOf(R.drawable.jean_victor_balin_locotoy, R.drawable.pitr_teddy_bear_icon, R.drawable.rg1024_two_ballons, R.drawable.nicubunu_toy_rocket)
    var toysInQuestion = listOf(R.drawable.jean_victor_balin_locotoy, R.drawable.pitr_teddy_bear_icon, R.drawable.rg1024_two_ballons, R.drawable.nicubunu_toy_rocket)
    var currentIndexx = 0

    lateinit var cardList: List<ImageView>
    private lateinit var binding: ActivityMediumBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMediumBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toys = toys.shuffled()
        toysInQuestion = toysInQuestion.shuffled()

        cardList = listOf(binding.card4, binding.card3,binding.card2, binding.card1)




        // Count down timer 10dan geriye sayir ve bitisinde kartlar baglanir
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimerMedium.text = "Time: ${millisUntilFinished / 1000}"
                hidebuttonM()
                showCardsM()
            }

            override fun onFinish() {
                setQuestionM()
                binding.tvTimerMedium.text = ""


            }

        }.start()

        binding.btNextMedium.setOnClickListener {
            currentIndexx++
            setQuestionM()
            binding.tvAnswerMedium.text = ""

        }


    }

    fun setQuestionM() {
        hidebuttonM()
        binding.tvQuestion.text = "Where was "
        hideCardsM()
        binding.imageQuestionMedium.setImageResource(toysInQuestion[currentIndexx])

        binding.card1.setOnClickListener {
            disableClickability()

            binding.btNextMedium.visibility = View.VISIBLE
            binding.card1.setImageResource(toys[0])
            if (toysInQuestion[currentIndexx] == toys[0]) {
                binding.tvAnswerMedium.text = "Correct"
            } else {
                binding.tvAnswerMedium.text = "Wrong"
            }

        }

        binding.card2.setOnClickListener {
            disableClickability()

            binding.btNextMedium.visibility = View.VISIBLE
            binding.card2.setImageResource(toys[1])

            if (toysInQuestion[currentIndexx] == toys[1]) {
                binding.tvAnswerMedium.text = "Correct"
            } else {
                binding.tvAnswerMedium.text = "Wrong"
            }
        }

        binding.card3.setOnClickListener {
            disableClickability()

            binding.btNextMedium.visibility = View.VISIBLE
            binding.card3.setImageResource(toys[2])

            if (toysInQuestion[currentIndexx] == toys[2]) {
                binding.tvAnswerMedium.text = "Correct"
            } else {
                binding.tvAnswerMedium.text = "Wrong"
            }
        }
        binding.card4.setOnClickListener {
            disableClickability()
            binding.btNextMedium.visibility = View.VISIBLE
            binding.card4.setImageResource(toys[3])

            if (toysInQuestion[currentIndexx] == toys[3]) {
                binding.tvAnswerMedium.text = "Correct"
            } else {
                binding.tvAnswerMedium.text = "Wrong"
            }
        }


    }

    private fun disableClickability() {
        for (i in cardList) {
            i.isClickable = false
        }
    }


    fun hideCardsM() {

        for (i in cardList) {
            i.setImageResource(R.drawable.card)
        }

    }

    fun showCardsM() {
        binding.card1.setImageResource(toys[0])
        binding.card2.setImageResource(toys[1])
        binding.card3.setImageResource(toys[2])
        binding.card4.setImageResource(toys[3])

    }


    fun hidebuttonM() {
        binding.btNextMedium.visibility = View.INVISIBLE
    }

}
