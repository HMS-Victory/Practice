package jonathan_zollinger

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.serde.annotation.Serdeable
import java.time.LocalDateTime

@Serdeable
@MappedEntity("products")
data class Product(
    @field:Id @field:JsonProperty("product_id") val productId: Long? = null,
    @field:JsonProperty("product_name") val productName: String,
    @field:JsonProperty("supplier_id") val supplierId: Long? = null,
    @field:JsonProperty("category_id") val categoryId: Long? = null,
    @field:JsonProperty("quantity_per_unit") val quantityPerUnit: String? = null,
    @field:JsonProperty("unit_price") val unitPrice: Double? = null,
    @field:JsonProperty("units_in_stock") val unitsInStock: Int? = null,
    @field:JsonProperty("units_on_order") val unitsOnOrder: Int? = null,
    @field:JsonProperty("reorder_level") val reorderLevel: Int? = null,
    val discontinued: Int
)

@Serdeable
@MappedEntity("orders")
data class Order(
    @field:Id @field:JsonProperty("order_id") val orderId: Long? =null,
    @field:JsonProperty("customer_id") val customerId: String,
    @field:JsonProperty("employee_id") val employeeId: Long? =null,
    //dates
    @field:JsonProperty("order_date") val orderDate: LocalDateTime? =null,
    @field:JsonProperty("required_date") val requiredDate: LocalDateTime? =null,
    @field:JsonProperty("shipped_date") val shippedDate: LocalDateTime? =null,
    //shipping information
    @field:JsonProperty("ship_via") val shipVia: Long? = null,
    @field:JsonProperty("freight") val freight: Double? =null,
    @field:JsonProperty("ship_name") val shipName: String? =null,
    @field:JsonProperty("ship_address") val shipAddress: String? =null,
    @field:JsonProperty("ship_city") val shipCity: String? =null,
    @field:JsonProperty("ship_region") val shipRegion: String? =null,
    @field:JsonProperty("ship_postal_code") val shipPostalCode: String? =null,
    @field:JsonProperty("ship_country") val shipCountry: String? =null,
)