# JARVIS 1.0 — Foundation

A clean Android/Kotlin starting point for a modular personal assistant.

## Current milestone
- Android application shell
- Central `JarvisCore`
- AI provider interface (`IntelligenceAdapter`)
- Basic local event storage (`MemoryStore`)
- Honest diagnostics: no model or voice engine is falsely reported as connected

## Not implemented yet
- AI provider/network calls
- Microphone access or wake-word listening
- Background services
- Device automation
- Full conversation memory

## Project configuration
- Package: `com.jarvis.assistant`
- Minimum Android: API 29 (Android 10)
- Compile SDK: 35
- Kotlin: 2.0.21
- Android Gradle Plugin: 8.7.3
- Gradle: use 8.9 with JDK 17

## Build on an Android phone
1. Install Code on the Go from its official project/release page.
2. Extract this ZIP into a folder named `JARVIS_1_0`.
3. Open/import that folder as a Gradle Android project.
4. Allow the IDE to install/configure its Android SDK and build tools.
5. Use JDK 17 and Gradle 8.9 if the IDE asks for versions.
6. Run the `app` configuration.

If the IDE's bundled toolchain differs, do not randomly change versions. Share the exact build error and toolchain screen so the project can be adjusted deliberately.

## Design rules
- No paid API calls in the initial project.
- Never claim an AI model is connected unless a real adapter is configured.
- Request Android permissions only when a feature needs them.
- Keep each subsystem replaceable and independently testable.
