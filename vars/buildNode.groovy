def call(String packageManager = 'npm') {
    sh "${packageManager} install"
    sh "${packageManager} run build"
    sh "npx eslint src/ --max-warnings=0"
}