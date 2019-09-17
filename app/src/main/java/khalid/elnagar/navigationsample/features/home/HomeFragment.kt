package khalid.elnagar.navigationsample.features.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import khalid.elnagar.navigationsample.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)
        .apply {

            val navController =
                childFragmentManager
                    .let { it.findFragmentById(R.id.fragment_container) as NavHostFragment }
                    .navController

            bottom_nav_view.setupWithNavController(navController)


            navController
                .addOnDestinationChangedListener { _, destination, _ ->
                    toolbar.title = destination.label

                }


        }

}
