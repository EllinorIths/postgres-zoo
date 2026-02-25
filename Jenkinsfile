pipeline {
    agent any

    stages {
        stage('Run SQL') {
            steps {
                sh '''
                echo "Kör SQL..."
                ls
                psql -U postgres -d postgres -f wolf.sql
                '''
            }
        }
    }
}