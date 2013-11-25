package controllers

import play.api._
import play.api.mvc._
import scala.util.Random
import play.api.libs.json.Json
import play.api.libs.ws._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  def index(productId: Long, guid: String) = Action.async {
//    val productDetailsUrl = """https://admin.gilt.com/admin/product/show/""" + productId
    val productDetailsUrl = """https://admin.gilt.com/admin/sku?product_id=""" + productId
    val request = WS.url(productDetailsUrl)
    
    val futureResponse : Future[Response] = request.get()

    futureResponse.map { response =>
      println(productDetailsUrl)
      println(response.body)
      val result = Ok(Json.obj("html" -> response.body))
      result.withHeaders("Accept" -> "*/*, text/javascript, text/javascript, text/html, application/xml, text/xml, */*")
      .withCookies(Cookies.decode("""sid=z_20130606_223431_64.70.114.88_33_45_75; csrf=vkfng9m2q6aagyyfvnrq3c9arhfmxygerrd4mn27; optimizelyEndUserId=oeu1370558071814r0.5731787027325481; __cmbU=ABJeb19oIQWFDMrNoXTTAN0iNbj2MVzJRj7AnbC8l1XQveRB3BYuHYi0boCfP45FZeEZKC2-_OQQSutxSezugCIJBVNzA629EQ; __qca=P0-1124181537-1373956210632; _city_hall_session=BAh7ByIQX2NzcmZfdG9rZW4iMXFhSnZUTVJDbXYwRFIzaXU0MmxCck5zU2JmZ3FFOEdKZVoxNnIyVExaaGs9Ig9zZXNzaW9uX2lkIiU5NTJjMDIzMDkyMjMzMDg2ZGI0OGUzOWQzNGYxM2MxMA%3D%3D--c8a9e3cdf32a959466655ae4b1445a28115f49ed; store=women; city_ids=; city_admin_window=; city_status_keys=; optimizelyCustomEvents=%7B%22oeu1370558071814r0.5731787027325481%22%3A%5B%22clicked_into_search%22%2C%22clicks_to_search%22%2C%22Add%20to%20Cart%22%5D%7D; clientId=1; fsr.r=%7B%22d%22%3A90%2C%22i%22%3A%22de37430-93231298-3129-30d0-5dae6%22%2C%22e%22%3A1385140920536%7D; _ga=GA1.2.2106135055.1370547097; tfcUserVisit=tfc-fitrec-product=12; test_bucket=704; JSESSIONID=hbms9u62c758dlf0t17xtmie; optimizelySegments=%7B%22172295518%22%3A%22referral%22%2C%22172325761%22%3A%22false%22%2C%22172810525%22%3A%22gc%22%2C%22172817896%22%3A%22none%22%2C%22282138152%22%3A%22true%22%7D; optimizelyBuckets=%7B%22317296248%22%3A%22317304235%22%2C%22355990732%22%3A%22355970762%22%2C%22357660731%22%3A%22357740728%22%2C%22389070119%22%3A%22389060165%22%2C%22444890065%22%3A%22411631932%22%7D; __utma=170966838.2106135055.1370547097.1385334951.1385336874.56; __utmb=170966838.4.9.1385337502059; __utmc=170966838; __utmz=170966838.1379008480.34.10.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=https%3A%2F%2Fadmin.gilt.com%2Fadmin%2Fcity; __utmv=170966838.|1=GUID=eabb52cc-aa25-4a9f-a658-758008a6a23c=1^2=Partition=213=1^9=gender=male=1^10=Group=5501%7C782%7C13456%7C5925%7C12362%7C13476%7C12866%7C5502%7C13419%7C704%7C700%7C769%7C3110%7C6751%7C5446%7C776%7C712%7C705%7C707%7C13284%7C13470%7C5228%7C13441%7C12391=1^12=Variant=login_reg_regwall%3Dmosaic%7Cloyalty_test%3Dfalse%2Ftrue=1^24=Visitor%20ID=v_20130606_183431_21_99_16=1; guid=4e3e8d7c2a2f26c67a3558a380e05c2b1a9b25437fb5376a48c4331637d42695_eabb52cc-aa25-4a9f-a658-758008a6a23c; ca=cc913668909ace2e53b4c65df7499c26c23223958207622e0bc0c493d5e45307_a.0.1.700.704.705.; cp=213; test_bucket_id=1576107891266457315; gender=m; upt=1385337527; pt=ff32b3e1fab6e04973d319f65b967dcf9f1ebd41afb4481a7a6721a360e2d867_eabb52cc-aa25-4a9f-a658-758008a6a23c_1385337530; fsr.s=%7B%22cp%22%3A%7B%22userId%22%3A%22c3a7d72cd90db0ab7880ac1566dd60a983f514ee223b58841fcf88909c011476107be8df9de0a9fce9b4f482e05a54f4fec8bf4ad7587528c68ee6608bc87d19%22%7D%2C%22v2%22%3A-2%2C%22v1%22%3A1%2C%22rid%22%3A%22de37430-93231298-3129-30d0-5dae6%22%2C%22to%22%3A5%2C%22pv%22%3A177%2C%22lc%22%3A%7B%22d0%22%3A%7B%22v%22%3A177%2C%22s%22%3Atrue%2C%22e%22%3A8%7D%7D%2C%22cd%22%3A0%2C%22f%22%3A1385337539980%2C%22sd%22%3A0%2C%22l%22%3A%22en%22%2C%22i%22%3A-1%7D"""):_*)
    }
  }

}