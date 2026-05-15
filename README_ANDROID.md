# ForestGuard Native Android App

This folder is now a native Android Studio project for Sahyadri-Samrakshane / ForestGuard.

## Open in Android Studio

1. Open Android Studio.
2. Choose **Open**.
3. Select this folder:

```text
C:\Users\raksh\Desktop\Forest Gaurd
```

4. Let Gradle sync finish.
5. Use **Build > Build Bundle(s) / APK(s) > Build APK(s)**.

## Native App Included

- Kotlin + Jetpack Compose Android app
- Login screen
- Dashboard
- Complete 5-step incident report flow
- Photo capture simulation screen
- GPS location simulation screen
- Details, review, and confirmation screens
- My Reports status timeline
- Education tips
- Officer dashboard mock
- Android permissions prepared for camera, location, notifications, and internet

## Next Integration Steps

The current native app is fully UI/state based so it can run without Firebase setup. The next production steps are:

- Replace photo simulation with CameraX
- Replace location simulation with FusedLocationProviderClient
- Add Room database for offline report caching
- Add Firebase Auth and Firestore
- Add WorkManager sync
- Add Firebase Cloud Messaging notifications
