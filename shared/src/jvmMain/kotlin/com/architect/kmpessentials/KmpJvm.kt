object KmpJvm {
    internal lateinit var runtime: JvmRuntime

    fun setJavaRuntime(runtime: JvmRuntime) {
        this.runtime = runtime
    }
}

