pipeline {

    agent any

    environment {
        COMPOSE_FILE = 'docker-compose.yml'
    }

    stages {

        stage('Clone Repository') {
            steps {
                git branch: 'main', url: 'https://github.com/Raju-1007/DLMSAPI.git'
            }
        }

        stage('Stop Old Containers') {
            steps {
                bat 'docker-compose down'
            }
        }

        stage('Build Docker Images') {
            steps {
                bat 'docker-compose build'
            }
        }

        stage('Start Containers') {
            steps {
                bat 'docker-compose up -d'
            }
        }

    }

    post {
        success {
            echo 'Microservices deployed successfully!'
        }
        failure {
            echo 'Deployment failed!'
        }
    }
}
