package com.example.androidproject.settings

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.androidproject.databinding.ActivitySettingsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class SettingsActivity : AppCompatActivity() {

    companion object {
        const val KEY_DARK_MODE = "key_dark_mode"
    }

    private lateinit var binding: ActivitySettingsBinding
    private var firstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Get setting values
        CoroutineScope(Dispatchers.IO).launch {
            getSettings().filter { firstTime }.collect { settingsModel ->
                if (settingsModel != null) {
                    runOnUiThread { binding.switchDarkMode.isChecked = settingsModel.darkMode }
                    firstTime = !firstTime
                }
            }
        }

        initUI()
    }

    private fun initUI() {
        binding.switchDarkMode.setOnCheckedChangeListener { _, value ->
            CoroutineScope(Dispatchers.IO).launch { saveSettings(KEY_DARK_MODE, value) }
        }
    }

    private suspend fun saveSettings(key: String, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[booleanPreferencesKey(key)] = value
        }
    }

    private fun getSettings(): Flow<SettingsModel?> {
        return dataStore.data.map { preferences ->
            SettingsModel(
                darkMode = preferences[booleanPreferencesKey(KEY_DARK_MODE)] ?: false
            )
        }
    }
}