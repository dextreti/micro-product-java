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
		        echo 'Construyendo imagen con el nuevo Dockerfile...'
                // El nombre de la imagen debe coincidir con tu deployment.yml
                sh 'docker build -t micro-product-java:latest .'
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