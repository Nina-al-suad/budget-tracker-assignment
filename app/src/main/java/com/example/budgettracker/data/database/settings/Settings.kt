import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "settings")
data class Settings(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val monthlyBudget: Double,
    val currency: String,
    val showNotifications: Boolean
)
