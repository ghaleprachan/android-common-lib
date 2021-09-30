package git.gprachan.androidcommon.extension

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar

/**
 * Show short toast
 *
 * [message] is what you want to toast*/
fun Context.toastS(message: String?): Toast {
    return Toast.makeText(this, message.orEmpty(), Toast.LENGTH_SHORT).apply {
        show()
    }
}

/**
 * Show long  toast
 *
 * [message] is what you want to toast*/
fun Context.toastL(message: String?): Toast {
    return Toast.makeText(this, message.orEmpty(), Toast.LENGTH_LONG).apply {
        show()
    }
}

/**
 * Show snackBar
 *
 * [message] message to display
 *
 * [duration] how long snackBar should be shown*/
fun View.snackBar(message: String, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, message, duration).show()
}

/**
 * Show snackBar
 *
 * [resId] is string resource id to display message
 *
 * [duration] how long snackBar should be shown*/
fun View.snackBar(@StringRes resId: Int, duration: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, resId, duration).show()
}