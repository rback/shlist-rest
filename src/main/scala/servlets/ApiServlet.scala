package servlets

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class ApiServlet extends RestServlet with JacksonJsonSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  before() {
    contentType = formats("json")
  }

  get("/") {
    List(
      ShoppingList(List("Milk", "Bread", "Cheese")),
      ShoppingList(List("Butter", "Yeast", "Flour"))
    )
  }
}

case class ShoppingList(items: List[String])
