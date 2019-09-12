package khalid.elnagar.navigationsample.features.wolcome_screen.home_screen.orders_screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import khalid.elnagar.navigationsample.R

/**
 * A simple [Fragment] subclass.
 */
class OrdersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_orders, container, false)
    }


}
