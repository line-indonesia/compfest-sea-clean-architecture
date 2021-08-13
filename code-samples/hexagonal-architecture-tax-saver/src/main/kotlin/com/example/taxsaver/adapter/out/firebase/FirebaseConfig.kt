package com.example.taxsaver.adapter.out.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.cloud.FirestoreClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.File
import java.io.FileInputStream

@Configuration
class FirebaseConfig {

    @Bean
    fun firebaseApp(): FirebaseApp {
        val absPath = File("").absolutePath
        val path = "$absPath/src/main/resources/json/firebase-sa-tax-saver.json"

        val serviceAccount = FileInputStream(path)

        val options = FirebaseOptions.builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .build()

        FirebaseApp.initializeApp(options)
        return FirebaseApp.getInstance()
    }

    @Bean
    fun firestore(firebaseApp: FirebaseApp): Firestore {
        return FirestoreClient.getFirestore(firebaseApp)
    }

}
