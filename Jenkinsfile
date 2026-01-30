pipeline {
    agent any
    
    tools {
        maven 'Maven3'
        jdk 'Java21'
    }

    environment {
        KUBECONFIG = '/var/jenkins_home/.kube/config'
    }

    stages {
        stage('Build Artifact') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                // El nombre de la imagen debe coincidir con tu deployment.yml
                sh 'docker build -t micro-product-java:latest .'
            }
        }
        stage('Load Image to Minikube') {
            steps {
                // kube vea la imagen local
                sh 'minikube image load micro-product-java:latest'
            }
        }
        stage('Deploy to K8s') {
            steps {
                sh 'kubectl apply -f deployment.yml'
                // Forzamos el reinicio para que use la nueva compilación
                sh 'kubectl rollout restart deployment product-service'
            }
        }
    }
}