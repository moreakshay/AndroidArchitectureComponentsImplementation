package moreakshay.com.mine.ui.intro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import moreakshay.com.mine.R

class IntroductionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        var pagerAdapter = IntroAdapter(supportFragmentManager)
    }
}
