def call(String packageManager = 'npm') {
    sh "${packageManager} audit --audit-level=critical"
}