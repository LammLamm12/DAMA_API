package pt.ipt.dama.dama_api.retrofit.service

import pt.ipt.dama.dama_api.model.Note
import retrofit2.Call
import retrofit2.http.GET


/**
 * interface where the endpoints of the API are defined
 */
interface NoteService {

    /**
     * function to read data from API
     * transform data in JSON format to Kotlin objects
     */
    @GET("api/notes")
    fun listNodes(): Call<List<Note>>


}