def call(String environment) {
    if (environment == 'prod') {
        input message: "are you sure you want to deploy to production?", ok: "Deploy"
    }
}