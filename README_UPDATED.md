# Sahyadri-Samrakshane (ForestGuard) 🌿

**Citizen-Powered Forest Protection Mobile Application**

A mobile app that enables citizens to report environmental incidents (forest fires, landslides, illegal logging, wildlife sightings) to forest authorities instantly with photo evidence and precise GPS location. Features a beautiful green-themed UI designed for usability in remote forest areas.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Design System](#design-system)
- [User Interface](#user-interface)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Installation & Setup](#installation--setup)
- [Project Structure](#project-structure)
- [Firebase Configuration](#firebase-configuration)
- [How to Run](#how-to-run)
- [Usage Guide](#usage-guide)
- [Reporting Flow (Step-by-Step)](#reporting-flow-step-by-step)
- [API Integration](#api-integration)
- [Architecture](#architecture)
- [Testing](#testing)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)
- [Contact & Support](#contact--support)

---

## 📱 Overview

**Sahyadri-Samrakshane** (Protection of the Sahyadri Range) is a Forest Sentinel application designed to bridge the gap between local communities and forest authorities.

### The Problem
The Western Ghats face constant threats from forest fires, illegal logging, and landslides. Local communities witness these incidents first but have no direct way to alert forest authorities with precise location data.

### The Solution
A mobile app that:
- Allows any citizen to report incidents in **< 2 minutes**
- Captures **photo evidence** + **precise GPS location**
- Works **offline** in no-signal forest areas
- Provides **real-time status tracking**
- Features **beautiful green-themed UI** for environmental consciousness
- Enables **instant response** by forest departments

### Impact
🌿 Faster response to environmental incidents
🤝 Empowers communities in forest protection
📍 Accurate location data reduces response time from hours to minutes
🎨 Intuitive design works for everyone, even non-tech users

---

## ✨ Features

### MVP (Must-Have Features)

✅ **User Authentication**
- Email & Google Sign-In
- Secure session management
- User profile creation

✅ **Incident Reporting (5-Step Flow)**
1. **Select Incident Type** — Choose from Fire, Landslide, Illegal Cutting, Wildlife
2. **Take Photo** — Capture clear evidence with in-app camera
3. **GPS Location** — Auto-capture precise coordinates
4. **Add Details** — Enter address and description
5. **Review & Submit** — Confirm all details before submission

✅ **GPS & Location**
- High-precision GPS via FusedLocationProviderClient
- Lat/Long display on-screen before submission
- Map view of incident location
- Accuracy indicator

✅ **Offline-First Caching**
- Local storage using Room Database
- Automatic sync when connectivity returns
- "Pending Sync" status indicator
- Zero data loss guarantee

✅ **Real-Time Status Tracking**
- 4-stage status: Reported → Verified → Team Dispatched → Resolved
- Firebase Firestore real-time updates
- Status history view with timeline

✅ **Push Notifications**
- Instant alerts on status changes
- Firebase Cloud Messaging (FCM)
- Customizable notification preferences

✅ **Forest Department Dashboard**
- Incident map view
- Photo + metadata display
- Status update controls
- Response team dispatch

✅ **Education Module**
- Eco-zone safety tips
- Fire safety guidelines
- Wildlife encounter protocols
- Landslide preparedness guide

✅ **Nature-Friendly UI**
- Green/earth-tone color palette (see Design System)
- Eco-themed icons
- Responsive design
- Accessibility support

### Future Enhancements (Good-to-Have)

- GenAI auto-classification of incident type from photo
- Heatmap showing incident clusters
- Multilingual support (Kannada, Hindi)
- Gamification (badges for active reporters)
- Photo annotation tool
- Emergency SOS mode
- Dark mode

---

## 🎨 Design System

### Color Palette (Green Variants)

The app uses a nature-inspired **green color system** that represents environmental protection and builds user trust.

#### Primary Colors

| Color | Hex Code | RGB | Usage |
|-------|----------|-----|-------|
| **Forest Green** | #2D6A4F | 45, 106, 79 | Headers, primary buttons, dark accents |
| **Medium Green** | #40916C | 64, 145, 108 | Secondary buttons, active states |
| **Light Green** | #95D5B2 | 149, 213, 178 | Borders, dividers, light accents |
| **Pale Green** | #D8F3DC | 216, 243, 220 | Card backgrounds, light sections |
| **Cream/Background** | #FEFAE0 | 254, 250, 224 | App background |
| **Dark Text** | #1B1B1B | 27, 27, 27 | All text content |

#### Supporting Colors

| Color | Hex Code | RGB | Usage |
|-------|----------|-----|-------|
| **Success Green** | #059669 | 5, 150, 105 | Success messages, checkmarks |
| **Warning Orange** | #F4A261 | 244, 162, 97 | Warnings, pending states |
| **Error Red** | #DC2626 | 220, 38, 38 | Errors, critical alerts |
| **Medium Grey** | #6B7280 | 107, 178, 128 | Secondary text, placeholders |

### Color Usage Examples

```
✅ Forest Green (#2D6A4F)   — App bar, primary buttons
✅ Medium Green (#40916C)   — Secondary buttons, FAB
✅ Light Green (#95D5B2)    — Borders, dividers
✅ Pale Green (#D8F3DC)     — Card backgrounds
✅ Cream (#FEFAE0)          — Overall app background
```

**Why Green?**
- Represents nature and environmental protection
- Builds trust and safety perception
- Calming for stressful situations (emergency reporting)
- Accessible and recognizable globally

---

## 📱 User Interface

### Design Overview

The ForestGuard UI is designed to be **intuitive, beautiful, and accessible** to users of all technical levels, even in low-literacy regions.

### Key Design Principles

✅ **Simplicity** — 5-step form instead of complex multi-page wizard
✅ **Visual Communication** — Icons and colors guide users
✅ **Clear CTAs** — Large buttons with descriptive text
✅ **Real-time Feedback** — Users see progress and status immediately
✅ **Offline Awareness** — Clear "Pending Sync" indicators
✅ **Accessibility** — Large touch targets (48dp minimum), high contrast

### Complete Screen Designs

#### Screen 1: Login/Home Screen
```
🌿 Forest Guard Header (Forest Green)
   
Welcome message
"Login to protect our forests"

[Email input field]
[Password input field]

[Sign In button - Medium Green]

─── OR ───

[Sign in with Google - Secondary button]

"Don't have account? Sign Up"
```

**Design Specs:**
- Top bar: Forest Green, 56dp height
- Input fields: White background, Light Green borders, 56dp height
- Buttons: Full width with 16dp margin
- Spacing: 24dp between elements

#### Screen 2: Main Dashboard
```
🏠 Home Tab (Selected)

"Welcome, [User Name]!"
"Western Ghats Region"

Active Reports Card (Pale Green)
- Active Reports: 3
- Verified: 1 | Dispatched: 2

Recent Activity Section
┌─────────────────────────┐
│ 🔥 Forest Fire          │
│ ID: FG-2024-001234      │
│ Status: ✓ Verified      │
│ 2 hours ago             │
└─────────────────────────┘

┌─────────────────────────┐
│ 🌊 Landslide - Road     │
│ ID: FG-2024-001233      │
│ Status: ⏳ Pending Sync  │
│ 30 minutes ago          │
└─────────────────────────┘

Floating Action Button (➕)
Bottom: [Home] [My Reports] [Tips]
```

**Design Specs:**
- Cards: Pale Green background with Light Green borders
- FAB: 56dp circular, Medium Green, bottom-right corner
- Bottom tabs: Forest Green for active, Grey for inactive
- Status badges: Green (✓) for verified, Brown (⏳) for pending

#### Screen 3: Select Incident Type (Step 1/5)
```
← Report Incident                    Step 1/5

[Progress bar: 20% filled - Forest Green]

"What did you see?"
"Select incident type"

┌──────────────────────┐
│ 🔥 Forest Fire       │
│ Rapid spread flames  │
└──────────────────────┘

┌──────────────────────┐
│ 🌊 Landslide         │
│ Earth/rock collapse  │
└──────────────────────┘

┌──────────────────────┐
│ 🪓 Illegal Cutting   │
│ Unauthorized felling │
└──────────────────────┘

┌──────────────────────┐
│ 🦁 Wildlife Sighting │
│ Animal encounter     │
└──────────────────────┘

[Next: Take Photo] ← Green Button
```

**Design Specs:**
- Progress bar: Light Green fill (20%)
- Cards: Pale Green, 120dp height, clickable
- Selected: Forest Green border (2dp)
- Button: Medium Green, 56dp height, full width

#### Screen 4: Take Photo (Step 2/5)
```
← Take Photo                         Step 2/5

[Progress bar: 40% filled]

"Take a clear photo of the incident"

╔════════════════════╗
║   CAMERA VIEW      ║
║  (Live feed here)  ║
║                    ║
║      📸            ║
║                    ║
║   Take a clear,    ║
║   well-lit photo   ║
╚════════════════════╝

       [📷 Capture]     ← Circular button, 64dp

[🖼️ Upload from Gallery]
```

**Design Specs:**
- Camera preview: Full width, 240dp height
- Capture button: Circular, 64dp, Medium Green, White icon
- Secondary button: Light Green outline, 48dp
- Guidance text: Body Small, centered, grey

#### Screen 5: Photo Review (Step 3/5)
```
← Confirm Photo                      Step 3/5

[Progress bar: 60% filled]

"Photo looks good? 📸"

╔════════════════════╗
║ [Photo Preview]    ║
║ 📸 Evidence        ║
│                    │
│ Forest Fire event  │
│ Clear conditions   │
║                    ║
╚════════════════════╝

Photo taken at:
13.1234°N, 75.5678°E
2024-01-15 14:32:00

[✓ This looks good]
[🔄 Retake Photo]
```

**Design Specs:**
- Photo area: 320dp x 240dp, rounded corners (8dp)
- Metadata: Body Small, grey, centered
- Buttons: 56dp height, full width with 16dp margins

#### Screen 6: GPS Location (Step 4/5)
```
← Location                           Step 4/5

[Progress bar: 80% filled]

"Your location (Auto-captured)"

╔════════════════════╗
║    📍 MAP VIEW     ║
║  [map with marker] ║
║                    ║
║  Latitude: 13...   ║
║  Longitude: 75...  ║
║  Accuracy: ±15m    ║
╚════════════════════╝

GPS Coordinates

┌──────────────────┐
│ Latitude: 13.1°N │
│ Longitude: 75.5°E│
│ Accuracy: ±15m   │
│ Time: 14:32:00   │
└──────────────────┘

[✓ Location Confirmed]
[🔄 Refresh Location]
```

**Design Specs:**
- Map: Full width, 240dp height, rounded corners
- Coordinates: Light Green card, monospace font
- Progress: 80% filled (Forest Green on Light Green)

#### Screen 7: Address & Description (Step 5/5)
```
← Details                            Step 5/5

[Progress bar: 100% filled]

"Add location details"

Nearby Landmark / Address
┌──────────────────────────┐
│ Near Kumara Parvatha...  │
└──────────────────────────┘

Description (What happened?)
┌──────────────────────────┐
│ Fire visible on hillside,│
│ spreading towards        │
│ village. Wind pushing    │
│ flames east.             │
└──────────────────────────┘

Character count: 87/500

☐ Report Anonymously
  (Don't show my contact)

[✓ Review Report]
[← Go Back]
```

**Design Specs:**
- Input fields: White, Light Green borders, 56dp
- Text area: Multi-line, 120dp height
- Character counter: Body Small, grey, right-aligned
- Checkbox: Forest Green when checked

#### Screen 8: Review Summary
```
← Review Report                      ✓

"Review your report before submitting"

┌────────────────────┐
│ INCIDENT TYPE      │
│ 🔥 Forest Fire     │
│ [Edit ↗]           │
└────────────────────┘

┌────────────────────┐
│ PHOTO              │
│ [📸 Thumbnail]     │
│ [Edit ↗]           │
└────────────────────┘

┌────────────────────┐
│ LOCATION           │
│ 📍 13.1234°N...    │
│ Accuracy: ±15m     │
│ [Edit ↗]           │
└────────────────────┘

┌────────────────────┐
│ DESCRIPTION        │
│ Fire visible...    │
│ [Edit ↗]           │
└────────────────────┘

[✓ Submit Report]
[← Back to Edit]

"Report will be sent to authorities"
```

**Design Specs:**
- Cards: Pale Green background, Light Green borders
- Edit links: Forest Green text, right-aligned
- Buttons: 56dp, full width

#### Screen 9: Submission Confirmation
```
        ✅ SUCCESS!

   Report Submitted
   Successfully!

Your report has been sent to the
forest department.

┌──────────────────┐
│ TRACKING ID      │
│                  │
│ FG-2024-001234   │
│                  │
│ [📋 Copy][🔗 S]  │
└──────────────────┘

You can track your report using
this ID anytime in "My Reports"

┌──────────────────┐
│ Next Steps:      │
│ ✓ Report queued  │
│ ✓ Rangers alerted│
│ 🔄 Status update │
│ 📲 Notifications │
└──────────────────┘

[✓ Track Report in App]
[🏠 Back to Home]

Thank you for protecting the
Western Ghats! 🌿
```

**Design Specs:**
- Success icon: 64dp, Success Green background circle
- ID card: Pale Green, monospace font (24sp)
- Information card: Light Green text on Pale Green background

#### Screen 10: Track Report Status
```
← My Reports

Status: FG-2024-001234          ✓

┌─────────────────┐
│ 🔥 Forest Fire  │
│ Kumara Area     │
│ 2 hours ago     │
└─────────────────┘

STATUS TIMELINE

✅ Reported
   Submitted 14:30
   Received by forest dept

✅ Verified
   Confirmed 14:45
   Real incident confirmed

🔄 Team Dispatched
   In transit since 15:00
   15 forest rangers en route

⭕ Resolved
   Waiting for arrival

┌──────────────────┐
│ LATEST UPDATE    │
│                  │
│ Team at location │
│ Assessing damage │
│ Updated 2 min ago│
└──────────────────┘

📍 Incident Location
╔═════════════════╗
║ 13.1234°N      ║
║ 75.5678°E      ║
║ [Click for map] ║
╚═════════════════╝

[📞 Contact Forest Dept]

💬 Comments (0)
[No comments yet]
```

**Design Specs:**
- Timeline: Vertical line, circles with icons
- Completed: Success Green checkmark
- In Progress: Earth Brown spinner
- Pending: Empty circle with Light Green border
- Update card: Pale Green background, Light Green border

### Typography

```
Display Large (32sp, Bold)      — App title only
Display Medium (24sp, Bold)     — Screen headers
Heading 1 (18sp, Bold)          — Card titles
Heading 2 (16sp, Semi-Bold)     — Subtitles
Body Large (16sp)               — Important text
Body Regular (14sp)             — Default body text
Body Small (12sp)               — Secondary text
Caption (10sp)                  — Metadata
Button (16sp, Semi-Bold)        — Button labels
```

### Components

**Primary Button**
- Size: 56dp height, full width
- Color: Medium Green (#40916C)
- Text: White, 16sp, Semi-Bold
- Corner radius: 8dp
- Padding: 16dp vertical, 24dp horizontal

**Secondary Button**
- Size: 48dp height, full width
- Border: 2dp Light Green
- Background: Transparent with hover effect
- Text: Forest Green, 16sp, Semi-Bold

**Input Field**
- Height: 56dp
- Background: White
- Border: 2dp Light Green (2dp Forest Green on focus)
- Padding: 16dp
- Corner radius: 8dp

**Card**
- Background: Pale Green (#D8F3DC)
- Border: 1dp Light Green
- Corner radius: 12dp
- Padding: 16dp
- Elevation: 2dp shadow

**FAB (Floating Action Button)**
- Size: 56dp diameter
- Color: Medium Green
- Icon: White, 24dp
- Corner radius: 28dp (circular)
- Position: Bottom-right, 16dp from edges
- Elevation: 8dp shadow

**Top App Bar**
- Height: 56dp
- Background: Forest Green
- Text: White, 20sp, Bold
- Elevation: 4dp shadow

### Spacing Grid

All spacing uses 8dp grid:
- 8dp — Micro spacing
- 16dp — Standard spacing (most common)
- 24dp — Large spacing (section breaks)
- 32dp — Extra large spacing

**Screen Padding:** 16dp from all edges
**Button Width:** Full width minus 32dp (16dp margins)

---

## 🛠 Tech Stack

**Programming Languages:**
- Kotlin / Java
- XML (Android layouts)
- JavaScript (Firebase functions - optional)

**Mobile Framework:**
- Android Studio 4.2+
- Jetpack Compose (Modern UI)
- Android SDK API 26+

**Key Libraries:**

| Component | Library | Version |
|-----------|---------|---------|
| **UI Framework** | Jetpack Compose | Latest |
| **Architecture** | MVVM + Repository | - |
| **Camera** | CameraX | Latest |
| **Location** | Google Play Services | 21.0+ |
| **Local Database** | Android Room | 2.5+ |
| **Cloud Database** | Firebase Firestore | Latest |
| **Authentication** | Firebase Auth | Latest |
| **Notifications** | Firebase Cloud Messaging | Latest |
| **Background Tasks** | WorkManager | 2.8+ |
| **State Management** | Kotlin Coroutines | Latest |
| **Testing** | JUnit + Mockito | Latest |

**Backend:**
- Firebase (Authentication, Firestore, Cloud Messaging)
- Google Cloud Platform (optional)

**Development Tools:**
- Git & GitHub
- Postman (API testing)
- Firebase Console
- Android Emulator / Physical devices

---

## 📦 Prerequisites

**System Requirements:**
- Windows / macOS / Linux
- RAM: 8GB minimum (16GB recommended)
- Storage: 10GB free space

**Software Required:**
1. **Java Development Kit (JDK)** 11+
   ```bash
   java -version
   ```

2. **Android Studio** (Latest version - 2024.1+)
   - Download: https://developer.android.com/studio

3. **Android SDK**
   - API Level 26 (Android 8.0) minimum
   - Target API Level 34 (Android 14) recommended

4. **Git**
   ```bash
   git --version
   ```

5. **Firebase Account**
   - Create free account: https://firebase.google.com
   - Enable: Firestore, Authentication, Cloud Messaging

6. **Gradle** (Comes with Android Studio)

---

## 🚀 Installation & Setup

### Step 1: Clone Repository

```bash
git clone https://github.com/your-username/sahyadri-samrakshane.git
cd sahyadri-samrakshane
```

### Step 2: Open in Android Studio

1. Android Studio → Open → Select project folder
2. Wait for Gradle sync to complete

### Step 3: Configure Firebase

**A. Create Firebase Project:**
1. Visit https://console.firebase.google.com
2. Create new project: "sahyadri-samrakshane"
3. Enable Google Analytics (optional)
4. Click "Create"

**B. Register Android App:**
1. Firebase Console → Android icon
2. Package name: `com.example.sahyadrisamrakshane`
3. App nickname: `ForestGuard`
4. Download `google-services.json`
5. Place in `app/` directory

**C. Enable Services:**

*Authentication:*
- Build → Authentication → Get Started
- Enable: Email/Password & Google Sign-In

*Firestore Database:*
- Build → Firestore Database
- Create Database
- Start in test mode
- Region: asia-south1

*Cloud Messaging:*
- Engage → Cloud Messaging
- Note server key for push notifications

### Step 4: Update Dependencies

Edit `app/build.gradle.kts`:

```kotlin
dependencies {
    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.0.0"))
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-messaging")
    
    // Jetpack
    implementation("androidx.compose.ui:ui:1.5.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.0")
    
    // Location & Camera
    implementation("com.google.android.gms:play-services-location:21.0.1")
    implementation("androidx.camera:camera-camera2:1.2.3")
    implementation("androidx.camera:camera-lifecycle:1.2.3")
    
    // Database
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    
    // Background sync
    implementation("androidx.work:work-runtime:2.8.1")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
```

### Step 5: Sync & Build

1. Click "Sync Now"
2. Wait for completion
3. Build → Build Project
4. Fix any errors (usually dependency issues)

---

## 📁 Project Structure

```
sahyadri-samrakshane/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/sahyadrisamrakshane/
│   │   │   │   ├── ui/                    # Jetpack Compose screens
│   │   │   │   │   ├── screens/
│   │   │   │   │   │   ├── LoginScreen.kt
│   │   │   │   │   │   ├── DashboardScreen.kt
│   │   │   │   │   │   ├── ReportScreen.kt
│   │   │   │   │   │   ├── CameraScreen.kt
│   │   │   │   │   │   ├── LocationScreen.kt
│   │   │   │   │   │   ├── DetailsScreen.kt
│   │   │   │   │   │   ├── ReviewScreen.kt
│   │   │   │   │   │   ├── ConfirmationScreen.kt
│   │   │   │   │   │   ├── StatusScreen.kt
│   │   │   │   │   │   └── EducationScreen.kt
│   │   │   │   │   └── components/
│   │   │   │   │       ├── Button.kt
│   │   │   │   │       ├── Card.kt
│   │   │   │   │       ├── TopBar.kt
│   │   │   │   │       └── StatusBadge.kt
│   │   │   │   ├── viewmodel/            # State management
│   │   │   │   │   ├── ReportViewModel.kt
│   │   │   │   │   ├── StatusViewModel.kt
│   │   │   │   │   └── AuthViewModel.kt
│   │   │   │   ├── repository/           # Data layer
│   │   │   │   │   ├── ReportRepository.kt
│   │   │   │   │   ├── UserRepository.kt
│   │   │   │   │   └── StatusRepository.kt
│   │   │   │   ├── database/             # Room Database
│   │   │   │   │   ├── entity/
│   │   │   │   │   │   ├── ReportEntity.kt
│   │   │   │   │   │   └── UserEntity.kt
│   │   │   │   │   ├── dao/
│   │   │   │   │   │   ├── ReportDao.kt
│   │   │   │   │   │   └── UserDao.kt
│   │   │   │   │   └── AppDatabase.kt
│   │   │   │   ├── network/              # Firebase integration
│   │   │   │   │   ├── FirebaseManager.kt
│   │   │   │   │   ├── AuthManager.kt
│   │   │   │   │   └── SyncManager.kt
│   │   │   │   ├── services/             # Background services
│   │   │   │   │   ├── LocationService.kt
│   │   │   │   │   ├── CameraService.kt
│   │   │   │   │   ├── NotificationService.kt
│   │   │   │   │   └── SyncWorker.kt
│   │   │   │   ├── utils/                # Utilities
│   │   │   │   │   ├── Constants.kt
│   │   │   │   │   ├── Helpers.kt
│   │   │   │   │   └── Extensions.kt
│   │   │   │   └── MainActivity.kt       # Entry point
│   │   │   ├── res/
│   │   │   │   ├── drawable/            # Icons & images
│   │   │   │   ├── values/
│   │   │   │   │   ├── colors.xml       # Green palette
│   │   │   │   │   ├── strings.xml      # Text strings
│   │   │   │   │   └── dimens.xml       # Dimensions
│   │   │   │   └── layout/              # (Optional XML layouts)
│   │   │   └── AndroidManifest.xml
│   │   ├── test/                        # Unit tests
│   │   └── androidTest/                 # Instrumented tests
│   ├── build.gradle.kts                 # Dependencies
│   └── google-services.json             # Firebase config (ADD THIS)
├── gradle/
├── build.gradle.kts
├── settings.gradle.kts
├── README.md
├── UI_DESIGN_SYSTEM.md                  # (Refer to this for UI details)
└── LICENSE
```

---

## 🔧 Firebase Configuration

### Firestore Structure

```
firestore-root/
├── users/
│   └── {userId}
│       ├── name: string
│       ├── email: string
│       ├── role: "citizen" | "officer"
│       ├── createdAt: timestamp
│       └── profilePhoto: string
├── reports/
│   └── {reportId}
│       ├── trackingId: string
│       ├── type: "fire" | "landslide" | "cutting" | "wildlife"
│       ├── description: string
│       ├── photoUrl: string
│       ├── latitude: number
│       ├── longitude: number
│       ├── address: string
│       ├── reporterId: string
│       ├── timestamp: timestamp
│       ├── status: "reported" | "verified" | "dispatched" | "resolved"
│       ├── verifiedAt: timestamp
│       ├── dispatchedAt: timestamp
│       └── resolvedAt: timestamp
└── educationTips/
    └── {tipId}
        ├── title: string
        ├── category: "fire" | "wildlife" | "landslide"
        ├── content: string
        └── order: number
```

### Security Rules

```javascript
rules_version = '2';
service cloud.firestore {
  match /databases/{database}/documents {
    
    match /users/{userId} {
      allow read, write: if request.auth.uid == userId;
    }
    
    match /educationTips/{document=**} {
      allow read: if request.auth != null;
    }
    
    match /reports/{reportId} {
      allow create: if request.auth != null;
      allow read: if request.auth.uid == resource.data.reporterId || 
                     get(/databases/$(database)/documents/users/$(request.auth.uid)).data.role == "officer";
      allow update: if get(/databases/$(database)/documents/users/$(request.auth.uid)).data.role == "officer";
    }
  }
}
```

---

## ▶️ How to Run

### Option 1: Android Emulator

```bash
# Create virtual device (if needed)
# Android Studio → Tools → Device Manager → Create device

# Run app
./gradlew installDebug

# Or use Android Studio's green ▶️ Run button
```

### Option 2: Physical Device

```bash
# Connect device via USB
adb devices

# Enable Developer Mode:
# Settings → About → Build Number (tap 7 times)
# Settings → Developer Options → USB Debugging (enable)

# Run app
./gradlew installDebug
```

### Option 3: Command Line

```bash
# Build APK
./gradlew assembleDebug

# View logs
adb logcat

# Clear cache
./gradlew clean
```

---

## 📖 Usage Guide

### For Citizens

**Step 1: Login**
```
1. Open app
2. Tap "Sign Up" or "Google Sign-In"
3. Enter email & password (or use Google)
4. Verify email if needed
5. Complete profile
```

**Step 2-6: Report Incident (5-Step Flow)**
- See [Reporting Flow](#reporting-flow-step-by-step) section below

**Step 7: Track Status**
```
1. Tap "My Reports" tab
2. View submitted reports
3. Tap report to see details
4. View status timeline
5. Get notifications on status changes
```

### For Forest Officers

**Step 1: Login**
```
1. Login with forest dept email
2. See "Officer Dashboard"
```

**Step 2: View Incidents**
```
1. Dashboard shows map with incidents
2. Click marker → see details
3. View photo, location, description
```

**Step 3: Respond**
```
1. Tap "Verify Incident"
2. Tap "Dispatch Team"
3. Select team size
4. Citizen gets notified
```

---

## 🎯 Reporting Flow (Step-by-Step)

### Complete 5-Step Journey

```
STEP 1: Select Incident Type
├─ Choose from 4 types (icons guide selection)
├─ Show description of each
└─ Progress: 20% filled bar

STEP 2: Take Photo
├─ Camera activates
├─ Live preview
├─ Capture button (circular, prominent)
├─ Or upload from gallery
└─ Progress: 40% filled bar

STEP 3: Confirm Photo
├─ Display photo with timestamp
├─ Show GPS coordinates
├─ Option to retake
└─ Progress: 60% filled bar

STEP 4: GPS Location
├─ Auto-capture precision coordinates
├─ Show on map
├─ Display accuracy radius
├─ Allow refresh if uncertain
└─ Progress: 80% filled bar

STEP 5: Add Details
├─ Landmark/address field
├─ Description text area (500 char limit)
├─ Optional: Report anonymously
├─ Character counter
└─ Progress: 100% filled bar

REVIEW SCREEN
├─ Show all details in cards
├─ Allow edit each section
├─ Summary of what will be sent
└─ Final submit button

CONFIRMATION
├─ Success message with animation
├─ Display Tracking ID (copyable)
├─ Show next steps
├─ Option to track report
└─ Option back to home

OFFLINE SCENARIO:
├─ If no internet: Save locally
├─ Show "Pending Sync" badge
├─ When signal returns: Auto-upload
├─ Update to "Synced" ✓
└─ User notified of sync success
```

---

## 🔌 API Integration

### Firebase Authentication

```kotlin
// Sign up
FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
    .addOnCompleteListener { task ->
        if (task.isSuccessful) {
            val userId = task.result.user?.uid
        }
    }

// Sign in
FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
    .addOnCompleteListener { task ->
        if (task.isSuccessful) {
            // User logged in
        }
    }
```

### Firestore Database

```kotlin
// Create report
val report = hashMapOf(
    "type" to "fire",
    "latitude" to 13.1234,
    "longitude" to 75.5678,
    "description" to "Fire description",
    "timestamp" to Timestamp.now(),
    "status" to "reported"
)

db.collection("reports").add(report)
    .addOnSuccessListener { documentReference ->
        val trackingId = documentReference.id
    }

// Listen for updates (real-time)
db.collection("reports").document(reportId)
    .addSnapshotListener { snapshot, error ->
        val status = snapshot?.get("status")
    }
```

### Location & Camera

```kotlin
// Get GPS coordinates
val fusedLocationClient = LocationServices.getFusedLocationProviderClient(context)
fusedLocationClient.lastLocation
    .addOnSuccessListener { location: Location? ->
        val latitude = location?.latitude
        val longitude = location?.longitude
    }

// Capture photo with CameraX
imageCapture.takePicture(
    ContextCompat.getMainExecutor(context),
    object : ImageCapture.OnImageCapturedCallback() {
        override fun onCaptureSuccess(image: ImageProxy) {
            val bitmap = image.toBitmap()
        }
    }
)
```

---

## 🏗️ Architecture

### MVVM + Repository Pattern

```
UI Layer (Jetpack Compose)
     ↓
ViewModel (State Management)
     ↓
Repository (Data Routing)
     ↙        ↘
Room DB    Firebase
(Local)    (Cloud)
```

### Offline-First Flow

```
1. User submits report
   ↓
2. ViewModel calls Repository
   ↓
3. Repository checks internet
   ↓
4. IF online:
   - Save to Firebase Firestore
   - Cache locally (Room)
ELSE:
   - Save locally only
   - Mark "Pending Sync"
   ↓
5. WorkManager monitors connectivity
   ↓
6. When signal returns:
   - Upload pending reports
   - Mark "Synced"
   ↓
7. Forest dept sees report on dashboard
   ↓
8. Officer updates status
   ↓
9. Firebase Cloud Messaging sends push
   ↓
10. User sees status update in app
```

---

## ✅ Testing

### Unit Tests

```bash
./gradlew test
./gradlew test --tests ReportViewModelTest
```

### Instrumented Tests

```bash
./gradlew connectedAndroidTest
```

### Manual Testing Checklist

- [ ] App launches without crash
- [ ] Login/logout works
- [ ] Photo capture works
- [ ] GPS coordinates display
- [ ] Submit report offline → syncs online
- [ ] Status updates in real-time
- [ ] Notifications received
- [ ] UI responsive on different screen sizes
- [ ] Touch targets > 48dp
- [ ] Color contrast WCAG AA compliant

---

## 🐛 Troubleshooting

### Gradle Sync Fails
```
Solution:
1. Check internet connection
2. File → Sync Now
3. ./gradlew clean && ./gradlew build
4. Verify google-services.json in app/ directory
```

### Firebase Connection Error
```
Solution:
1. Verify Firebase project created
2. Check google-services.json valid
3. Enable Firestore & Auth in Firebase Console
4. Check device has internet
5. Try disabling VPN/firewall temporarily
```

### GPS Returns Null
```
Solution:
1. Enable device Location services
2. Grant location permission to app
3. Use "High Accuracy" location mode
4. Wait 10+ seconds (GPS can be slow)
5. In emulator: Extended Controls → Location
```

### Photo Not Saving
```
Solution:
1. Grant camera & storage permissions
2. Check available storage (500MB+ free)
3. Verify file path correct
4. Check app has permission: android.permission.WRITE_EXTERNAL_STORAGE
```

### Push Notification Not Received
```
Solution:
1. Enable notifications in app settings
2. Turn off "Do Not Disturb"
3. Check Firebase Cloud Messaging configured
4. Verify device token saved in Firestore
5. Test with Firebase Console → Cloud Messaging
```

---

## 🤝 Contributing

**Want to contribute?**

1. Fork the repository
2. Create feature branch: `git checkout -b feature/your-feature`
3. Commit changes: `git commit -m "Add: feature description"`
4. Push branch: `git push origin feature/your-feature`
5. Create Pull Request

**Guidelines:**
- Follow Kotlin style guide
- Add unit tests for new features
- Update README if needed
- Test on multiple devices

---

## 📞 Contact & Support

**Project Maintainer:**
- Name: [Your Name]
- Email: [Your Email]
- GitHub: [Your GitHub]

**Internship Details:**
- Company: MindMatrix
- Duration: 15 Weeks
- Domain: Android App Development using GenAI

**For Issues:**
1. Check [Troubleshooting](#troubleshooting)
2. Create GitHub Issue
3. Review [UI_DESIGN_SYSTEM.md](UI_DESIGN_SYSTEM.md)
4. Contact maintainer

**Resources:**
- [Android Developer Docs](https://developer.android.com/docs)
- [Firebase Documentation](https://firebase.google.com/docs)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [UI Design System](UI_DESIGN_SYSTEM.md)

---

## 📄 License

MIT License - see LICENSE file for details

---

## 🚀 Quick Start Commands

```bash
# Clone
git clone [repo-url]

# Build
./gradlew build

# Test
./gradlew test

# Run
./gradlew installDebug

# Clean
./gradlew clean

# View logs
adb logcat
```

---

**Made with 🌿 for the Western Ghats**

*Last Updated: [Current Date]*

*For complete UI/UX design specifications, see [UI_DESIGN_SYSTEM.md](UI_DESIGN_SYSTEM.md)*
