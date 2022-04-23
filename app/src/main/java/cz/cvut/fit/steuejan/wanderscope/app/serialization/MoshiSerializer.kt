package cz.cvut.fit.steuejan.wanderscope.app.serialization

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class MoshiSerializer : Serializer<Moshi> {

    override fun getSerializer(): Moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

    override fun <E : Any> fromJson(json: String, clazz: Class<E>): E? {
        return getSerializer().adapter(clazz).fromJson(json)
    }
}