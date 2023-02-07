sealed class AppBuildType {

    abstract val name: String

    object Debug : AppBuildType() {
        override val name = "debug"
    }

    object Qa : AppBuildType() {
        override val name = "qa"
    }

    object Release : AppBuildType() {
        override val name = "release"
    }

    companion object {
        fun getByName(name: String): AppBuildType {
            return listOf(Debug, Qa, Release).first {
                it.name.equals(name, ignoreCase = true)
            }
        }
    }
}
