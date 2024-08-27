def call(String imageName, String tag, String credentialsId) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASSWORD')]) {
        sh "echo $DOCKER_PASSWORD | docker login -u $DOCKER_USER --password-stdin"
        sh "docker tag ${imageName}:${tag} ${DOCKER_USER}/${imageName}:${tag}"
        sh "docker push ${DOCKER_USER}/${imageName}:${tag}"
    }
}