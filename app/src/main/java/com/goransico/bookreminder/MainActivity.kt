package com.goransico.bookreminder

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.goransico.bookreminder.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint


/**
 * Main BookReminder Main Activity
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel : MainViewModel by viewModels()
            //val viewModel = hiltViewModel<MainViewModel>()
            BookReminderTheme{
                NavGraph(viewModel)
            }
        }
    }
}