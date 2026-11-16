package com.jarvis.assistant

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import com.jarvis.assistant.core.JarvisCore

class MainActivity : Activity() {
    private lateinit var statusText: TextView
    private lateinit var responseText: TextView
    private lateinit var core: JarvisCore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        core = JarvisCore(applicationContext)
        buildInterface()
        responseText.text = core.initialize()
    }

    private fun buildInterface() {
        val background = Color.rgb(7, 13, 25)
        val panel = Color.rgb(15, 27, 45)
        val cyan = Color.rgb(75, 210, 255)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 32, 24, 24)
            setBackgroundColor(background)
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER_HORIZONTAL
        }

        val title = TextView(this).apply {
            text = "J.A.R.V.I.S."
            textSize = 30f
            setTextColor(cyan)
            gravity = Gravity.CENTER
            letterSpacing = 0.18f
        }
        content.addView(title, matchWrap())

        val subtitle = TextView(this).apply {
            text = "PERSONAL ASSISTANT SYSTEM"
            textSize = 11f
            setTextColor(Color.LTGRAY)
            gravity = Gravity.CENTER
            letterSpacing = 0.12f
            setPadding(0, 8, 0, 28)
        }
        content.addView(subtitle, matchWrap())

        statusText = TextView(this).apply {
            text = "● CORE INITIALIZING"
            textSize = 14f
            setTextColor(cyan)
            gravity = Gravity.CENTER
            setPadding(18, 18, 18, 18)
            setBackgroundColor(panel)
        }
        content.addView(statusText, matchWrap())

        val responsePanel = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(18, 18, 18, 18)
            setBackgroundColor(panel)
        }
        val responseTitle = TextView(this).apply {
            text = "SYSTEM MESSAGE"
            textSize = 12f
            setTextColor(cyan)
        }
        responseText = TextView(this).apply {
            text = "Starting..."
            textSize = 15f
            setTextColor(Color.WHITE)
            setPadding(0, 12, 0, 0)
        }
        responsePanel.addView(responseTitle, matchWrap())
        responsePanel.addView(responseText, matchWrap())
        val panelParams = matchWrap()
        panelParams.topMargin = 22
        content.addView(responsePanel, panelParams)

        val testButton = Button(this).apply {
            text = "TEST JARVIS CORE"
            setOnClickListener {
                responseText.text = core.runDiagnostics()
                statusText.text = "● CORE READY · FOUNDATION ONLY"
            }
        }
        val buttonParams = matchWrap()
        buttonParams.topMargin = 22
        content.addView(testButton, buttonParams)

        val footer = TextView(this).apply {
            text = "JARVIS 1.0  •  FOUNDATION BUILD"
            textSize = 10f
            setTextColor(Color.GRAY)
            gravity = Gravity.CENTER
            setPadding(0, 34, 0, 8)
        }
        content.addView(footer, matchWrap())

        scroll.addView(content)
        page.addView(scroll, LinearLayout.LayoutParams(-1, 0, 1f))
        setContentView(page)
    }

    private fun matchWrap() = LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.MATCH_PARENT,
        LinearLayout.LayoutParams.WRAP_CONTENT
    )
}
