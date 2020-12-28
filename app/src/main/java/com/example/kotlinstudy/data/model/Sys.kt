package dhkim.project.smallsafety.main.model.weatherModel

data class Sys (
    var type: Int,
    var id: Double,
    var country: String,
    var sunrise: Double,
    var sunset: Double
)