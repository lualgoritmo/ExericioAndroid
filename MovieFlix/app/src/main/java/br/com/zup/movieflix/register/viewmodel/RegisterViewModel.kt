package br.com.zup.movieflix.register.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.zup.movieflix.register.model.User
import br.com.zup.movieflix.register.repository.RegisterRepository

class RegisterViewModel() : ViewModel() {
//    viewmodel é o que prepara para ir a view. seria como um controller.

    private var _error: MutableLiveData<String> = MutableLiveData()
    val error:LiveData<String> = _error

    private var _response: MutableLiveData<String> = MutableLiveData()
    val response:LiveData<String> = _response

    val repository = RegisterRepository()

    fun registerUser(name: String, email: String, password: String, confirmPassword: String) {
        if (name.isEmpty()) {
            _error.value = "Nome não pode ser vazio"
            return
        }
        if (email.isEmpty()) {
            _error.value = "E-mail não pode ser vazio"
            return
        }
        if (password.isEmpty()) {
            _error.value = "O password não pode ser vazio"
            return
        }
        if (password != confirmPassword) {
            _error.value = "As senhas precisam ser iguais"
            return
        }
        _response.value =   repository.createUser(User(name, email, password))
    }
    fun getUserData():User {
        return repository.getUserData()
    }

}