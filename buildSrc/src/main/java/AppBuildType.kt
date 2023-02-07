sealed class AppBuildType {

    abstract val name: String

    // TODO real base url
    open val baseUrl: String = ""

    object Debug : AppBuildType() {
        override val name = "debug"
    }

    object Qa : AppBuildType() {
        override val name = "qa"
    }

    object Demo : AppBuildType() {
        override val name = "demo"
    }

    object Release : AppBuildType() {
        override val name = "release"
    }

    companion object {
        fun getByName(name: String): AppBuildType {
            return listOf(Debug, Qa, Demo, Release).first {
                it.name.equals(name, ignoreCase = true)
            }
        }
    }
}
