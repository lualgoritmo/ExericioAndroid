package br.com.zup.movieflix.register.repository

import br.com.zup.movieflix.register.model.User

class RegisterRepository {
    fun getUserData(): User {
        return User("","","")
    }

    fun updateUserData(user: User):String {
        return "Usuário Salvo ${user.name}"
    }

    fun createUser(user: User): String {
        return "Usuário criado: ${user.email}, ${user.email}, ${user.password}"
    }

}