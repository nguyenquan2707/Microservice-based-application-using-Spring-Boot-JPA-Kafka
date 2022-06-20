pipeline {
    agent any 
    stages {
        stage('checkout') {
            steps {
                echo 'checking out the application' 
                deleteDir()
                checkout scm
            }
        }
        stage('test') {
            steps {
                echo 'testing the application' 
            }
        }
        stage('deploy') {
            steps {
                echo 'deploying the application' 
            }
        }
    }
}
