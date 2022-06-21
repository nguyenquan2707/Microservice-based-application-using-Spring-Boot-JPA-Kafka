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
        stage('run docker compose file'){
            steps{
                script{
                    bat "docker-compose -f pos-docker-compose.yml up -d"
                }
            }
        }
        stage('Build stage') {
            steps {
                withMaven(maven : 'maven_3.1.0'){
                    bat 'mvn clean install'
                }
            }
        }
        stage('build docker images'){
            steps{
                script{
                     bat "docker build -t img-pos-cust -f Customer-service/Dockerfile ."
                     bat "docker build -t img-pos-inventory -f Inventory/Dockerfile ."
                     bat "docker build -t img-pos-sales -f Sales/Dockerfile ."
              }
          }
        }
    }
}
