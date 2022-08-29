package com.example.nativo

import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity: FlutterActivity() {

    private val CHANNEL = "neto.com.br/nativo"

   fun configureFlutterEngine(flutterEngine: FlutterEngine){
        super.configureFlutterEngine(flutterEngine)

      MethodChannel(
           flutterEngine.dartExecutor.binaryMessenger,
           CHANNEL
       ).setMethodCallHandler { call, result ->

           if (call.method == "calcSum") {
               val a = call.argument<Int>(key:"a")?.toInt() ?: 0
               val b = call.argument<Int>(key:"b")?.toInt() ?: 0
               result.success(result a + b)

           } else {
               result.notImplemented()
           }
       }
   }
}


