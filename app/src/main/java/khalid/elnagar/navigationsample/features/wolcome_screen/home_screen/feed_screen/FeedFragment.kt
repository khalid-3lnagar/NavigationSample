package khalid.elnagar.navigationsample.features.wolcome_screen.home_screen.feed_screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import khalid.elnagar.navigationsample.R
import khalid.elnagar.navigationsample.features.wolcome_screen.home_screen.HomeFragmentDirections
import kotlinx.android.synthetic.main.fragment_feed.view.*

/**
 * A simple [Fragment] subclass.
 */
class FeedFragment : Fragment() {
    private val model by lazy {
        ViewModelProviders.of(requireActivity()).get(FeedViewModel::class.java)
    }
    private val boatAdapter by lazy {
        BoatAdapter(model.getBoatsLiveData(), ::onBoatClicked, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_feed, container, false)
        .apply {
            rv_boats.adapter = boatAdapter
            rv_boats.layoutManager = LinearLayoutManager(requireActivity())
            model.startLoading()
        }

    private fun onBoatClicked(boatIndex: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToBoatFragment(boatIndex)
        activity?.findNavController(R.id.nav_container)?.navigate(action)
    }
}
