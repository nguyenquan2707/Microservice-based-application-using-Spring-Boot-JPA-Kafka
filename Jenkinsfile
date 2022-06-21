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
        stage('Build stage') {
            steps {
                withMaven(maven : 'maven_3.1.0'){
                    bat 'mvn clean install'
                }
            }
        }
        stage('build docker image'){
            steps{
                script{
                     def wspace = env.WORKSPACE
                     echo wspace
                     bat "docker build -t img-pos-cust -f Customer-service/Dockerfile ."
              }
          }
        }
    }
}
