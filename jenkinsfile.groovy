pipeline {
    agent any

    stages {      
        stages {      
            stage('Test') {
            agent { docker 'adoptopenjdk/openjdk11:jdk-11.0.9.1_1' }
            steps {
                sh './mvnw package'
            }
        }
                stage('Build') {
            steps {
                    echo 'Compilando..'
            }
        }
        stage('Store') {
            steps {
                echo 'Armazenando....'
            }
        }
                stage('DeploY') {
            steps {
                echo 'Implantando....'
            }
        }
    }
}
}