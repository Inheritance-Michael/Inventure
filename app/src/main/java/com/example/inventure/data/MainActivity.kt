import com.example.inventure.data.ItemDatabase


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.inventure.data.Item
import com.example.inventure.ui.theme.InventureTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val db = ItemDatabase.getDatabase(applicationContext)
        val dao = db.itemDao()

        CoroutineScope(Dispatchers.IO).launch {
            dao.insertItem(
                Item(
                    name = "Apple",
                    description = "Fresh red apple",
                    price = 1.5
                )
            )
        }

        setContent {
            InventureTheme {
                Scaffold(modifier = Modifier.Companion.fillMaxSize()) {
                    Text("Welcome to Inventory App!")
                }
            }
        }
    }
}