pipeline {
    agent any

    environment {
        // Ange lösenordet till postgres-användaren här
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
                
                // kör SQL via psql
                bat '''
                REM Visa vilka filer som finns (valfritt)
                dir

                REM Kör SQL-filen
                psql -U postgres -d postgres -f "sql\\wolf.sql"
                '''
            }
        }
    }
}


