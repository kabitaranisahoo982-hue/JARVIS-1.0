package com.jarvis.assistant.memory

import android.content.Context

/**
 * Small local event store for the first foundation milestone.
 * This is not yet the full long-term conversational memory system.
 */
class MemoryStore(context: Context) {
    private val preferences = context.getSharedPreferences(
        "jarvis_local_memory",
        Context.MODE_PRIVATE
    )

    fun saveSystemEvent(event: String) {
        val count = preferences.getInt("event_count", 0) + 1
        preferences.edit()
            .putInt("event_count", count)
            .putString("last_event", event)
            .apply()
    }

    fun getEventCount(): Int = preferences.getInt("event_count", 0)
    fun getLastEvent(): String? = preferences.getString("last_event", null)
}
