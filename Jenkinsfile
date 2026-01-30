pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'Java21'
    }

    environment {
        KUBECONFIG = '/var/jenkins_home/.kube/config'
        DOCKER_USER = 'dextre78'
    }

    stages {
        stage('Build Artifact') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build & Push') {
                    steps {
                        echo 'Construyendo y subiendo imagen a Docker Hub...'
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                            sh "docker login -u ${USER} -p ${PASS}"
                            sh "docker build -t ${DOCKER_USER}/micro-product-java:latest ."
                            sh "docker push ${DOCKER_USER}/micro-product-java:latest"
                        }
                    }
                }
        stage('Deploy to K8s') {
            steps {
            // Usamos kubectl directamente. La imagen ya está en el daemon de Docker
            sh 'kubectl apply -f deployment.yml'
            sh 'kubectl rollout restart deployment product-service'
                }
	    }
    }
}