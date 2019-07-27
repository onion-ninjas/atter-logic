package sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.attendance.checker.events.Event
import com.attendance.checker.events.GetEvents
import com.attendance.checker.events.presenters.EventListPresenter
import com.attendance.checker.events.viewModels.EventListViewModel
import sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: EventListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val usecase = GetEvents()
        val osiem = usecase()
        binding.mainText.text = "items count = ${osiem.size}"

        viewModel = EventListViewModel.instance(this)
        viewModel.refresh()
    }
}
