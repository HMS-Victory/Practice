package jonathan_zollinger

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import io.micronaut.http.annotation.QueryValue
import java.net.URLDecoder
import java.nio.charset.StandardCharsets



@Suppress("unused")
@Controller("/product")
open class ProductController(private val productRepository: ProductRepository) {

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Suppress("unused")
    fun getProduct(id:Long): HttpResponse<Product> {
        val productOptional = productRepository.findById(id)
        println(productRepository)
        return if (productOptional.isPresent) {
            HttpResponse.ok(productOptional.get())
        } else {
            HttpResponse.notFound()
        }
    }

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Suppress("unused")
    fun getProductByName(@QueryValue name: String): HttpResponse<Product> {
        val decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8)
        val product = productRepository.findByProductName(decodedName)
        return if (null != product) {
            HttpResponse.ok(product)
        } else {
            HttpResponse.notFound()
        }
    }
}

@Suppress("unused")
@Controller("/order")
open class OrderController(private val orderRepository: OrderRepository){

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Suppress("unused")
    fun getOrder(id:Long): HttpResponse<Order> {
        val orderOptional = orderRepository.findById(id)
        println(orderRepository)
        return if (orderOptional.isPresent) {
            HttpResponse.ok(orderOptional.get())
        } else {
            HttpResponse.notFound()
        }
    }
}