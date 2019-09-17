package khalid.elnagar.navigationsample.features.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import khalid.elnagar.navigationsample.R
import khalid.elnagar.navigationsample.entities.Boat
import kotlinx.android.synthetic.main.item_boat.view.*

class BoatAdapter(
    private val boats: LiveData<List<Boat>>,
    private val onBoatClicked: (Int) -> Unit,
    lifecycleOwner: LifecycleOwner
) : RecyclerView.Adapter<BoatAdapter.ViewHolder>() {
    init {
        boats.observe(lifecycleOwner, Observer { notifyDataSetChanged() })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        LayoutInflater.from(parent.context).inflate(R.layout.item_boat, parent, false)
            .let { ViewHolder(it) }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val boat = boats.value!![position]
        with(holder.itemView) {
            txt_name.text = boat.name
            txt_location.text = boat.location
            txt_price.text = boat.price
            setOnClickListener { onBoatClicked(position) }
        }

    }

    override fun getItemCount(): Int = boats.value?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}