package git.gprachan.androidcommon.extension

import android.os.Build
import android.text.Html
import android.text.Spanned

/**
 * Convert html string into normal string*/
fun String.htmlToString(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    } else {
        Html.fromHtml(this)
    }
}