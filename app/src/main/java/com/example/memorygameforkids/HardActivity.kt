package com.example.memorygameforkids

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.widget.ImageView
import com.example.memorygameforkids.databinding.ActivityHardBinding


class HardActivity : AppCompatActivity() {
    var animals = listOf(R.drawable.cartoon_lion, R.drawable.dog_3542195, R.drawable.monarch_butterfly_2_variation_9,
        R.drawable.machovka_parrot, R.drawable.lemmling_simple_cartoon_mouse, R.drawable.elephant_svg)
    var animalsQ = listOf(R.drawable.cartoon_lion, R.drawable.dog_3542195,R.drawable.monarch_butterfly_2_variation_9,
        R.drawable.machovka_parrot, R.drawable.lemmling_simple_cartoon_mouse, R.drawable.elephant_svg)
    var index = 0
    lateinit var binding :ActivityHardBinding
    lateinit var cardList: List<ImageView>
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityHardBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        animals = animals.shuffled()
        animalsQ = animalsQ.shuffled()
        cardList = listOf(binding.image1, binding.image2,binding.image3, binding.image4, binding.image5, binding.image6)



        object : CountDownTimer(5000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimerHard.text = "Time: ${millisUntilFinished / 1000}"
                hidebuttons()
                showcards()
            }

            override fun onFinish() {
                setQuestions()
                binding.tvTimerHard.text = ""
            }

        }.start()

        binding.btNextHard.setOnClickListener {
            index++
            setQuestions()
            binding.tvAnswerHard.text = ""

        }

    }

    fun showcards(){
        binding.image1.setImageResource(animals[0])
        binding.image2.setImageResource(animals[1])
        binding.image3.setImageResource(animals[2])
        binding.image4.setImageResource(animals[3])
        binding.image5.setImageResource(animals[4])
        binding.image6.setImageResource(animals[5])

    }
    fun hidecards(){

        for (i in cardList) {
            i.setImageResource(R.drawable.card)
        }
    }
    fun setQuestions(){
        hidebuttons()
        binding.tvQuestionHard.text = "Where was"
        hidecards()
        binding.imageQuestionHard.setImageResource(animalsQ[index])
        binding.image1.setOnClickListener {
            binding.btNextHard.visibility = View.VISIBLE
            binding.image1.setImageResource(animals[0])
            if (animalsQ[index] == animals[0]) {
                binding.tvAnswerHard.text = "Correct"
            } else {
                binding.tvAnswerHard.text = "Wrong"
            }
        }

        binding.image2.setOnClickListener {
            disableClickability()

            binding.btNextHard.visibility = View.VISIBLE
            binding.image2.setImageResource(animals[1])
            if (animalsQ[index] == animals[1]) {
                binding.tvAnswerHard.text = "Correct"
            } else {
                binding.tvAnswerHard.text = "Wrong"
            }
        }

        binding.image3.setOnClickListener {
            disableClickability()

            binding.btNextHard.visibility = View.VISIBLE
            binding.image3.setImageResource(animals[2])
            if (animalsQ[index] == animals[2]) {
                binding.tvAnswerHard.text = "Correct"
            } else {
                binding.tvAnswerHard.text = "Wrong"
            }
        }

        binding.image4.setOnClickListener {
            disableClickability()

            binding.btNextHard.visibility = View.VISIBLE
            binding.image4.setImageResource(animals[3])
            if (animalsQ[index] == animals[3]) {
                binding.tvAnswerHard.text = "Correct"
            } else {
                binding.tvAnswerHard.text = "Wrong"
            }
        }

        binding.image5.setOnClickListener {
            disableClickability()

            binding.btNextHard.visibility = View.VISIBLE
            binding.image5.setImageResource(animals[4])
            if (animalsQ[index] == animals[4]) {
                binding.tvAnswerHard.text = "Correct"
            } else {
                binding.tvAnswerHard.text = "Wrong"
            }
        }

        binding.image6.setOnClickListener {
            disableClickability()

            binding.btNextHard.visibility = View.VISIBLE
            binding.image6.setImageResource(animals[5])
            if (animalsQ[index] == animals[5]) {
                binding.tvAnswerHard.text = "Correct"
            } else {
                binding.tvAnswerHard.text = "Wrong"
            }
        }




    }
    private fun disableClickability() {
        for (i in cardList) {
            i.isClickable = false
        }
    }


    fun hidebuttons(){
        binding.btNextHard.visibility = View.INVISIBLE
    }
}