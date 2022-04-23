package cz.cvut.fit.steuejan.wanderscope.app.serialization

interface Serializer<T> {
    fun getSerializer(): T
    fun <E : Any> fromJson(json: String, clazz: Class<E>): E?
}

inline fun <reified E : Any> Serializer<*>.fromJson(json: String) = fromJson(json, E::class.java)