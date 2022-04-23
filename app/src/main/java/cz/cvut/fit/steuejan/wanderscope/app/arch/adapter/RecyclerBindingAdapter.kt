package cz.cvut.fit.steuejan.wanderscope.app.arch.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@BindingAdapter("recyclerItems")
fun <T : RecyclerItem> RecyclerView.bindRecyclerItems(recyclerItems: List<T>?) {
    setAdapterIfNull()
    @Suppress("UNCHECKED_CAST")
    (adapter as DataBindingAdapter<T>).submitList(recyclerItems)
}

private fun RecyclerView.setAdapterIfNull() {
    if (this.adapter == null) {
        this.adapter = DataBindingAdapter.UniversalAdapter()
    }
}