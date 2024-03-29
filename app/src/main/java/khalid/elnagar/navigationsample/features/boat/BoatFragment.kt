package khalid.elnagar.navigationsample.features.boat


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import khalid.elnagar.navigationsample.R
import khalid.elnagar.navigationsample.features.feed.FeedViewModel
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

            val index = arguments?.getString("index_dl")?.toInt()
                ?: BoatFragmentArgs.fromBundle(arguments!!).index

            Log.d(this.javaClass.simpleName, "index is $index")

            model
                .findBoat(index)
                .apply {
                    txt_name.text = name
                    txt_location.text = location
                    txt_price.text = price
                }

        }


}
