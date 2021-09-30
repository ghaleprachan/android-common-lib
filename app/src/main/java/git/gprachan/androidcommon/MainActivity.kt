package git.gprachan.androidcommon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import git.gprachan.androidcommon.extension.toastL

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastL("Working")
    }
}