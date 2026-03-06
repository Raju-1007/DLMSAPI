pipeline {


agent any

environment {
    COMPOSE_FILE = 'docker-compose.yml'
}

triggers {
    githubPush()
}

stages {

    stage('Clean Workspace') {
        steps {
            cleanWs()
        }
    }

    stage('Clone Repository') {
        steps {
            git branch: 'main', url: 'https://github.com/Raju-1007/DLMSAPI.git'
        }
    }

    stage('Build Login Service') {
        steps {
            dir('login_service') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Build Content Service') {
        steps {
            dir('content-service') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Build Analytics Service') {
        steps {
            dir('analytics-service') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Build Notification Service') {
        steps {
            dir('notification-service') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Build API Gateway') {
        steps {
            dir('api-gateway') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Build Config Server') {
        steps {
            dir('DbConfig') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Build Discovery Service') {
        steps {
            dir('discovery-service') {
                bat 'mvn clean package -DskipTests'
            }
        }
    }

    stage('Stop Old Containers') {
        steps {
            bat 'docker compose down'
        }
    }

    stage('Build Docker Images') {
        steps {
            bat 'docker compose build'
        }
    }

    stage('Deploy Microservices') {
        steps {
            script {
                try {
                    bat 'docker compose up -d'
                } catch (Exception e) {

                    echo "Deployment failed. Rolling back..."

                    bat 'docker compose down'
                    bat 'docker compose up -d'

                    error("Rollback completed")
                }
            }
        }
    }

    stage('Verify Running Containers') {
        steps {
            bat 'docker ps'
        }
    }

}

post {

    success {
        echo '==================================='
        echo 'DLMS Microservices Deployed Successfully'
        echo '==================================='
    }

    failure {
        echo '==================================='
        echo 'Deployment Failed. Check logs.'
        echo '==================================='
    }

    always {
        echo 'Pipeline Execution Finished.'
    }

}


}
