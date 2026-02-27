pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build with Maven') {
            steps {
                echo 'Bygger projektet med Maven och kör tester (H2)...'
                
                bat '''
                mvnw clean test
                '''
            }
        }
    }
}


