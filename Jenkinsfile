pipeline {
    agent any

    environment {
        DB_USER = credentials('postgres-user')   // Username/Password credential ID
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Hämtar koden från GitHub...'
                checkout scm
            }
        }

        stage('Build & Test (Maven + H2)') {
            steps {
                echo 'Bygger projektet och kör tester med H2...'
                bat '''
                mvnw clean test -Dspring.profiles.active=test
                '''
            }
        }

        stage('Run SQL (PostgreSQL)') {
            steps {
                echo 'Kör wolf.sql på PostgreSQL...'
                bat '''
                "C:\\Program Files\\PostgreSQL\\18\\bin\\psql.exe" ^
                -U %DB_USER_USR% ^
                -d postgres ^
                -f "sql\\wolf.sql"
                '''
            }
        }
    }
}


