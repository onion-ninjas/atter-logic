package sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.attendance.checker.events.Event
import com.attendance.checker.events.GetEvents
import com.attendance.checker.events.SaveEvent
import sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val usecase = GetEvents()
        val osiem = usecase()
        SaveEvent().save(Event(id="", name ="", eventDate = DateTime(), attendeesCount = 100))
        binding.mainText.text = "items count = ${osiem.size}"
    }
}
