package com.luseen.ribble.presentation.base_mvp.base

import android.os.Bundle
import android.support.annotation.CallSuper
import com.luseen.arch.BaseMVPActivity
import com.luseen.ribble.App
import com.luseen.ribble.di.component.ActivityComponent
import com.luseen.ribble.di.component.ApplicationComponent
import com.luseen.ribble.di.module.ActivityModule

abstract class BaseActivity<V : BaseContract.View, P : BaseContract.Presenter<V>> : BaseMVPActivity<V, P>() {

    val activityComponent: ActivityComponent by lazy {
        getAppComponent().plus(ActivityModule(this))
    }

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies()
        super.onCreate(savedInstanceState)
    }

    protected abstract fun injectDependencies()

    private fun getAppComponent(): ApplicationComponent {
        return App.instance.applicationComponent
    }
}
