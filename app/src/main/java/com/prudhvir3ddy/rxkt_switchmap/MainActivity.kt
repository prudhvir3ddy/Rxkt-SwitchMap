package com.prudhvir3ddy.rxkt_switchmap

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private val disposables = CompositeDisposable()

    private val subject: PublishSubject<Unit> = PublishSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        disposables += Observable.interval(
            5L,
            5L,
            TimeUnit.SECONDS
        ).flatMap {
            subject.doOnSubscribe {
                Log.d("MainActivity_FlatMap", "Subscribed")
            }.doOnDispose {
                Log.d("MainActivity_FlatMap", "Disposed")
            }
        }.subscribe {
            Log.d("MainActivity_FlatMap", "result: $it")
        }

        disposables += Observable.interval(
            5L,
            5L,
            TimeUnit.SECONDS
        ).switchMap {
            subject.doOnSubscribe {
                Log.d("MainActivity_SwitchMap", "Subscribed")
            }.doOnDispose {
                Log.d("MainActivity_SwitchMap",  "Disposed")
            }
        }.subscribe {
            Log.d("MainActivity_SwitchMap", "result: $it")
        }


        findViewById<Button>(R.id.button).setOnClickListener {
            subject.onNext(Unit)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}