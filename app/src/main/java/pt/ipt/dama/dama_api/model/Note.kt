package pt.ipt.dama.dama_api.model


import com.google.gson.annotations.SerializedName

/**
 * class to represent the data structure,
 * obtained from API
 */
class Note(
    @SerializedName("title") val title: String,
    @SerializedName("description")  val description: String
)

// the @SerializedName tag is used to express the name
// of your data that came from the API
// https://stackoverflow.com/questions/28957285/what-is-the-basic-purpose-of-serializedname-annotation-in-android-using-gson