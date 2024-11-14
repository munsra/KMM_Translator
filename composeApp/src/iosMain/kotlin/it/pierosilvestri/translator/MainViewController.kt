package it.pierosilvestri.translator

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import it.pierosilvestri.translator.database.getPeopleDatabase

fun MainViewController() = ComposeUIViewController {
    val peopleDao = remember {
        getPeopleDatabase().peopleDao()
    }
    App(peopleDao)
}