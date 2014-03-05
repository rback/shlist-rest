import example.HealthCheckServlet
import org.scalatra._
import javax.servlet.ServletContext
import org.slf4j.LoggerFactory

class ScalatraBootstrap extends LifeCycle {
  val logger = LoggerFactory.getLogger(getClass)

  override def init(context: ServletContext) {
    context.mount(new HealthCheckServlet, "/")
  }
}
