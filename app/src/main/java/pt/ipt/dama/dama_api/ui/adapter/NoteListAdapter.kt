package pt.ipt.dama.dama_api.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.ipt.dama.dama_api.R
import pt.ipt.dama.dama_api.model.Note

class NoteListAdapter(
    private val notes:List<Note>,
    private val context:Context
):RecyclerView.Adapter<NoteListAdapter.ViewHolder>()
{
    /**
     * get the number of elements from List<notes>
     */
    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context)
            .inflate(R.layout.note_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int) {
        val note=notes[position]
        holder.bindView(note)
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindView(note: Note){
            val auxTitle:TextView=itemView.findViewById(R.id.noteItem_title)
            val auxDescription:TextView=itemView.findViewById(R.id.noteItem_description)
            // assign the data from the 'note' to the user's interface
            auxTitle.text=note.title
            auxDescription.text=note.description
        }
    }

}
