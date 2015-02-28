import com.typesafe.config.ConfigFactory
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.scalatra.servlet.ScalatraListener

object JettyLauncher extends App {
  val config = ConfigFactory.load(sys.props.get(org.scalatra.EnvironmentKey).getOrElse("local"))

  val server = new Server(config.getInt("PORT"))
  val context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS)
  context.setResourceBase("web/src/main/webapp")
  context.addEventListener(new ScalatraListener)
  server.setHandler(context)
  server.start()
  server.join()
}
