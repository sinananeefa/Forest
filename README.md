# ForestGuard Native Android

Sahyadri-Samrakshane / ForestGuard is now scaffolded as a native Android Studio project using Kotlin and Jetpack Compose.

## Open And Build

1. Open Android Studio.
2. Select **Open**.
3. Choose this folder:

```text
C:\Users\raksh\Desktop\Forest Gaurd
```

4. Let Gradle sync complete.
5. Build an APK from **Build > Build Bundle(s) / APK(s) > Build APK(s)**.

## Included Native Screens

- Login and signup simulation
- Citizen dashboard
- Full incident reporting flow
- Incident type selection
- Photo capture simulation
- GPS location simulation
- Details form
- Review summary
- Submission confirmation with tracking ID
- My Reports status timeline
- Education tips
- Officer dashboard mock

## Android Permissions Prepared

- Camera
- Fine and coarse location
- Internet
- Notifications

## Production Integration Still Needed

The app is native Compose UI/state right now. To make it production-ready, connect:

- CameraX for real photo capture
- FusedLocationProviderClient for real GPS
- Room for offline-first report storage
- Firebase Auth and Firestore
- WorkManager for sync
- Firebase Cloud Messaging for notifications

See `README_ANDROID.md`, `README_UPDATED.md`, and `UI_DESIGN_SYSTEM.md` for details.
