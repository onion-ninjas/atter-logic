package sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.attendance.checker.events.models.Event
import com.attendance.checker.events.useCases.GetEvents
import com.attendance.checker.events.presenters.EventListPresenter
import com.attendance.checker.events.viewModels.EventListViewModel
import sample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), EventListPresenter {

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

    override fun reloadList() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun navigateTo(event: Event) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
