package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.livedata.observeAsState
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.littlelemon.composables.NavigationComposable
import com.example.littlelemon.model.MenuItemNetwork
import com.example.littlelemon.model.MenuNetwork
import com.example.littlelemon.storage.MenuItemDatabase
import com.example.littlelemon.storage.MenuItemRoom
import com.example.littlelemon.ui.theme.LittleLemonTheme
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    // use ktor client to get menu items from the API
    private val client = HttpClient(Android){
        install(ContentNegotiation){
            json(contentType = ContentType("text", "plain"))
        }
    }

    private suspend fun getMenuItems(): List<MenuItemNetwork> {
        val response: MenuNetwork =
            client.get(
                "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
            ).body()
        return response.menu
    }

    //create MenuItemDatabase (database) by lazy to not stop the app when creating the database
    private val menuDb by lazy {
        Room.databaseBuilder(applicationContext, MenuItemDatabase::class.java, "menu_items_db").build()
    }

    private fun saveMenuToDatabase(menuItemsNetwork: List<MenuItemNetwork>){
        // convert each item to MenuItemRoom to save to db
        val menuItems = menuItemsNetwork.map { it.toMenuItemNetwork() }
        // save to db with a menuItems as a de-structured array
        menuDb.menuItemDao().insertAll(*menuItems.toTypedArray())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //use Dispatchers.IO for network calls and room calls
        lifecycleScope.launch(Dispatchers.IO) {
            //save menu items to database when empty because it persists
            if(menuDb.menuItemDao().isEmpty()){
                saveMenuToDatabase(getMenuItems())
            }

        }
        enableEdgeToEdge()
        setContent {
            LittleLemonTheme {
                val databaseMenuItems = menuDb
                    .menuItemDao()
                    .getAll()
                    .observeAsState(
                        initial = emptyList<MenuItemRoom>()
                    ).value
                val navController = rememberNavController()
                NavigationComposable(navController)
            }
        }
    }
}