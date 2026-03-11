def call(String environment, String imageTag) {
    if (environment == 'prod') {
        input message: "do you want to deploy ${imageTag} to production?", ok: "yes"
    }
    echo "Deploying ${imageTag} to ${environment}"


    def services = ['frontend', 'order-service', 'product-service']
    
    for (service in services) {
        sh """
            kubectl set image deployment/${service} \
            ${service}=yurichang/${service}:${imageTag} \
            -n ${environment}
        """
    }
    
    for (service in services) {
        sh "kubectl rollout status deployment/${service} -n ${environment}"
    }

    echo "Deploy successful ${imageTag} to ${environment} environment"
}