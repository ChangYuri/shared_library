def call(String environment, String imageTag) {
    if (environment == 'prod') {
        input message: "do you want to deploy ${imageTag} to production?", ok: "yes"
    }
    echo "Deploying ${imageTag} to ${environment}"


    sh "kubectl set image deployment/${serviceName} ${serviceName}=yurichang/${serviceName}:${imageTag} -n ${environment}"
    sh "kubectl rollout status deployment/${serviceName} -n ${environment}"


    echo "Deploy successful ${imageTag} to ${environment} environment"
}