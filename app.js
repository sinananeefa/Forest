const STORAGE_KEY = "forestguard-state-v1";

const incidentTypes = [
  { id: "fire", code: "FI", title: "Forest Fire", detail: "Rapid spreading flames, smoke, or burnt vegetation" },
  { id: "landslide", code: "LS", title: "Landslide", detail: "Earth, rock, or road collapse in hill regions" },
  { id: "cutting", code: "CT", title: "Illegal Cutting", detail: "Unauthorized felling, timber transport, or clearing" },
  { id: "wildlife", code: "WL", title: "Wildlife Sighting", detail: "Injured, displaced, or unsafe animal encounter" }
];

const tips = [
  { code: "FI", title: "Fire Safety", body: "Move cross-wind, stay on clear paths, avoid smoke valleys, and report visible flame direction." },
  { code: "WL", title: "Wildlife Encounters", body: "Keep distance, do not feed animals, avoid flash, and leave a clear escape route." },
  { code: "LS", title: "Landslide Readiness", body: "Watch cracks, fresh mud, tilted trees, blocked drains, and sudden stream changes." },
  { code: "CT", title: "Illegal Cutting", body: "Note vehicle direction, number of people, tool sounds, and avoid direct confrontation." }
];

const emptyDraft = {
  type: "fire",
  photoTaken: false,
  latitude: 13.1234,
  longitude: 75.5678,
  accuracy: 15,
  address: "",
  description: "",
  anonymous: false
};

const demoReports = [
  {
    id: "FG-2026-001234",
    type: "fire",
    title: "Forest Fire",
    address: "Kumara Parvatha Trail",
    description: "Smoke seen rising from the south ridge.",
    status: "verified",
    synced: true,
    createdAt: Date.now() - 7200000,
    latitude: 13.1234,
    longitude: 75.5678,
    accuracy: 15,
    anonymous: false
  },
  {
    id: "FG-2026-001233",
    type: "landslide",
    title: "Landslide",
    address: "Bisle Ghat Road",
    description: "Loose stones blocking part of the road.",
    status: "pending",
    synced: false,
    createdAt: Date.now() - 1800000,
    latitude: 12.7157,
    longitude: 75.6843,
    accuracy: 22,
    anonymous: false
  }
];

const state = loadState();
const app = document.querySelector("#app");
let toastTimer;

function loadState() {
  const saved = localStorage.getItem(STORAGE_KEY);
  if (saved) {
    return JSON.parse(saved);
  }

  return {
    screen: "login",
    tab: "home",
    user: null,
    reports: demoReports,
    draft: { ...emptyDraft },
    selectedReportId: "FG-2026-001234"
  };
}

function saveState() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify(state));
}

function navigate(screen, extras = {}) {
  Object.assign(state, extras, { screen });
  saveState();
  render();
}

function setTab(tab) {
  state.tab = tab;
  state.screen = "app";
  saveState();
  render();
}

function updateDraft(patch) {
  state.draft = { ...state.draft, ...patch };
  saveState();
}

function toast(message) {
  clearTimeout(toastTimer);
  const old = document.querySelector(".toast");
  if (old) old.remove();
  const node = document.createElement("div");
  node.className = "toast";
  node.textContent = message;
  document.body.appendChild(node);
  toastTimer = setTimeout(() => node.remove(), 2800);
}

function typeMeta(typeId) {
  return incidentTypes.find((item) => item.id === typeId) || incidentTypes[0];
}

function statusBadge(report) {
  if (!report.synced || report.status === "pending") return `<span class="badge pending">Pending Sync</span>`;
  if (report.status === "verified") return `<span class="badge success">Verified</span>`;
  if (report.status === "dispatched") return `<span class="badge progress">Team Dispatched</span>`;
  if (report.status === "resolved") return `<span class="badge success">Resolved</span>`;
  return `<span class="badge progress">Reported</span>`;
}

function timeAgo(timestamp) {
  const minutes = Math.max(1, Math.round((Date.now() - timestamp) / 60000));
  if (minutes < 60) return `${minutes} minutes ago`;
  const hours = Math.round(minutes / 60);
  if (hours < 24) return `${hours} hours ago`;
  return `${Math.round(hours / 24)} days ago`;
}

function layout(content, options = {}) {
  const title = options.title || "ForestGuard";
  const back = options.back;
  const top = options.noTopbar ? "" : `
    <header class="topbar">
      ${back ? `<button class="icon-button" data-action="${back}" aria-label="Back">‹</button>` : ""}
      <div class="topbar-title">${title}</div>
      ${options.right || ""}
    </header>
  `;

  return `
    <main class="phone-stage">
      ${top}
      ${content}
    </main>
  `;
}

function loginScreen() {
  return layout(`
    <section class="screen compact-bottom">
      <div class="brand-mark" aria-hidden="true"></div>
      <div class="center">
        <h1>ForestGuard</h1>
        <p class="muted">Login to protect our Western Ghats</p>
      </div>
      <form class="stack" data-form="login">
        <div class="field-group">
          <label for="email">Email address</label>
          <input id="email" class="input" type="email" value="citizen@forestguard.local" required>
        </div>
        <div class="field-group">
          <label for="password">Password</label>
          <input id="password" class="input" type="password" value="forest123" required>
        </div>
        <button class="primary" type="submit">Sign In</button>
      </form>
      <div class="divider">OR</div>
      <button class="secondary" data-action="google-login">Sign in with Google</button>
      <button class="quiet" data-action="signup">Do not have an account? Sign Up</button>
    </section>
  `, { title: "Forest Guard" });
}

function dashboardScreen() {
  const activeReports = state.reports.filter((report) => report.status !== "resolved").length;
  const verified = state.reports.filter((report) => report.status === "verified").length;
  const dispatched = state.reports.filter((report) => report.status === "dispatched").length;
  const reports = [...state.reports].sort((a, b) => b.createdAt - a.createdAt).slice(0, 4);

  return `
    <section class="screen">
      <h2>Welcome, ${state.user?.name || "Citizen"}!</h2>
      <p class="muted">Western Ghats Region</p>
      <div class="card">
        <div class="stats">
          <div class="stat"><strong>${activeReports}</strong><span>Active</span></div>
          <div class="stat"><strong>${verified}</strong><span>Verified</span></div>
          <div class="stat"><strong>${dispatched}</strong><span>Dispatched</span></div>
        </div>
      </div>
      <div class="section-title">Recent Activity</div>
      <div class="stack">
        ${reports.map(reportCard).join("")}
      </div>
      <button class="fab" data-action="start-report" aria-label="Report incident">+</button>
    </section>
  `;
}

function reportCard(report) {
  const meta = typeMeta(report.type);
  return `
    <article class="card report-card">
      <div class="report-icon">${meta.code}</div>
      <div>
        <h3>${escapeHtml(report.title)}</h3>
        <p class="muted">ID: ${report.id}</p>
        <p>${statusBadge(report)}</p>
        <p class="muted">${timeAgo(report.createdAt)} · ${escapeHtml(report.address)}</p>
        <button class="link-button" data-action="open-report" data-id="${report.id}">View Details</button>
      </div>
    </article>
  `;
}

function reportsScreen() {
  return `
    <section class="screen">
      <h2>My Reports</h2>
      <p class="muted">Track status updates and locally queued submissions.</p>
      <div class="stack">
        ${state.reports.map(reportCard).join("")}
      </div>
    </section>
  `;
}

function tipsScreen() {
  return `
    <section class="screen">
      <h2>Eco Safety Tips</h2>
      <p class="muted">Quick field guidance for safer reporting.</p>
      <div class="tips-grid">
        ${tips.map((tip) => `
          <article class="card tip-card">
            <div class="tip-icon">${tip.code}</div>
            <div>
              <h3>${tip.title}</h3>
              <p>${tip.body}</p>
            </div>
          </article>
        `).join("")}
      </div>
    </section>
  `;
}

function officerScreen() {
  return `
    <section class="screen">
      <h2>Officer Dashboard</h2>
      <p class="muted">Incident map, evidence, and response controls.</p>
      <div class="map-preview officer-map">
        <div class="map-path"></div>
        ${state.reports.map((report, index) => `
          <button class="incident-marker" style="left:${18 + index * 29}%; top:${30 + index * 18}%;" data-action="open-report" data-id="${report.id}">
            ${typeMeta(report.type).code} ${report.id.slice(-4)}
          </button>
        `).join("")}
      </div>
      <div class="section-title">Incoming Reports</div>
      <div class="stack">${state.reports.map(reportCard).join("")}</div>
    </section>
  `;
}

function appScreen() {
  const content = state.tab === "home" ? dashboardScreen()
    : state.tab === "reports" ? reportsScreen()
    : state.tab === "tips" ? tipsScreen()
    : officerScreen();

  return layout(`
    ${content}
    <nav class="bottom-nav" aria-label="Primary">
      ${navButton("home", "HM", "Home")}
      ${navButton("reports", "MR", "My Reports")}
      ${navButton("tips", "TP", "Tips")}
      ${navButton("officer", "OD", "Officer")}
    </nav>
  `, { title: state.tab === "officer" ? "Forest Officer" : "Forest Guard" });
}

function navButton(tab, glyph, label) {
  return `
    <button class="nav-item ${state.tab === tab ? "active" : ""}" data-tab="${tab}">
      <span class="nav-glyph">${glyph}</span>
      <span>${label}</span>
    </button>
  `;
}

function reportStepLayout(step, title, body) {
  const percent = Math.min(step * 20, 100);
  return layout(`
    <section class="screen">
      <div class="progress-wrap">
        <div class="progress-meta">
          <span>Step ${step}/5</span>
          <span>${percent}%</span>
        </div>
        <div class="progress-track"><div class="progress-fill" style="width:${percent}%"></div></div>
      </div>
      ${body}
    </section>
  `, { title, back: step === 1 ? "back-home" : "prev-step" });
}

function selectTypeScreen() {
  return reportStepLayout(1, "Report Incident", `
    <h2>What did you see?</h2>
    <p class="muted">Select the incident type so authorities can route it quickly.</p>
    <div class="stack">
      ${incidentTypes.map((item) => `
        <button class="incident-option ${state.draft.type === item.id ? "selected" : ""}" data-action="choose-type" data-type="${item.id}">
          <span class="report-icon">${item.code}</span>
          <span><strong>${item.title}</strong><br><span class="muted">${item.detail}</span></span>
        </button>
      `).join("")}
    </div>
    <div style="height:16px"></div>
    <button class="primary" data-action="next-step">Next: Take Photo</button>
  `);
}

function photoScreen() {
  return reportStepLayout(2, "Take Photo", `
    <h2>Take a clear photo</h2>
    <p class="muted">Capture visible evidence, while staying at a safe distance.</p>
    <div class="camera-preview"><strong>Camera preview simulation</strong></div>
    <div style="height:16px"></div>
    <button class="primary" data-action="capture-photo">Capture Photo</button>
    <div style="height:12px"></div>
    <button class="secondary" data-action="capture-photo">Upload from Gallery</button>
  `);
}

function confirmPhotoScreen() {
  return reportStepLayout(3, "Confirm Photo", `
    <h2>Photo looks good?</h2>
    <p class="muted">Evidence is stamped with location and time before submission.</p>
    <div class="photo-preview"></div>
    <div style="height:12px"></div>
    <div class="coords">
      Latitude: ${state.draft.latitude.toFixed(4)} N<br>
      Longitude: ${state.draft.longitude.toFixed(4)} E<br>
      Time: ${new Date().toLocaleString()}
    </div>
    <div style="height:16px"></div>
    <button class="primary" data-action="next-step">This Looks Good</button>
    <div style="height:12px"></div>
    <button class="secondary" data-action="retake-photo">Retake Photo</button>
  `);
}

function locationScreen() {
  return reportStepLayout(4, "Location", `
    <h2>Your location</h2>
    <p class="muted">Auto-captured coordinates can be refreshed before submission.</p>
    <div class="map-preview">
      <div class="map-path"></div>
      <div class="pin"></div>
    </div>
    <div style="height:12px"></div>
    <div class="coords">
      Latitude: ${state.draft.latitude.toFixed(4)} N<br>
      Longitude: ${state.draft.longitude.toFixed(4)} E<br>
      Accuracy: +/- ${state.draft.accuracy}m<br>
      Time: ${new Date().toLocaleTimeString()}
    </div>
    <div style="height:16px"></div>
    <button class="primary" data-action="next-step">Location Confirmed</button>
    <div style="height:12px"></div>
    <button class="secondary" data-action="refresh-location">Refresh Location</button>
  `);
}

function detailsScreen() {
  return reportStepLayout(5, "Details", `
    <h2>Add location details</h2>
    <p class="muted">Short, practical details help response teams find the spot.</p>
    <div class="field-group">
      <label for="address">Nearby landmark or address</label>
      <input id="address" class="input" value="${escapeAttr(state.draft.address)}" placeholder="Near Kumara Parvatha trail...">
    </div>
    <div class="field-group">
      <label for="description">Description</label>
      <textarea id="description" class="textarea" maxlength="500" placeholder="What happened?">${escapeHtml(state.draft.description)}</textarea>
      <div class="counter">${state.draft.description.length}/500</div>
    </div>
    <label class="checkbox-row">
      <input id="anonymous" type="checkbox" ${state.draft.anonymous ? "checked" : ""}>
      <span><strong>Report anonymously</strong><br><span class="muted">Do not show my contact to responders.</span></span>
    </label>
    <button class="primary" data-action="review-report">Review Report</button>
  `);
}

function reviewScreen() {
  const meta = typeMeta(state.draft.type);
  return layout(`
    <section class="screen">
      <h2>Review your report</h2>
      <p class="muted">Confirm all details before sending to forest authorities.</p>
      <div class="stack">
        ${summaryCard("Incident Type", `${meta.code} ${meta.title}`, "edit-type")}
        ${summaryCard("Photo", state.draft.photoTaken ? "Evidence photo attached" : "No photo captured", "edit-photo")}
        ${summaryCard("Location", `${state.draft.latitude.toFixed(4)} N, ${state.draft.longitude.toFixed(4)} E · +/- ${state.draft.accuracy}m`, "edit-location")}
        ${summaryCard("Description", state.draft.description || "No description added", "edit-details")}
        ${summaryCard("Reporter", state.draft.anonymous ? "Anonymous report" : "Contact visible to officers", "edit-details")}
      </div>
      <div style="height:16px"></div>
      <button class="primary" data-action="submit-report">Submit Report</button>
      <div style="height:12px"></div>
      <button class="secondary" data-action="edit-details">Back to Edit</button>
      <p class="center muted" style="margin-top:16px">Report will be sent to authorities and cached locally.</p>
    </section>
  `, { title: "Review Report", back: "details" });
}

function summaryCard(label, value, action) {
  return `
    <article class="card">
      <div class="summary-row">
        <div>
          <p class="muted" style="font-size:12px;font-weight:800;text-transform:uppercase">${label}</p>
          <h3>${escapeHtml(value)}</h3>
        </div>
        <button class="link-button" data-action="${action}">Edit</button>
      </div>
    </article>
  `;
}

function confirmationScreen() {
  const report = state.reports.find((item) => item.id === state.selectedReportId);
  return layout(`
    <section class="screen compact-bottom center">
      <div class="success-mark">✓</div>
      <h1>Report Submitted Successfully</h1>
      <p class="muted">Your report has been sent to the forest department queue.</p>
      <div class="card">
        <p class="muted" style="font-weight:800">TRACKING ID</p>
        <div class="tracking-id">${report.id}</div>
        <div class="button-row">
          <button class="secondary" data-action="copy-id" data-id="${report.id}">Copy</button>
          <button class="secondary" data-action="share-id" data-id="${report.id}">Share</button>
        </div>
      </div>
      <div style="height:12px"></div>
      <div class="card" style="text-align:left">
        <h3>Next Steps</h3>
        <p>✓ Report queued</p>
        <p>✓ Rangers alerted</p>
        <p>• Status update coming soon</p>
        <p>• Notification when verified</p>
      </div>
      <div style="height:16px"></div>
      <button class="primary" data-action="track-current">Track Report in App</button>
      <div style="height:12px"></div>
      <button class="secondary" data-action="back-home">Back to Home</button>
      <p class="muted" style="margin-top:18px">Thank you for protecting the Western Ghats.</p>
    </section>
  `, { noTopbar: true });
}

function statusScreen() {
  const report = state.reports.find((item) => item.id === state.selectedReportId) || state.reports[0];
  const stageIndex = report.status === "pending" || report.status === "reported" ? 0
    : report.status === "verified" ? 1
    : report.status === "dispatched" ? 2
    : 3;
  const steps = [
    ["Reported", "Received by forest department"],
    ["Verified", "Incident confirmed"],
    ["Team Dispatched", "Forest rangers en route"],
    ["Resolved", "Response completed"]
  ];

  return layout(`
    <section class="screen">
      <h2>Status: ${report.id}</h2>
      <article class="card report-card">
        <div class="report-icon">${typeMeta(report.type).code}</div>
        <div>
          <h3>${escapeHtml(report.title)}</h3>
          <p>${escapeHtml(report.address)}</p>
          <p class="muted">Reported ${timeAgo(report.createdAt)}</p>
          ${statusBadge(report)}
        </div>
      </article>
      <div class="section-title">Status Timeline</div>
      <div class="timeline">
        ${steps.map((step, index) => `
          <div class="timeline-step ${index < stageIndex ? "done" : index === stageIndex ? "current" : ""}">
            <div class="timeline-dot">${index < stageIndex ? "✓" : index === stageIndex ? "•" : ""}</div>
            <div>
              <h3>${step[0]}</h3>
              <p class="muted">${index <= stageIndex ? step[1] : "Waiting for update"}</p>
            </div>
          </div>
        `).join("")}
      </div>
      <div class="section-title">Latest Update</div>
      <div class="card">
        <p>${report.synced ? "Response desk is reviewing the incident details." : "Saved locally. It will sync automatically when connectivity returns."}</p>
        <p class="muted">Updated ${timeAgo(Date.now() - 120000)}</p>
      </div>
      <div class="section-title">Incident Location</div>
      <div class="map-preview">
        <div class="map-path"></div>
        <div class="pin"></div>
      </div>
      <div style="height:12px"></div>
      <div class="coords">
        Latitude: ${report.latitude.toFixed(4)} N<br>
        Longitude: ${report.longitude.toFixed(4)} E<br>
        Accuracy: +/- ${report.accuracy}m
      </div>
      <div style="height:16px"></div>
      <button class="secondary" data-action="contact-dept">Contact Forest Dept</button>
    </section>
  `, { title: "My Reports", back: "back-app" });
}

function render() {
  const html = state.screen === "login" ? loginScreen()
    : state.screen === "app" ? appScreen()
    : state.screen === "select-type" ? selectTypeScreen()
    : state.screen === "photo" ? photoScreen()
    : state.screen === "confirm-photo" ? confirmPhotoScreen()
    : state.screen === "location" ? locationScreen()
    : state.screen === "details" ? detailsScreen()
    : state.screen === "review" ? reviewScreen()
    : state.screen === "confirmation" ? confirmationScreen()
    : state.screen === "status" ? statusScreen()
    : appScreen();

  app.innerHTML = html;
  bindLiveInputs();
}

function bindLiveInputs() {
  const address = document.querySelector("#address");
  const description = document.querySelector("#description");
  const anonymous = document.querySelector("#anonymous");

  if (address) {
    address.addEventListener("input", (event) => updateDraft({ address: event.target.value }));
  }
  if (description) {
    description.addEventListener("input", (event) => {
      updateDraft({ description: event.target.value });
      const counter = document.querySelector(".counter");
      if (counter) counter.textContent = `${event.target.value.length}/500`;
    });
  }
  if (anonymous) {
    anonymous.addEventListener("change", (event) => updateDraft({ anonymous: event.target.checked }));
  }
}

document.addEventListener("submit", (event) => {
  if (event.target.matches('[data-form="login"]')) {
    event.preventDefault();
    const email = document.querySelector("#email").value;
    state.user = { name: email.split("@")[0] || "Citizen", email };
    state.screen = "app";
    state.tab = "home";
    saveState();
    render();
  }
});

document.addEventListener("click", async (event) => {
  const actionNode = event.target.closest("[data-action]");
  const tabNode = event.target.closest("[data-tab]");

  if (tabNode) {
    setTab(tabNode.dataset.tab);
    return;
  }

  if (!actionNode) return;
  const action = actionNode.dataset.action;

  if (action === "google-login" || action === "signup") {
    state.user = { name: "Forest Friend", email: "citizen@forestguard.local" };
    navigate("app", { tab: "home" });
  }
  if (action === "start-report") {
    state.draft = { ...emptyDraft };
    navigate("select-type");
  }
  if (action === "back-home") navigate("app", { tab: "home" });
  if (action === "back-app") navigate("app");
  if (action === "prev-step") {
    const order = ["select-type", "photo", "confirm-photo", "location", "details"];
    navigate(order[Math.max(0, order.indexOf(state.screen) - 1)]);
  }
  if (action === "next-step") {
    const next = {
      "select-type": "photo",
      "confirm-photo": "location",
      "location": "details"
    }[state.screen];
    if (next) navigate(next);
  }
  if (action === "choose-type") {
    updateDraft({ type: actionNode.dataset.type });
    render();
  }
  if (action === "capture-photo") {
    updateDraft({ photoTaken: true });
    navigate("confirm-photo");
  }
  if (action === "retake-photo" || action === "edit-photo") navigate("photo");
  if (action === "refresh-location") {
    updateDraft({
      latitude: Number((state.draft.latitude + (Math.random() - 0.5) / 1000).toFixed(4)),
      longitude: Number((state.draft.longitude + (Math.random() - 0.5) / 1000).toFixed(4)),
      accuracy: Math.floor(10 + Math.random() * 18)
    });
    toast("Location refreshed");
    render();
  }
  if (action === "review-report") {
    if (!state.draft.address.trim() || !state.draft.description.trim()) {
      toast("Add an address and short description before review.");
      return;
    }
    navigate("review");
  }
  if (action === "edit-type") navigate("select-type");
  if (action === "edit-location") navigate("location");
  if (action === "edit-details" || action === "details") navigate("details");
  if (action === "submit-report") submitReport();
  if (action === "open-report") {
    navigate("status", { selectedReportId: actionNode.dataset.id });
  }
  if (action === "track-current") navigate("status");
  if (action === "copy-id") {
    await navigator.clipboard?.writeText(actionNode.dataset.id);
    toast("Tracking ID copied");
  }
  if (action === "share-id") {
    if (navigator.share) {
      navigator.share({ title: "ForestGuard Tracking ID", text: actionNode.dataset.id });
    } else {
      toast("Share is not available in this browser.");
    }
  }
  if (action === "contact-dept") toast("Forest department contact: 1926");
});

function submitReport() {
  const meta = typeMeta(state.draft.type);
  const id = `FG-2026-${String(Math.floor(100000 + Math.random() * 899999))}`;
  const online = navigator.onLine;
  const report = {
    id,
    type: state.draft.type,
    title: meta.title,
    address: state.draft.address,
    description: state.draft.description,
    status: online ? "reported" : "pending",
    synced: online,
    createdAt: Date.now(),
    latitude: state.draft.latitude,
    longitude: state.draft.longitude,
    accuracy: state.draft.accuracy,
    anonymous: state.draft.anonymous
  };

  state.reports.unshift(report);
  state.selectedReportId = id;
  state.draft = { ...emptyDraft };
  saveState();
  render();
  navigate("confirmation");
}

window.addEventListener("online", () => {
  let changed = false;
  state.reports = state.reports.map((report) => {
    if (!report.synced) {
      changed = true;
      return { ...report, synced: true, status: "reported" };
    }
    return report;
  });
  if (changed) {
    saveState();
    toast("Pending reports synced");
    render();
  }
});

function escapeHtml(value) {
  return String(value).replace(/[&<>"']/g, (char) => ({
    "&": "&amp;",
    "<": "&lt;",
    ">": "&gt;",
    '"': "&quot;",
    "'": "&#039;"
  })[char]);
}

function escapeAttr(value) {
  return escapeHtml(value).replace(/"/g, "&quot;");
}

render();
