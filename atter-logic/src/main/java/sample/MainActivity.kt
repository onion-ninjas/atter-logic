package sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import events.GetEvents

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val usecase = GetEvents()
        val osiem = usecase()
    }
}
