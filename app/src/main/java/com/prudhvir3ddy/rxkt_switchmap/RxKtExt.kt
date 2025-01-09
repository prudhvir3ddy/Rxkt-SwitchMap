package com.prudhvir3ddy.rxkt_switchmap

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

operator fun CompositeDisposable?.plusAssign(disposable: Disposable) {
    this?.add(disposable)
}