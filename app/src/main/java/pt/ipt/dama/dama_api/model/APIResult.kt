package pt.ipt.dama.dama_api.model

import com.google.gson.annotations.SerializedName

/**
 * define the structure of data to send to API
 */
class APIResult(
    //@SerializedName("title") val title: String?,
    @SerializedName("description") val description: String?
)