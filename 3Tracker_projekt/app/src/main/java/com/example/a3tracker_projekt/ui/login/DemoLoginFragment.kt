import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.a3tracker_projekt.api.login.LoginRequest
import com.example.a3tracker_projekt.api.users.MyApplication
import com.example.a3tracker_projekt.repo.TrackerRepository
import com.example.a3tracker_projekt.ui.login.DemoLoginViewModel
import com.example.a3tracker_projekt.ui.login.DemoLoginViewModelFactory
import com.example.a3tracker_projekt.ui.login.LoginResult
import com.example.projekt.R

class DemoLoginFragment : Fragment() {

    //    private var _binding: FragmentDemoLoginBinding? = null
//
//    private val binding get() = _binding!!
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        val demoLoginViewModel =
//            ViewModelProvider(this).get(DemoLoginViewModel::class.java)
//        _binding = FragmentDemoLoginBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val navController = findNavController()
//
//
//
//        binding.projectDemoLoginButton.setOnClickListener {
//            demoLoginViewModel.login(
//                binding.projectDemoEmail.text.toString(),
//                binding.projectDemoPassword.text.toString()
//            )
//            demoLoginViewModel.loginResult.observe(viewLifecycleOwner) {
//                if (it == LoginResult.LOADING) {
//                    return@observe
//                }
//                Toast.makeText(activity, it.toString(), Toast.LENGTH_LONG).show()
//                if (it == LoginResult.SUCCESS) {
//                    navController.navigate(R.id.profileFragment)
//                } else {
//                    navController.navigate(R.id.navigation_login)
//                }
//            }
//        }
//        return root
//    }
//
//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }

    private lateinit var DemologinViewModel: DemoLoginViewModel
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button: Button
    private lateinit var showPwImg: ImageView
    private lateinit var hidePwImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = DemoLoginViewModelFactory(TrackerRepository())
        DemologinViewModel = ViewModelProvider(this, factory).get(DemoLoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewItems()
        registerListeners()
        DemologinViewModel.loginResult.observe(viewLifecycleOwner) {
            // Save data to preferences
            if (it == LoginResult.INVALID_CREDENTIALS) {
                Toast.makeText(
                    this.requireContext(),
                    "Invalid credentials",
                    Toast.LENGTH_LONG
                ).show()
            }
            if (it == LoginResult.SUCCESS) {
                val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
                val edit = prefs.edit()
                edit.putString("token", MyApplication.token)
                edit.putLong("deadline", MyApplication.deadline)
                edit.putString("email", editText1.text.toString())
                edit.apply()
                findNavController().navigate(R.id.profileFragment)
            }
        }

        val prefs = requireActivity().getPreferences(Context.MODE_PRIVATE)
        if (!prefs.getString("email", "").equals("")) {
            editText1.setText(prefs.getString("email", ""))
        }
    }

    private fun initViewItems() {
        showPwImg = requireView().findViewById(R.id.imageViewShowPW)
        hidePwImg = requireView().findViewById(R.id.imageViewHidePW)
        editText1 = requireView().findViewById(R.id.project_demo_email)
        editText2 = requireView().findViewById(R.id.project_demo_password)
        button = requireView().findViewById(R.id.login_button)
    }


    private fun registerListeners() {
        button.setOnClickListener {
            val email = editText1.text.toString().trim()
            val password = editText2.text.toString().trim()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(
                    this.requireContext(),
                    "Please, enter your email and password",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                DemologinViewModel.login(LoginRequest(email, password))
            }
        }
    }
}
