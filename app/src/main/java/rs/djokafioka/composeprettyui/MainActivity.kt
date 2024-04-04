package rs.djokafioka.composeprettyui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import rs.djokafioka.composeprettyui.ui.HomeScreen
import rs.djokafioka.composeprettyui.ui.theme.ComposePrettyUITheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState() // this contains the `SnackbarHostState`
            val scope = rememberCoroutineScope()
            ComposePrettyUITheme {
                Scaffold(
                    modifier = Modifier,
                    scaffoldState = scaffoldState
                ) {
                    val snackbarToShow = {
                        message: String ->
                        scope.launch {
                            scaffoldState.snackbarHostState.showSnackbar(message)
                        }
                    }
                    HomeScreen(
                        onShowSnackbar = snackbarToShow
                    )
                }
            }
        }
    }
}

