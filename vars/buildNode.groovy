def call(String packageManager = 'npm') {
    sh "${packageManager} install"
    sh "${packageManager} run build"
}