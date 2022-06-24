package br.com.zup.movieflix.register.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import br.com.zup.movieflix.R
import br.com.zup.movieflix.databinding.ActivityRegisterBinding
import br.com.zup.movieflix.register.viewmodel.RegisterViewModel
import com.google.android.material.snackbar.Snackbar

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by lazy {
        ViewModelProvider(this)[RegisterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val user = viewModel.getUserData()
        binding.etUserNameRegister.setText(user.name)
        binding.etEmailRegister.setText(user.email)
        binding.etPasswordRegister.setText(user.password)
        binding.etConfirmPasswordRegister.setText(user.password)

        viewModel.error.observe(this) {
            val snackBar = Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
            snackBar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.orange_500))
            snackBar.show()
        }
        viewModel.response.observe(this) {
            val snackBar = Snackbar.make(binding.root, it, Snackbar.LENGTH_LONG)
            snackBar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
            snackBar.show()
        }

        binding.btRegister.setOnClickListener {
            val name = binding.etUserNameRegister.text.toString()
            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val confirmPassword = binding.etConfirmPasswordRegister.text.toString()

            viewModel.registerUser(name, email, password, confirmPassword)
        }
    }
}