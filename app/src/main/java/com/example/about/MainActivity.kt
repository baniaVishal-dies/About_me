package com.example.about

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.about.databinding.ActivityMain1Binding


class MainActivity : AppCompatActivity() {
    private  lateinit var  binding:ActivityMain1Binding
    private  val myName:MyName=MyName("Vishal Bania")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main1)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main1)
        binding.myName=myName

//        findViewById<Button>(R.id.done_button).setOnClickListener {
//            nickname(it)
//        }
        binding.doneButton.setOnClickListener {
            nickname(it)
        }

    }
    private fun nickname(view:View) {
 //    val nick = findViewById<EditText>(R.id.nick_name)
//       val fill = findViewById<TextView>(R.id.display_nickname)
//        fill.text = nick.text
//        nick.visibility = View.GONE
//        view.visibility=View.GONE
//        fill.visibility=View.VISIBLE
       binding.apply {
    myName?.namenick=nickName.text.toString()
         //  binding.displayNickname.text=binding.nickName.text
           invalidateAll()
           nickName.visibility=View.GONE
           doneButton.visibility=View.GONE
           binding.displayNickname.visibility=View.VISIBLE
      }
        //hides keyboard after typing!
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)


    }
}







