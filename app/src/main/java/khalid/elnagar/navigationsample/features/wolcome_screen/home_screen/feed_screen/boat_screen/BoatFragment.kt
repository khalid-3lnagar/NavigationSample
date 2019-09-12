package khalid.elnagar.navigationsample.features.wolcome_screen.home_screen.feed_screen.boat_screen


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import khalid.elnagar.navigationsample.R
import khalid.elnagar.navigationsample.features.wolcome_screen.home_screen.feed_screen.FeedViewModel
import kotlinx.android.synthetic.main.fragment_boat.view.*

/**
 * A simple [Fragment] subclass.
 */
class BoatFragment : Fragment() {
    private val model by lazy {
        ViewModelProviders.of(requireActivity()).get(FeedViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_boat, container, false)
        .apply {
            val index = BoatFragmentArgs.fromBundle(arguments!!).index
            Log.d(this.javaClass.simpleName, "index is $index")
            val boat = model.findBoat(index)
            boat?.apply {
                txt_name.text = name
                txt_location.text = location
                txt_price.text = price
            }

        }


}
