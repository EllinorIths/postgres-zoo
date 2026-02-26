pipeline {
    agent any

    environment {
        PGPASSWORD = 'postgres'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Hämtar koden från GitHub...'
                checkout scm
            }
        }

        stage('Run SQL') {
            steps {
                echo 'Kör wolf.sql på PostgreSQL...'
                
                bat '''
                REM Visa vilka filer som finns (valfritt)
                dir

                REM Kör SQL-filen med full sökväg till psql
                "C:\\Program Files\\PostgreSQL\\15\\bin\\psql.exe" -U postgres -d postgres -f "sql\\wolf.sql"
                '''
            }
        }
    }
}

