const http = require("http");
const fs = require("fs");
const path = require("path");

const root = __dirname;
const port = Number(process.env.PORT || 4173);
const types = {
  ".html": "text/html; charset=utf-8",
  ".css": "text/css; charset=utf-8",
  ".js": "application/javascript; charset=utf-8",
  ".json": "application/json; charset=utf-8"
};

function createServer() {
  return http.createServer((req, res) => {
    const urlPath = decodeURIComponent(new URL(req.url, `http://localhost:${port}`).pathname);
    const requested = urlPath === "/" ? "/index.html" : urlPath;
    const filePath = path.normalize(path.join(root, requested));
    const relativePath = path.relative(root, filePath);

    if (relativePath.startsWith("..") || path.isAbsolute(relativePath)) {
      res.writeHead(403);
      res.end("Forbidden");
      return;
    }

    fs.readFile(filePath, (error, content) => {
      if (error) {
        res.writeHead(404);
        res.end("Not found");
        return;
      }

      res.writeHead(200, { "Content-Type": types[path.extname(filePath)] || "text/plain; charset=utf-8" });
      res.end(content);
    });
  });
}

if (require.main === module) {
  createServer().listen(port, () => {
    console.log(`ForestGuard running at http://localhost:${port}`);
  });
}

module.exports = { createServer };
