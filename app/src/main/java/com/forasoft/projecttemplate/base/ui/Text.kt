@file:Suppress("unused")

package com.forasoft.projecttemplate.base.ui

import android.content.Context
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes

sealed class Text {

    abstract fun getString(context: Context): String

    object Empty : Text() {
        override fun getString(context: Context): String = ""
    }

    /**
     * Represents resource text
     *
     * @property resourceId id of the string
     * @property args parameters for the parametrized string
     */
    class ResourceText(
        @StringRes val resourceId: Int,
        private vararg val args: Any = emptyArray()
    ) : Text() {
        override fun getString(context: Context): String {
            return context.resources.getString(this.resourceId, *this.args)
        }
    }

    class PluralResourceText(
        @PluralsRes val resourceId: Int,
        private val count: Int,
        private vararg val args: Any = emptyArray()
    ) : Text() {
        override fun getString(context: Context): String {
            return context.resources.getQuantityString(this.resourceId, this.count, *this.args)
        }
    }

    /**
     * Represents the plain [String] text
     *
     * @property text plain [String] text
     */
    class StringText(private val text: String) : Text() {
        override fun getString(context: Context): String {
            return text
        }
    }

}