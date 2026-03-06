def call(String environment, String imageTag) {
    if (environment == 'prod') {
        input message: "do you want to deploy ${imageTag} to production?", ok: "yes"
    }
    echo "Deploying ${imageTag} to ${environment}"
    // will add kubernetes deployment commands here
}