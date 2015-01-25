package servlets

class HealthCheckServlet extends RestServlet {
  get("""^(/|/health-check)$""".r) {
    "ok"
  }
}
