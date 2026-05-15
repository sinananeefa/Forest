# ForestGuard (Sahyadri-Samrakshane) - UI Design System

**Complete UI/UX Design Guide with Reporting Flow**

---

## 📋 Table of Contents

1. [Color Palette](#color-palette)
2. [Typography](#typography)
3. [Components](#components)
4. [Screens & Layouts](#screens--layouts)
5. [Reporting Flow (Step-by-Step)](#reporting-flow)
6. [Design Guidelines](#design-guidelines)
7. [Spacing & Layout](#spacing--layout)

---

## 🎨 Color Palette

### Primary Colors (Green Variants)

```
Forest Green (Dark - Primary)
HEX: #2D6A4F
RGB: 45, 106, 79
Usage: Headers, buttons, important elements, status indicators
Location: Top bars, action buttons, active states

Medium Green (Secondary)
HEX: #40916C
RGB: 64, 145, 108
Usage: Secondary buttons, hover states, dividers
Location: Card backgrounds, secondary CTAs, accents

Light Green (Tertiary)
HEX: #95D5B2
RGB: 149, 213, 178
Usage: Borders, subtle backgrounds, light accents
Location: Dividers, light backgrounds, borders

Pale Green (Very Light)
HEX: #D8F3DC
RGB: 216, 243, 220
Usage: Background cards, light backgrounds, disabled states
Location: Card backgrounds, section backgrounds

Earth Brown (Accent)
HEX: #7F5539
RGB: 127, 85, 57
Usage: Warning states, secondary accents
Location: Alert backgrounds, critical information
```

### Supporting Colors

```
Cream/Off-White (Background)
HEX: #FEFAE0
RGB: 254, 250, 224
Usage: App background, page background
Location: Entire app background

White
HEX: #FFFFFF
RGB: 255, 255, 255
Usage: Cards, dialog backgrounds
Location: Card backgrounds, modals

Dark Text
HEX: #1B1B1B
RGB: 27, 27, 27
Usage: Body text, headlines
Location: All text content

Medium Grey (Secondary Text)
HEX: #6B7280
RGB: 107, 178, 128
Usage: Placeholder text, secondary info
Location: Helper text, descriptions

Success Green
HEX: #059669
RGB: 5, 150, 105
Usage: Success messages, checkmarks
Location: Confirmation screens, status indicators

Warning Orange
HEX: #F4A261
RGB: 244, 162, 97
Usage: Warnings, cautionary messages
Location: Alert messages, pending states

Error Red
HEX: #DC2626
RGB: 220, 38, 38
Usage: Error states, critical alerts
Location: Error messages, critical warnings
```

### Color Usage Guide

| Component | Color | Use Case |
|-----------|-------|----------|
| **App Bar/Header** | Forest Green (#2D6A4F) | All top navigation bars |
| **Primary Button** | Medium Green (#40916C) | Main CTAs (Report, Submit) |
| **Secondary Button** | Light Green (#95D5B2) | Secondary actions |
| **Card Background** | Pale Green (#D8F3DC) | Incident cards, report cards |
| **Input Fields** | White (#FFFFFF) | Text input areas |
| **Divider** | Light Green (#95D5B2) | Separator lines |
| **Body Text** | Dark Text (#1B1B1B) | All body content |
| **Helper Text** | Medium Grey (#6B7280) | Placeholder, descriptions |
| **Success State** | Success Green (#059669) | Checkmarks, success messages |
| **Pending State** | Earth Brown (#7F5539) | Pending sync, waiting |
| **Active Tab** | Forest Green (#2D6A4F) | Current navigation tab |
| **Inactive Tab** | Medium Grey (#6B7280) | Non-active tabs |

---

## 🔤 Typography

### Font Family
- **Primary Font:** Roboto (San-serif)
- **Display Font:** Roboto Bold (Headings)
- **Monospace (optional):** Roboto Mono (Status IDs, coordinates)

### Font Sizes & Hierarchy

```
Display Large (Headings)
Size: 32sp
Weight: Bold (700)
Line Height: 1.2
Usage: App title, major section headers
Example: "Report an Incident"

Display Medium (Section Headers)
Size: 24sp
Weight: Bold (700)
Line Height: 1.3
Usage: Screen titles
Example: "Incident Details"

Heading 1 (Card Titles)
Size: 18sp
Weight: Bold (700)
Line Height: 1.4
Usage: Card titles, major sections
Example: "Select Incident Type"

Heading 2 (Subtitles)
Size: 16sp
Weight: Semi-Bold (600)
Line Height: 1.4
Usage: Screen subtitles, form sections
Example: "Take a Photo"

Body Large (Main Text)
Size: 16sp
Weight: Regular (400)
Line Height: 1.5
Usage: Body text, descriptions
Example: "Please take a clear photo of the incident"

Body Regular (Default)
Size: 14sp
Weight: Regular (400)
Line Height: 1.5
Usage: Primary body text, input labels
Example: Form labels, descriptions

Body Small
Size: 12sp
Weight: Regular (400)
Line Height: 1.4
Usage: Secondary text, helper text
Example: "Powered by GPS"

Caption (Smallest)
Size: 10sp
Weight: Regular (400)
Line Height: 1.3
Usage: Timestamps, metadata
Example: "Last updated: 2 hours ago"

Button Text
Size: 16sp
Weight: Semi-Bold (600)
Line Height: 1.2
Usage: Button labels
Example: "Take Photo", "Submit Report"
```

---

## 🧩 Components

### 1. Primary Button

```
Style: Medium Green (#40916C)
Size: 56dp height × full width
Corner Radius: 8dp
Text Color: White (#FFFFFF)
Text Style: Body Regular, Semi-Bold
Padding: 16dp vertical, 24dp horizontal
State:
  - Default: Medium Green
  - Hover: Forest Green (darker)
  - Pressed: Forest Green
  - Disabled: Light Grey, 50% opacity

Example: 
[═══════════════════════════════════]
[    🔴 Report an Incident         ]
[═══════════════════════════════════]
```

### 2. Secondary Button

```
Style: Light Green (#95D5B2) border, transparent background
Size: 48dp height × full width
Corner Radius: 8dp
Text Color: Forest Green (#2D6A4F)
Border: 2dp Light Green
Padding: 12dp vertical, 20dp horizontal
State:
  - Default: Light Green border
  - Hover: Medium Green background, 10% opacity
  - Pressed: Medium Green, 20% opacity

Example:
[─────────────────────────────────]
│  🔄 Upload Photo from Gallery   │
[─────────────────────────────────]
```

### 3. Input Field

```
Style: White (#FFFFFF) background
Border: 2dp Light Green (#95D5B2)
Corner Radius: 8dp
Height: 56dp
Padding: 16dp
Text Color: Dark Text (#1B1B1B)
Placeholder Color: Medium Grey (#6B7280)
Focus State:
  - Border Color: Forest Green (#2D6A4F)
  - Border Width: 2dp
  - Elevation: 4dp shadow

Example:
┌─────────────────────────────────┐
│ Enter address or landmark...     │
└─────────────────────────────────┘
```

### 4. Card Component

```
Background: Pale Green (#D8F3DC)
Corner Radius: 12dp
Elevation: 2dp shadow
Padding: 16dp
Border: 1dp Light Green (#95D5B2)
Content: Can hold text, images, buttons

Example:
╔═════════════════════════════════╗
║ 🔥 Forest Fire                  ║
║ Incident Type                   ║
╚═════════════════════════════════╝
```

### 5. Top App Bar

```
Background: Forest Green (#2D6A4F)
Height: 56dp
Padding: 16dp horizontal, 8dp vertical
Title Text: Bold, 20sp, White (#FFFFFF)
Icon Color: White (#FFFFFF)
Elevation: 4dp shadow

Example:
┌─────────────────────────────────┐
│ ← Report Incident               │
└─────────────────────────────────┘
```

### 6. Floating Action Button (FAB)

```
Background: Medium Green (#40916C)
Size: 56dp diameter
Icon Size: 24dp
Icon Color: White (#FFFFFF)
Elevation: 8dp shadow
Padding: 16dp
Corner Radius: 28dp (50% of size)
Location: Bottom-right corner, 16dp from edges

Position: Fixed at bottom-right
```

### 7. Chip/Tag Component

```
Background: Light Green (#95D5B2)
Text Color: Forest Green (#2D6A4F)
Height: 32dp
Padding: 8dp horizontal, 4dp vertical
Corner Radius: 16dp (pill shape)
Text Size: 12sp

States:
  - Default: Light Green background
  - Selected: Forest Green background, White text
  - Disabled: Light Grey, 50% opacity

Example (Incident Types):
[🔥 Fire]  [🌊 Landslide]  [🪓 Cutting]  [🦁 Wildlife]
```

### 8. Progress Indicator

```
Linear Progress Bar:
  - Height: 4dp
  - Background: Light Green (#95D5B2)
  - Progress Color: Forest Green (#2D6A4F)
  - Corner Radius: 2dp
  
Circular Progress (Loading):
  - Size: 48dp diameter
  - Color: Medium Green (#40916C)
  - Stroke Width: 4dp
```

### 9. Status Badge

```
Success State:
  - Background: Success Green (#059669)
  - Text: White
  - Icon: ✓ checkmark

Pending State:
  - Background: Earth Brown (#7F5539)
  - Text: White
  - Icon: ⏳ hourglass

Processing State:
  - Background: Medium Green (#40916C)
  - Text: White
  - Icon: ⚙️ spinner

Example:
┌─────────────────┐
│ ✓ Synced        │
│ Verified        │
└─────────────────┘
```

### 10. Dialog Box

```
Background: White (#FFFFFF)
Corner Radius: 12dp
Elevation: 16dp shadow
Padding: 24dp
Max Width: 80% of screen (max 400dp)

Title: Heading 2 (16sp, Bold)
Content: Body Regular (14sp)
Buttons: Primary + Secondary
Button Area Padding: 8dp top

Example:
╔═════════════════════════╗
║ Confirm Report          ║
║                         ║
║ Are you sure you want   ║
║ to submit this report?  ║
║                         ║
║ [Cancel]  [Submit]      ║
╚═════════════════════════╝
```

---

## 📱 Screens & Layouts

### Screen 1: Login/Home Screen

```
┌─────────────────────────────────┐
│  Forest Guard  (Logo)           │  ← Forest Green Bar
├─────────────────────────────────┤
│                                 │
│         🌿 Forest Guard         │
│    Protect Our Western Ghats    │
│                                 │
│   [Cream Background]            │
│                                 │
│                                 │
│  ┌───────────────────────────┐  │
│  │ 📧 Email Address          │  │
│  └───────────────────────────┘  │
│                                 │
│  ┌───────────────────────────┐  │
│  │ 🔐 Password               │  │
│  └───────────────────────────┘  │
│                                 │
│  ┌═══════════════════════════┐  │
│  │  Sign In                  │  │ ← Green Button
│  └═══════════════════════════┘  │
│                                 │
│  ─────────── OR ───────────     │
│                                 │
│  ┌───────────────────────────┐  │
│  │ 🔵 Sign in with Google    │  │
│  └───────────────────────────┘  │
│                                 │
│  Don't have account? Sign Up ↗  │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Top Bar: Forest Green (#2D6A4F), Height: 56dp
- Logo: Forest Guard + emoji 🌿
- Background: Cream (#FEFAE0)
- Input Fields: White, 56dp height, Light Green border
- Buttons: Medium Green, 56dp height
- Spacing: 24dp between elements

---

### Screen 2: Main Dashboard

```
┌─────────────────────────────────┐
│ ← Home                          │  ← Forest Green Bar
├─────────────────────────────────┤
│                                 │
│ Welcome, [User Name]! 👋        │
│ Western Ghats Region            │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ Active Reports: 3           │ │
│ │ Verified: 1 | Dispatched: 2 │ │
│ └─────────────────────────────┘ │
│                                 │
│ Recent Activity                 │ ← Medium Green Section Header
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🔥 Fire - Forest Area       │ │
│ │ ID: FG-2024-001234          │ │
│ │ Status: ✓ Verified          │ │
│ │ 2 hours ago                 │ │
│ │ ← View Details              │ │
│ └─────────────────────────────┘ │ ← Pale Green Card
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🌊 Landslide - Road         │ │
│ │ ID: FG-2024-001233          │ │
│ │ Status: ⏳ Pending Sync       │ │
│ │ 30 minutes ago              │ │
│ │ ← View Details              │ │
│ └─────────────────────────────┘ │
│                                 │
│                    ┌──────────┐ │
│                    │ ➕ Report │ │ ← FAB (Floating Action)
│                    └──────────┘ │
│                                 │
│ [Home]  [My Reports]  [Tips]    │ ← Bottom Tab Bar
│  ●       ○            ○         │
└─────────────────────────────────┘

Navigation Tabs (Bottom):
[🏠 Home]  [📋 My Reports]  [💡 Tips]
 Active ← Forest Green
```

**Design Specs:**
- Top Bar: Forest Green (#2D6A4F)
- Background: Cream (#FEFAE0)
- Cards: Pale Green (#D8F3DC) with Light Green borders
- Status Badges: Success Green (✓) / Earth Brown (⏳)
- FAB: Medium Green (#40916C), 56dp, bottom-right
- Bottom Tab: Forest Green for active, Grey for inactive

---

### Screen 3: Report Incident - Step 1 (Incident Type)

```
┌─────────────────────────────────┐
│ ← Report Incident      Step 1/5  │  ← Progress: 1/5
├─────────────────────────────────┤
│                                 │
│ What did you see?               │ ← Heading 1
│ Select incident type            │ ← Body Small (grey)
│                                 │
│ ┌▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓┐           │
│ ░░░░░░░░░░░░░░░░░░░ 20%       │ ← Progress Bar
│ └─────────────────────┘           │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🔥 Forest Fire              │ │
│ │ Rapid spread of flames      │ │
│ └─────────────────────────────┘ │ ← Pale Green Card (clickable)
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🌊 Landslide               │ │
│ │ Earth/rock collapse         │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🪓 Illegal Tree Cutting     │ │
│ │ Unauthorized felling        │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🦁 Wildlife Sighting        │ │
│ │ Animal encounter            │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌═══════════════════════════┐   │
│ │ Next: Take Photo          │   │ ← Medium Green Button
│ └═══════════════════════════┘   │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Top Bar: Shows "Step 1/5" progress
- Progress Bar: Light Green background, Forest Green fill
- Cards: Pale Green (#D8F3DC), 120dp height
- Selected Card: Forest Green border (2dp), highlight
- Icons: 48dp size, colorful emoji
- Button: Medium Green, 56dp, full width with 16dp margin
- Spacing: 16dp between cards

---

### Screen 4: Report Incident - Step 2 (Camera/Photo)

```
┌─────────────────────────────────┐
│ ← Take Photo         Step 2/5    │
├─────────────────────────────────┤
│                                 │
│ Take a clear photo              │ ← Title
│ of the incident                 │
│                                 │
│ ┌▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓┐           │
│ ░░░░░░░░░░░░░░░░░░░ 40%       │
│ └─────────────────────┘           │
│                                 │
│ ╔═════════════════════════════╗ │
│ ║                             ║ │
│ ║      CAMERA VIEW            ║ │ ← Camera Preview
│ ║    (Live feed here)         ║ │
│ ║                             ║ │
│ ║        📸                   ║ │
│ ║                             ║ │
│ ║  Take a clear, well-lit     ║ │
│ ║     photo of incident       ║ │
│ ║                             ║ │
│ ╚═════════════════════════════╝ │
│                                 │
│       ┌──────────────┐          │
│       │  📷 Capture  │          │ ← Capture Button
│       └──────────────┘          │   (Circle, 64dp, White on Green)
│                                 │
│ ┌───────────────────────────┐   │
│ │ 🖼️ Upload from Gallery    │   │ ← Secondary Button
│ └───────────────────────────┘   │
│                                 │
│ Allow camera access to proceed  │
│                                 │
└─────────────────────────────────┘

Camera Button Style:
- Shape: Circle (64dp diameter)
- Background: Medium Green (#40916C)
- Icon: 📷 (White, 32dp)
- Elevation: 8dp shadow
- Animation: Scale up on press
```

**Design Specs:**
- Camera Preview: Fills entire middle section
- Progress Bar: 40% filled
- Capture Button: Circular, 64dp, Medium Green
- Secondary Button: Light Green outline, 48dp
- Guidance Text: Small, centered, grey
- Permissions Banner: Light Yellow if camera permission needed

---

### Screen 5: Report Incident - Step 3 (Photo Review)

```
┌─────────────────────────────────┐
│ ← Confirm Photo      Step 3/5    │
├─────────────────────────────────┤
│                                 │
│ Photo looks good? 📸            │ ← Title
│                                 │
│ ┌▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓┐           │
│ ░░░░░░░░░░░░░░░░░░░ 60%       │
│ └─────────────────────┘           │
│                                 │
│ ╔═════════════════════════════╗ │
│ ║                             ║ │
│ ║     [Photo Preview]         ║ │ ← Photo Display
│ ║   📸 Forest Fire Evidence   ║ │   (320dp x 240dp)
│ ║                             ║ │
│ ║     Fire visible            ║ │
│ ║     Clear conditions        ║ │
│ ║                             ║ │
│ ╚═════════════════════════════╝ │
│                                 │
│ Photo taken at:                 │
│ 13.1234°N, 75.5678°E          │ ← GPS coordinates shown
│ 2024-01-15 14:32:00            │ ← Timestamp
│                                 │
│ ┌───────────────────────────┐   │
│ │ ✓ This looks good         │   │ ← Primary Button
│ └───────────────────────────┘   │
│                                 │
│ ┌───────────────────────────┐   │
│ │ 🔄 Retake Photo           │   │ ← Secondary Button
│ └───────────────────────────┘   │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Photo Area: 320dp width, 240dp height, rounded corners (8dp)
- Border: Light Green, 2dp
- Metadata: Body Small, grey text, centered
- Progress Bar: 60% filled (Forest Green on Light Green)
- Buttons: Full width with 16dp margin

---

### Screen 6: Report Incident - Step 4 (GPS Location)

```
┌─────────────────────────────────┐
│ ← Location          Step 4/5     │
├─────────────────────────────────┤
│                                 │
│ Your location                   │ ← Title
│ (Auto-captured)                 │
│                                 │
│ ┌▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓┐           │
│ ░░░░░░░░░░░░░░░░░░░ 80%       │
│ └─────────────────────┘           │
│                                 │
│ ╔═════════════════════════════╗ │
│ ║        📍 MAP VIEW          ║ │ ← Interactive Map
│ ║                             ║ │   (Shows incident location)
│ ║   [Small map with marker]   ║ │
│ ║                             ║ │
│ ║     Latitude: 13.1234°N    ║ │
│ ║     Longitude: 75.5678°E   ║ │
│ ║     Accuracy: ±15 meters   ║ │
│ ║                             ║ │
│ ╚═════════════════════════════╝ │
│                                 │
│ 📍 GPS Coordinates              │ ← Section Header
│                                 │
│ ┌─────────────────────────────┐ │
│ │ Latitude:   13.1234°N       │ │ ← Display fields
│ │ Longitude:  75.5678°E       │ │
│ │ Accuracy:   ±15 meters      │ │
│ │ Time:       14:32:00        │ │
│ └─────────────────────────────┘ │
│                                 │
│ 🔄 Acquiring accurate GPS...    │ ← Status (if loading)
│                                 │
│ ┌═══════════════════════════┐   │
│ │ ✓ Location Confirmed      │   │ ← Primary Button
│ └═══════════════════════════┘   │
│                                 │
│ ┌───────────────────────────┐   │
│ │ 🔄 Refresh Location       │   │ ← Secondary Button
│ └───────────────────────────┘   │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Map Area: Full width, 240dp height, rounded corners
- Coordinates Display: Light Green card, formatted mono font
- Accuracy Badge: Success Green if ±25m, Warning if worse
- Progress Bar: 80% filled
- GPS Icon: 📍 in Forest Green

---

### Screen 7: Report Incident - Step 5 (Address & Description)

```
┌─────────────────────────────────┐
│ ← Details              Step 5/5  │
├─────────────────────────────────┤
│                                 │
│ Add location details            │ ← Title
│                                 │
│ ┌▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓┐           │
│ ░░░░░░░░░░░░░░░░░░░ 100%      │
│ └─────────────────────┘           │
│                                 │
│ Nearby Landmark / Address       │ ← Label
│ ┌─────────────────────────────┐ │
│ │ Near Kumara Parvatha Peak.. │ │ ← White Input Field
│ └─────────────────────────────┘ │
│                                 │
│ Description                     │ ← Label
│ (What happened?)                │
│ ┌─────────────────────────────┐ │
│ │ Fire visible on hillside,   │ │ ← Text Area (4 lines)
│ │ spreading towards village.  │ │
│ │ Wind is pushing flames east.│ │
│ │                             │ │
│ └─────────────────────────────┘ │
│                                 │
│ Character count: 87/500         │ ← Helper text, grey
│                                 │
│ ☐ Report Anonymously            │ ← Checkbox option
│   (Don't show my contact info)   │
│                                 │
│ ┌═══════════════════════════┐   │
│ │ ✓ Review Report           │   │ ← Primary Button
│ └═══════════════════════════┘   │
│                                 │
│ ┌───────────────────────────┐   │
│ │ ← Go Back                 │   │ ← Secondary Button
│ └───────────────────────────┘   │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Input Fields: White bg, Light Green border, 56dp height
- Text Area: Multi-line, 120dp height, same styling
- Progress Bar: 100% filled (Full Forest Green)
- Character Counter: Body Small, grey, right-aligned
- Checkbox: Forest Green checked state
- Labels: Body Small, Dark text, bold
- Spacing: 16dp between sections

---

### Screen 8: Report Incident - Review Summary

```
┌─────────────────────────────────┐
│ ← Review Report               ✓ │ ← Complete Indicator
├─────────────────────────────────┤
│                                 │
│ Review your report              │ ← Title
│ before submitting               │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ INCIDENT TYPE               │ │ ← Card 1: Light Green BG
│ │ 🔥 Forest Fire              │ │
│ │ Evidence of rapid flames    │ │
│ │ [Edit ↗]                    │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ PHOTO                       │ │ ← Card 2: Photo Preview
│ │ [📸 Thumbnail Preview]      │ │
│ │ Clear photo with good light │ │
│ │ [Edit ↗]                    │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ LOCATION                    │ │ ← Card 3: Green Card
│ │ 📍 13.1234°N, 75.5678°E    │ │
│ │ Near Kumara Parvatha       │ │
│ │ Accuracy: ±15 meters       │ │
│ │ [Edit ↗]                    │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ DESCRIPTION                 │ │ ← Card 4: Summary
│ │ Fire visible on hillside,   │ │
│ │ spreading towards village.  │ │
│ │ Wind pushing flames east.   │ │
│ │ [Edit ↗]                    │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌═══════════════════════════┐   │
│ │ ✓ Submit Report           │   │ ← Primary Button (Green)
│ └═══════════════════════════┘   │
│                                 │
│ ┌───────────────────────────┐   │
│ │ ← Back to Edit            │   │ ← Secondary Button
│ └───────────────────────────┘   │
│                                 │
│ Your report will be sent to     │ ← Helper Text
│ forest authorities immediately  │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Cards: Pale Green (#D8F3DC) background, Light Green borders
- Edit Links: Forest Green text, right-aligned
- Photo Thumbnail: Rounded corners, 80dp x 60dp
- Button: Medium Green, 56dp, full width

---

### Screen 9: Report Submitted Confirmation

```
┌─────────────────────────────────┐
│                                 │ ← No top bar (full immersion)
│                                 │
│ ┌─────────────────────────────┐ │
│ │       ✅ SUCCESS!           │ │ ← Large Success Icon (64dp)
│ │                             │ │
│ │  Report Submitted           │ │ ← Success Message
│ │  Successfully!              │ │    (Heading 1)
│ └─────────────────────────────┘ │
│                                 │
│ Your report has been sent to    │ ← Description text
│ the forest department.          │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ TRACKING ID                 │ │ ← ID Card
│ │                             │ │
│ │ FG-2024-001234              │ │ ← Large mono font (24sp)
│ │                             │ │
│ │ [📋 Copy]  [🔗 Share]       │ │ ← Action buttons
│ └─────────────────────────────┘ │
│                                 │
│ You can track your report using │ ← Helper text
│ this ID anytime in "My Reports" │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ Next Steps:                 │ │ ← Information card
│ │ ✓ Your report is queued     │ │    (Pale Green bg)
│ │ ✓ Forest rangers alerted    │ │
│ │ 🔄 Status will update soon  │ │
│ │ 📲 You'll get notifications │ │
│ └─────────────────────────────┘ │
│                                 │
│ ┌═══════════════════════════┐   │
│ │ ✓ Track Report in App     │   │ ← Primary Button (Green)
│ └═══════════════════════════┘   │
│                                 │
│ ┌───────────────────────────┐   │
│ │ 🏠 Back to Home           │   │ ← Secondary Button
│ └───────────────────────────┘   │
│                                 │
│ Thank you for protecting the    │ ← Footer message
│ Western Ghats! 🌿              │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Success Icon: 64dp, Success Green (#059669) background circle
- Tracking ID Card: Pale Green background, monospace font (24sp)
- Copy/Share Buttons: Small, inline, 40dp
- Information Card: Light Green text on Pale Green background
- Buttons: Full width, 56dp, 16dp margins
- Animation: Slide up from bottom

---

### Screen 10: Tracking Report Status

```
┌─────────────────────────────────┐
│ ← My Reports                    │ ← Forest Green Bar
├─────────────────────────────────┤
│                                 │
│ Status: FG-2024-001234          │ ← Title with ID
│                                 │
│ ┌─────────────────────────────┐ │
│ │ 🔥 Forest Fire              │ │
│ │ Kumara Parvatha Area        │ │
│ │ Reported 2 hours ago        │ │
│ └─────────────────────────────┘ │
│                                 │
│ STATUS TIMELINE                 │ ← Section Header
│                                 │
│ ✅ Reported                     │ ← Step 1: Complete (Green checkmark)
│    Submitted 14:30              │
│    Received by forest dept      │
│                                 │
│ ✅ Verified                     │ ← Step 2: Complete
│    Confirmed at 14:45           │
│    Real incident confirmed      │
│                                 │
│ 🔄 Team Dispatched              │ ← Step 3: In Progress (Spinner)
│    In transit since 15:00       │
│    15 forest rangers en route   │
│                                 │
│ ⭕ Resolved                     │ ← Step 4: Pending (Empty circle)
│    Waiting for team arrival     │
│                                 │
│ ┌─────────────────────────────┐ │
│ │ LATEST UPDATE               │ │ ← Latest Update Card
│ │                             │ │
│ │ Team at incident location   │ │
│ │ Assessing damage            │ │
│ │ More updates coming soon    │ │
│ │                             │ │
│ │ Updated 2 minutes ago       │ │ ← Timestamp
│ └─────────────────────────────┘ │
│                                 │
│ 📍 Incident Location            │ ← Location Map
│ ╔═════════════════════════════╗ │
│ ║      13.1234°N              ║ │
│ ║      75.5678°E              ║ │
│ ║    [Click to open map]      ║ │
│ ╚═════════════════════════════╝ │
│                                 │
│ ┌───────────────────────────┐   │
│ │ 📞 Contact Forest Dept    │   │
│ └───────────────────────────┘   │
│                                 │
│ 💬 Comments (0)                 │
│ ┌─────────────────────────────┐ │
│ │ [No comments yet]           │ │
│ └─────────────────────────────┘ │
│                                 │
└─────────────────────────────────┘
```

**Design Specs:**
- Timeline Steps: Vertical line (Light Green), circles with icons
- Completed: Success Green checkmark circle
- In Progress: Earth Brown/Amber spinner
- Pending: Empty circle with Light Green border
- Update Card: Pale Green background, Light Green border
- Map Section: Interactive, tap to open full map
- Spacing: 16dp between timeline items

---

## 🎯 Reporting Flow (Complete User Journey)

### User Flow Diagram

```
START
  ↓
Login/Register
  ↓
[Dashboard]
  ↓
"Report Incident" FAB
  ↓
STEP 1: Select Incident Type
  ├─ Forest Fire
  ├─ Landslide
  ├─ Illegal Cutting
  └─ Wildlife Sighting
  ↓
STEP 2: Take Photo
  ├─ Camera activated
  ├─ Photo preview
  └─ Confirm photo
  ↓
STEP 3: GPS Location
  ├─ Auto-capture coordinates
  ├─ Map preview
  └─ Confirm location
  ↓
STEP 4: Address & Description
  ├─ Enter landmark/address
  ├─ Add description
  └─ Optional: Anonymity toggle
  ↓
STEP 5: Review Summary
  ├─ Review all details
  ├─ Edit any field
  └─ Submit report
  ↓
Confirmation Screen
  ├─ Show Tracking ID
  ├─ Show success message
  └─ Copy/Share ID
  ↓
Offline: Save locally + "Pending Sync" badge
Online: Upload to Firebase + "Synced" badge
  ↓
WorkManager syncs automatically when online
  ↓
Firebase Firestore receives report
  ↓
Forest Department Dashboard notified
  ↓
Push Notification: "Report Verified"
  ↓
User navigates to "My Reports" → View Status
  ↓
Status Timeline:
  - Reported ✅
  - Verified ✅
  - Team Dispatched 🔄
  - Resolved ⭕
  ↓
END
```

---

## 🎨 Design Guidelines

### Color Psychology (Why Green?)

✅ **Forest Green (#2D6A4F)** — Trust, stability, nature
✅ **Medium Green (#40916C)** — Growth, action, positivity
✅ **Light Green (#95D5B2)** — Calm, healing, balance
✅ **Pale Green (#D8F3DC)** — Peace, renewal, lightness

**Green for Environmental App:**
- Represents nature and forests
- Builds trust for environmental protection
- Calming for sensitive mental state (emergency reporting)
- Universally associated with "go/safe"

### Accessibility

**Color Contrast:**
- Text on backgrounds: Minimum 4.5:1 ratio (WCAG AA)
- Buttons: Minimum 3:1 ratio for non-text elements

**Text Size:**
- Minimum 12sp for body text
- Minimum 16sp for buttons
- Touch targets: Minimum 48dp x 48dp

**Dark Mode (Future):**
- Dark backgrounds: #121212
- Adjust green variants for dark backgrounds
- Keep high contrast

### Spacing & Rhythm

**Standard Spacing:**
```
4dp   — Micro spacing (gap between elements)
8dp   — Extra small spacing
12dp  — Small spacing
16dp  — Standard spacing (most common)
24dp  — Large spacing (section breaks)
32dp  — Extra large spacing (major sections)
```

**Padding:**
- Card padding: 16dp
- Button padding: 16dp vertical, 24dp horizontal
- Screen padding: 16dp from edges
- Input field padding: 16dp

**Corner Radius:**
- Buttons: 8dp
- Cards: 12dp
- Input fields: 8dp
- FAB: 28dp (circular)
- Chips: 16dp (pill shape)

### Typography Hierarchy

```
Display Large (32sp)  — Page title only
Display Medium (24sp) — Screen headers
Heading 1 (18sp)      — Card titles
Heading 2 (16sp)      — Section subtitles
Body Large (16sp)     — Important content
Body Regular (14sp)   — Primary content
Body Small (12sp)     — Secondary content
Caption (10sp)        — Metadata, timestamps
Button (16sp, Bold)   — Button labels
```

### Interactive States

**Button States:**
- **Default:** Medium Green (#40916C)
- **Hover:** Forest Green (#2D6A4F) with 1dp elevation increase
- **Pressed:** Forest Green with 8dp elevation
- **Disabled:** Light Grey (50% opacity)
- **Loading:** Spinner animation in button center

**Card States:**
- **Default:** Pale Green (#D8F3DC) background
- **Pressed:** 4dp elevation
- **Loading:** 30% opacity overlay
- **Selected:** Forest Green border (2dp)

**Input Field States:**
- **Default:** White background, Light Green border (2dp)
- **Focus:** White background, Forest Green border (2dp), 4dp shadow
- **Error:** White background, Error Red border (2dp)
- **Disabled:** Light Grey background, Light Grey border
- **Loading:** Spinner at end of input

### Animations

**Duration Guidelines:**
- Button press: 200ms
- Transition between screens: 300ms
- Loading spinner: 1500ms rotation
- Status update notification: 300ms slide-in
- FAB press: 150ms scale
- Card hover: 200ms elevation

**Easing:**
- Standard: Ease-in-out (cubic-bezier(0.4, 0.0, 0.2, 1.0))
- Entrance: Ease-out
- Exit: Ease-in

---

## 📏 Spacing & Layout Grid

### 8dp Grid System

All spacing and sizing should be multiples of 8dp:
- 8, 16, 24, 32, 40, 48, 56, 64, 72, 80...

**Screen Padding:** 16dp from all edges
**Standard Content Width:** Screen width - 32dp (16dp margin on each side)
**Card Margin:** 16dp
**Element Spacing:** 16dp

### Device Sizes

**Mobile Sizes Supported:**
- Small phones: 360dp width (minimum)
- Standard: 360-480dp width
- Large: 480-600dp width
- Extra Large: 600dp+ width

**Responsive Behavior:**
- Below 360dp: Not supported
- 360-600dp: Single column, full width
- 600dp+: Consider two-column layout (future)

### Safe Area Padding (Notch/Cutout Handling)

```
Top: 8dp additional padding
Bottom: 16dp additional padding (for navigation)
Left/Right: 4dp additional padding if notch present
```

---

## 📋 Summary

**Key Design Principles:**

✅ **Nature-First:** Green palette represents environmental mission
✅ **Clarity:** Simple, clean screens with clear CTAs
✅ **Accessibility:** Large touch targets, high contrast
✅ **Offline-Ready:** Clear pending/synced states
✅ **Trust-Building:** Professional, calming interface
✅ **Fast Reporting:** 5-step streamlined flow
✅ **Real-time Feedback:** Clear status updates

---

**UI Design Created For:**
- Project: Sahyadri-Samrakshane (ForestGuard)
- Company: MindMatrix
- Duration: 15 Weeks
- Domain: Android App Development using GenAI

---

This comprehensive UI Design System ensures consistent, professional, and user-friendly interface across the entire ForestGuard application!
