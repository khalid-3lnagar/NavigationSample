package khalid.elnagar.navigationsample.features.wolcome_screen


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import khalid.elnagar.navigationsample.R
import kotlinx.android.synthetic.main.fragment_welcome.view.*

/**
 * A simple [Fragment] subclass.
 */
class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_welcome, container, false)
        .apply {

            btn_login.setOnClickListener {
                val email = etxt_email.text.toString()
                val password = etxt_password.text.toString()

                if (email.isNotEmpty() && password.isNotEmpty())
                    findNavController().navigate(R.id.action_welcomeFragment_to_homeFragment)
            }

            Navigation
                .createNavigateOnClickListener(R.id.action_welcomeFragment_to_registrationFragment)
                .also(btn_register::setOnClickListener)
        }


}
