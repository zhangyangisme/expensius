/*
 * Copyright (C) 2016 Mantas Varnagiris.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

package com.mvcoding.expensius.feature

import android.view.ViewGroup
import rx.lang.kotlin.PublishSubject
import rx.subjects.PublishSubject

abstract class BaseClickableAdapter<T, VH : ClickableViewHolder<*>> : BaseAdapter<T, VH>() {
    private val positionClickedSubject = PublishSubject<Int>()

    fun itemPositionClicks() = positionClickedSubject.asObservable()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = onCreateViewHolder(parent, viewType, positionClickedSubject)

    protected abstract fun onCreateViewHolder(parent: ViewGroup, viewType: Int, positionClickedSubject: PublishSubject<Int>): VH
}