pipeline {
    agent any

    tools {
        // Este nombre debe ser IGUAL al que pusiste en tu captura (Maven3)
        maven 'Maven3'
	jdk 'Java21'
    }

    stages {
        stage('Preparación') {
            steps {
                echo 'Limpiando entorno...'
                sh 'mvn clean'
            }
        }
        stage('Compilación y Tests') {
            steps {
                echo 'Compilando proyecto Java...'
                // Ejecutamos el build
                sh 'mvn install -DskipTests'
            }
        }
        stage('Verificación Docker') {
            steps {
                // Solo para verificar que Jenkins puede usar Docker de tu Debian
                sh 'docker --version'
            }
        }
    }
}