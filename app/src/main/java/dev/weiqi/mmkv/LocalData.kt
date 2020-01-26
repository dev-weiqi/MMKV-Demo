package dev.weiqi.mmkv

import android.content.Context
import com.tencent.mmkv.MMKV

class LocalData(appContext: Context) {

    private val mmkv = MMKV.initialize(appContext).run { MMKV.defaultMMKV() }

    var username: String by MMKVDelegate(mmkv, "key_username", "")
    var isLogin: Boolean by MMKVDelegate(mmkv, "key_is_login", false)
}