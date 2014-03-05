package example

import org.scalatra.ScalatraServlet

abstract class RestServlet extends ScalatraServlet {
  notFound {
    status = 404
    contentType = "text/plain"
    "not found"
  }
}