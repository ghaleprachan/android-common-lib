package git.gprachan.androidcommon.handler

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import git.gprachan.androidcommon.base.BaseErrorEntity
import git.gprachan.androidcommon.utils.UiState
import retrofit2.Response

/**
 * This is to handle response from APIs
 * It generated error message based on server response
 * */
suspend fun <T> Response<T>.handleResponse(doActionOnSuccess: suspend (body: T) -> Unit = {}): UiState<T> {
    val genericErrorMessage = "Error encountered. Please try again later."
    return if (isSuccessful) {
        if (body() != null) {
            doActionOnSuccess.invoke(body()!!)
            UiState.Success(body()!!)
        } else {
            UiState.Error(message())
        }
    } else if (code() in listOf(401)) {
        UiState.Error(message(), code())
    } else {
        val errorBody = errorBody()?.string()
        return try {
            val errorModel = Gson().fromJson(errorBody, BaseErrorEntity::class.java)
            UiState.Error(
                errorModel.error ?: errorModel.message ?: errorModel.detail
                ?: errorModel.errors?.get(0)
                ?: errorModel.nonFieldErrors?.first()
                ?: errorModel.arrivalData?.arrival_date
                ?: throw Exception("Thrown to try another approach!")
            )
        } catch (e: Exception) {
            val type = object : TypeToken<Map<String, List<String>>>() {}.type
            val data: Map<String, List<String>> = Gson().fromJson(errorBody, type)
            return if (!data.isNullOrEmpty()) {
                val firstEntry = data.entries.iterator().next()
                val errorMessage = firstEntry.value
                if (errorMessage.isNullOrEmpty()) {
                    UiState.Error(message())
                } else {
                    UiState.Error(errorMessage.first())
                }
            } else {
                UiState.Error(message())
            }
        } catch (e: Exception) {
            val stringArrayType = object : TypeToken<List<String>>() {}.type
            val arrayMessages: List<String> = Gson().fromJson(errorBody, stringArrayType)
            return if (!arrayMessages.isNullOrEmpty()) {
                UiState.Error(arrayMessages[0])
            } else {
                UiState.Error(message())
            }
        } catch (e: Exception) {
            UiState.Error(genericErrorMessage)
        }
    }
}
