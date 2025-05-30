pipeline {
    agent any  // runs on any available Jenkins agent

    tools {
        maven 'Maven 3.9.9'    // You must configure this name in Jenkins > Tools
        jdk 'JDK 23'         // Or whatever version your project uses
    }

    stages {

        stage('Checkout Code') {
            steps {
                git branch: 'main', url: 'https://github.com/KarimS101/Selenium_Java.git'
            }
        }

        stage('Build and Run Tests') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Publish Extent Report') {
            steps {
              publishHTML([
              reportDir: 'target',               // directory containing the report file
              reportFiles: 'extent.html',  // exact report file name
              reportName: 'Extent Report',
              allowMissing: false,
              alwaysLinkToLastBuild: true,
              keepAll: true
          ])
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Optional: parse test results
            cleanWs() // clean workspace after every build
        }
    }
}