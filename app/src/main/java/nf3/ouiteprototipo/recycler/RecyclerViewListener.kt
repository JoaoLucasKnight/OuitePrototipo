package nf3.ouiteprototipo.recycler

import nf3.ouiteprototipo.model.Space
interface RecyclerViewListener<T> {
    fun onItemClick(item: T)
    fun onItemLongClick(item: T)
}