package com.mona15.recetas.country.model

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.mona15.recetas.map.model.LocationParcelable
import kotlinx.serialization.json.Json

object LocalizationParcelableNavType: NavType<LocationParcelable>(isNullableAllowed = false){

    override fun put(bundle: Bundle, key: String, value: LocationParcelable) {
        bundle.putParcelable(key, value)
    }

    override fun get(bundle: Bundle, key: String): LocationParcelable? {
        return bundle.getParcelable(key) as LocationParcelable?
    }

    override fun parseValue(value: String): LocationParcelable {
        return Json.decodeFromString(Uri.decode(value))
    }
}