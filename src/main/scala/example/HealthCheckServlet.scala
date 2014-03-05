package example

class HealthCheckServlet extends RestServlet {
  get("""^(/|/health-check)$""".r) {
    "ok"
  }
}
