package nf3.ouiteprototipo.model

import java.util.Objects

class Generico<T>(t: T){

    private var t: T = t

    fun obter():T{
        return t
    }
}
interface teste {
    fun validaNome(nomeId: String, item: Any?): String? {
        if (nomeId.isEmpty()) {
            return "Campo vazio"
        } else if (item != null) {
            return "Nome Já existe"
        } else {
            return null
        }
    }

    fun validaPai(paiNameId: String?,item: String?): String? {
        if (paiNameId != null) {
            if (paiNameId.isEmpty()) {
                return "Campo Vazio"
            } else if (item == null) {
                return "Space ou Box não existe"
            } else {
                return null
            }
        }
        return "pai null"
    }}

