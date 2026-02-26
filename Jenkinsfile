pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo 'Hämtar koden från GitHub...'
                checkout scm
            }
        }

        stage('Run SQL') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'postgres-creds', 
                                                 usernameVariable: 'PGUSER', 
                                                 passwordVariable: 'PGPASSWORD')]) {
                    echo 'Kör wolf.sql på PostgreSQL...'
                    bat '''
                    REM Visa filer (valfritt)
                    dir

                    REM Kör SQL-filen
                    "C:\\Program Files\\PostgreSQL\\18\\bin\\psql.exe" -U %PGUSER% -d postgres -f "sql\\wolf.sql"
                    '''
                }
            }
        }
    }
}


