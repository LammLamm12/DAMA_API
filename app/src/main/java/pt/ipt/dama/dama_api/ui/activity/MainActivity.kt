package pt.ipt.dama.dama_api.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import pt.ipt.dama.dama_api.R
import pt.ipt.dama.dama_api.model.Note
import pt.ipt.dama.dama_api.retrofit.RetrofitInitializer
import pt.ipt.dama.dama_api.ui.adapter.NoteListAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listNotes()
    }

    /**
     * function to list all 'notes'
     */
    private fun listNotes() {
        // 'force' the read the notes from the API
        val call = RetrofitInitializer().noteService()
            .listNodes()

        call.enqueue(object : Callback<List<Note>?> {
            /**
             * Invoked for a received HTTP response.
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<List<Note>?>, response: Response<List<Note>?>) {
                response.body()?.let {
                    val notes: List<Note> = it
                    // assign the 'notes' to the user's interface
                    configureList(notes)
                }
            }

            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<List<Note>?>, t: Throwable) {
                t.message?.let {
                    Log.e("something went wrong when we are accessing data from API", it)
                }
            }
        })
    }

    private fun configureList(notes: List<Note>) {
        // 'pointer' to the object that will write the 'notes'
        val recyclerView: RecyclerView = findViewById(R.id.nodeListRecyclerView)
        // assign the 'notes'
        recyclerView.adapter = NoteListAdapter(notes, this)
        // specify how the 'cards' will be written
        val layoutManager=StaggeredGridLayoutManager(
            2,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=layoutManager
    }

} // end of class MainActivity