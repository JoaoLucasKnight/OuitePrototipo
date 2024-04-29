package nf3.ouiteprototipo.recycler

interface Eventos<T> {
    fun clica(item: T)
    fun pressiona(item: T)
}