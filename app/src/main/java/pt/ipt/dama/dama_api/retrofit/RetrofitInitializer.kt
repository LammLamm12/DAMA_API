package pt.ipt.dama.dama_api.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import pt.ipt.dama.dama_api.retrofit.service.NoteService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * we write here the link to API
 */
class RetrofitInitializer {

    //link to API

    private val host = "https://adamastor.ipt.pt/dam-API/"

    // The GSON tool is the one that we use to convert JSON
    // read by Retrofit
    // the parameter .setLenient() should be used only at
    //     developer mode
    private val gson: Gson = GsonBuilder().setLenient().create()

    private val retrofit = Retrofit.Builder()
        .baseUrl(host)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    // function that really uses the retrofit service
    fun noteService():NoteService=retrofit.create(NoteService::class.java)


}