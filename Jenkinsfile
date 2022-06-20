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
        stage('initialize params'){
            steps {
                script{
                    def pom = readMavenPom file: 'pom.xml'
                    appName = pom.name
                    appName = appName.toLowerCase()
                    echo "Appname: ${appName}"
                }
            }
        }
        stage('Build stage') {
            steps {
                withMaven(maven : 'maven_3.8.6'){
                    bat 'mvn clean install'
                } 
            }
        }
    }
}
