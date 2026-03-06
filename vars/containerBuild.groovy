def call(String imageName, String imageTag) {
    sh "docker build -t ${imageName}:${imageTag} ."
    sh "docker tag ${imageName}:${imageTag} ${imageName}:latest"

    withCredentials([usernamePassword(
        credentialsId: 'dockerhub-credentials',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
        sh "docker push ${imageName}:${imageTag}"
        sh "docker push ${imageName}:latest"
    }
}