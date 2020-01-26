package dev.weiqi.mmkv

import com.tencent.mmkv.MMKV
import kotlin.reflect.KProperty

class MMKVDelegate<T>(
    private val mmkv: MMKV,
    private val key: String,
    private val defValue: T
) {
    @Suppress("UNCHECKED_CAST")
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return mmkv.run {
            when (defValue) {
                is String -> getString(key, defValue)
                is Boolean -> getBoolean(key, defValue)
                is Long -> getLong(key, defValue)
                is Int -> getInt(key, defValue)
                is Float -> getFloat(key, defValue)
                else -> Unit
            }
        } as T
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        mmkv.run {
            when (value) {
                is String -> putString(key, value)
                is Boolean -> putBoolean(key, value)
                is Long -> putLong(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                else -> Unit
            }
        }
    }
}