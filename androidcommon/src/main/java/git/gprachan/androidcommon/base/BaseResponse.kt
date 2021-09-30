package git.gprachan.androidcommon.base

import com.google.gson.annotations.SerializedName

open class BaseResponse {
    @Deprecated("not used in api")
    val success: Boolean = false
    val message: String? = null
}

open class BaseErrorEntity(
    @SerializedName("error")
    open var error: String? = null,
    @SerializedName("detail")
    open var detail: String? = null,
    @SerializedName("non_field_errors")
    val nonFieldErrors: List<String>? = null,
    @SerializedName("errors")
    var errors: List<String>? = null,
    @SerializedName("arrival_date")
    var arrivalData: ArrivalDate? = null
) : BaseResponse()

data class ArrivalDate(
    val arrival_date: String? = null
)
