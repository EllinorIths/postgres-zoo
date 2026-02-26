pipeline {
    agent any

    stages {
        stage('Run SQL') {
            steps {
                bat '''
                echo "Kör SQL..."
                dir
                psql -U postgres -d postgres -f wolf.sql
                '''
            }
        }
    }

}
