package com.jarvis.assistant.intelligence

/**
 * Every future AI provider will implement this contract.
 * Provider implementations will be added only after the core is tested.
 */
interface IntelligenceAdapter {
    val providerName: String
    suspend fun generateReply(prompt: String): Result<String>
}
