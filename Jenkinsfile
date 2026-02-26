pipeline {
    agent any

    stages {
        stage('Run SQL') {
            steps {
                bat '''
                echo Kör SQL-script...
                set PGPASSWORD=postgres
                psql -U postgres -d postgres -f wolf.sql
                '''
            }
        }
    }

}



